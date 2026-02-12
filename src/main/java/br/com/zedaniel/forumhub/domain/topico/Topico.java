package br.com.zedaniel.forumhub.domain.topico;

import br.com.zedaniel.forumhub.domain.ValidacaoException;
import br.com.zedaniel.forumhub.domain.autor.Autor;
import br.com.zedaniel.forumhub.domain.autor.AutorRepository;
import br.com.zedaniel.forumhub.domain.curso.Curso;
import br.com.zedaniel.forumhub.domain.curso.CursoRepository;
import br.com.zedaniel.forumhub.domain.resposta.Resposta;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Resposta> respostas;

    public void atualizar(@Valid DadosAtualizacaoTopico dados, Curso curso) {
        this.curso = curso;
        this.mensagem = dados.mensagem();
        this.titulo = dados.titulo();
    }
}
