package br.com.zedaniel.forumhub.controller;

import br.com.zedaniel.forumhub.domain.topico.DadosCadastroTopico;
import br.com.zedaniel.forumhub.domain.topico.Topico;
import br.com.zedaniel.forumhub.domain.topico.TopicoRepository;
import br.com.zedaniel.forumhub.domain.topico.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroTopico dados){
        var topico = service.construir(dados);
        repository.save(topico);

        return ResponseEntity.ok(dados);
    }
}
