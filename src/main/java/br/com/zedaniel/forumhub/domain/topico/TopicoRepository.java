package br.com.zedaniel.forumhub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTitulo(String titulo);
    Boolean existsByMensagem(String mensagem);
}
