package br.com.zedaniel.forumhub.domain.curso;

import org.springframework.stereotype.Service;

@Service
public class CursoService {

    public Curso construir(DadosCadastroCurso dados){
        return new Curso(null, dados.nome(), dados.categoria());
    }
}
