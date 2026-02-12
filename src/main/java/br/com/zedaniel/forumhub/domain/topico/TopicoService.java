package br.com.zedaniel.forumhub.domain.topico;

import br.com.zedaniel.forumhub.domain.ValidacaoException;
import br.com.zedaniel.forumhub.domain.autor.AutorRepository;
import br.com.zedaniel.forumhub.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class TopicoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topico construir(DadosCadastroTopico dados){
        if(!autorRepository.existsById(dados.idAutor())){
            throw new ValidacaoException("Não existe autor com o id informado!");
        }

        if(!cursoRepository.existsById(dados.idCurso())){
            throw new ValidacaoException("Não existe curso com o id informado!");
        }

        return new Topico(null, dados.titulo(), dados.mensagem(), LocalDateTime.now(), Status.ABERTO,
                autorRepository.getReferenceById(dados.idAutor()), cursoRepository.getReferenceById(dados.idCurso()),
                new ArrayList<>());
    }
}
