package br.com.zedaniel.forumhub.domain.topico;

import br.com.zedaniel.forumhub.domain.ValidacaoException;
import br.com.zedaniel.forumhub.domain.autor.AutorRepository;
import br.com.zedaniel.forumhub.domain.curso.CursoRepository;
import br.com.zedaniel.forumhub.domain.topico.validacoes.ValidadorCadastroTopico;
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
    private List<ValidadorCadastroTopico> validadoresDeCadastro;

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
}
