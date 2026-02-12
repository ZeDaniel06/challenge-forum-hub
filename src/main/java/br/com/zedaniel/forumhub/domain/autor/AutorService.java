package br.com.zedaniel.forumhub.domain.autor;

import org.springframework.stereotype.Service;

@Service
public class AutorService {
    public Autor construir(DadosCadastroAutor dados) {
        return new Autor(null, dados.nome(), dados.email(), dados.senha());
    }
}
