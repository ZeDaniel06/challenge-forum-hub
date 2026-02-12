package br.com.zedaniel.forumhub.domain.topico;

import br.com.zedaniel.forumhub.domain.ValidacaoException;
import br.com.zedaniel.forumhub.domain.autor.AutorRepository;
import br.com.zedaniel.forumhub.domain.curso.CursoRepository;
import br.com.zedaniel.forumhub.domain.topico.validacoes.ValidadorAtualizacaoTopico;
import br.com.zedaniel.forumhub.domain.topico.validacoes.ValidadorCadastroTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorCadastroTopico> validadoresDeCadastro;

    @Autowired
    private List<ValidadorAtualizacaoTopico> validadoresDeAtualizacao;

    public Topico construir(DadosCadastroTopico dados){
        if(!autorRepository.existsById(dados.idAutor())){
            throw new ValidacaoException("Não existe autor com o id informado!");
        }

        if(!cursoRepository.existsById(dados.idCurso())){
            throw new ValidacaoException("Não existe curso com o id informado!");
        }

        validadoresDeCadastro.forEach(v -> v.validar(dados));

        return new Topico(null, dados.titulo(), dados.mensagem(), LocalDateTime.now(), Status.ABERTO,
                autorRepository.getReferenceById(dados.idAutor()), cursoRepository.getReferenceById(dados.idCurso()),
                new ArrayList<>());
    }

    public Topico retornar(Long id) {
        if(!topicoRepository.existsById(id)){
            throw new ValidacaoException("Não existe tópico com o id informado!");
        }

        return topicoRepository.findById(id).get();
    }

    public void atualizar(Long id, @Valid DadosAtualizacaoTopico dados) {

        if(topicoRepository.findById(id).isEmpty()){
            throw new ValidacaoException("Não existe tópico com este id!");
        }

        if(!cursoRepository.existsById(dados.idCurso())){
            throw new ValidacaoException("Não existe curso com este id!");
        }

        var curso = cursoRepository.getReferenceById(dados.idCurso());

        validadoresDeAtualizacao.forEach(v -> v.validar(dados));

        var topico = topicoRepository.getReferenceById(id);
        topico.atualizar(dados, curso);


    }
}
