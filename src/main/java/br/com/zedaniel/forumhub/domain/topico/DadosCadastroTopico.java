package br.com.zedaniel.forumhub.domain.topico;

public record DadosCadastroTopico(String titulo,
                                  String mensagem,
                                  Long idAutor,
                                  Long idCurso) {
}
