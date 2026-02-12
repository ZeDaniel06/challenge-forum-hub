package br.com.zedaniel.forumhub.domain.resposta;

import br.com.zedaniel.forumhub.domain.topico.Topico;
import jakarta.persistence.*;

@Entity
@Table(name = "respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;
}
