package br.com.zedaniel.forumhub.domain.topico.validacoes;

import br.com.zedaniel.forumhub.domain.topico.DadosAtualizacaoTopico;

public interface ValidadorAtualizacaoTopico {
    void validar(DadosAtualizacaoTopico dados);
}
