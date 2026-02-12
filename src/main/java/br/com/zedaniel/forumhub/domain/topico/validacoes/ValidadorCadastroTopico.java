package br.com.zedaniel.forumhub.domain.topico.validacoes;

import br.com.zedaniel.forumhub.domain.topico.DadosCadastroTopico;

public interface ValidadorCadastroTopico {
    void validar(DadosCadastroTopico dados);
}
