package br.com.zedaniel.forumhub.domain.topico.validacoes;

import br.com.zedaniel.forumhub.domain.ValidacaoException;
import br.com.zedaniel.forumhub.domain.topico.DadosAtualizacaoTopico;
import br.com.zedaniel.forumhub.domain.topico.DadosCadastroTopico;
import br.com.zedaniel.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaTituloOuMensagemUpdate implements ValidadorAtualizacaoTopico{

    @Autowired
    private TopicoRepository repository;

    public void validar(DadosAtualizacaoTopico dados){
        if(repository.existsByTitulo(dados.titulo())){
            throw new ValidacaoException("Já existe um tópico com este título!");
        }
        if(repository.existsByMensagem(dados.mensagem())){
            throw new ValidacaoException("Já existe um tópico com esta mensagem!");
        }
    }
}
