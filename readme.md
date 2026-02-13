<h1>Challenge Forum Hub</h1>
<p>Este projeto foi desenvolvido como entrega
de um challenge do programa Oracle One, um programa
em parceria com a Alura.</p>
<br>
<p>
O projeto se trata de um CRUD desenvolvido com
Springboot com funcionalidades de um Fórum.
</p>

<h3>Tecnologias</h3>
<ul>
<li>Spring Security + JWT</li>
<li>Migrations com Flyway</li>
<li>Banco MySQL</li>
<li>Validações com Bean Validation</li>
</ul>

<h3>Instruções</h3>
<p>Esta documentação ainda vai ser melhorada,
mas a princípio, estarão descritas abaixo
as requisições. Para todas elas, com exceção da
de login, será necessária a autenticação com
token, que é obtido através do próprio login.
Primeiramente deve-se criar as devidas variáveis
de ambiente que estão sendo informadas no
application.properties, para preencher os dados
do banco de dados, em seguida, deve-se criar
manualmente o database com o nome que foi informado
na variável ${NAME_DB}. Após isto, insira via
consulta direta ao MySQL um usuário com o
seguinte comando:
insert into usuarios values(1, 'SEU_LOGIN', 'SUA_SENHA');
Garanta que a senha esteja encriptada com BCrypt, já que
a validação de senha conta com esta encriptação.
Após isso você pode ativar o servidor e começar as requisições,
começando com a de login. Se logado corretamente, você
vai receber um token, que deve ser inserido no
Header authorization como bearer token, para as outras
requisições.
Pode utilizar Postman ou Insomnia para as requisições.
A seguir, as descrições de como deve ser o JSON no
body de cada uma:
</p>

<h3>Login</h3>
<h4>Endpoint POST</h4>
<p>http://localhost:8080/login</p>
<h4>Body</h4>
<p>
{
	"login":"LOGIN",
	"senha":"SENHA_COM_BCRYPT"
}
</p>


<h3>Curso</h3>
<h4>Endpoint POST</h4>
<p>http://localhost:8080/cursos</p>
<h4>Body</h4>
<p>
{
	"nome":"NOMEDOCURSO",
	"categoria":"CATEGORIADOCURSO"
}

Obs: Confira o enum de CategoriaCurso para ver as opções
de categoria.
</p>

<h3>Autor</h3>
<h4>Endpoint POST</h4>
<p>http://localhost:8080/autores</p>
<h4>Body</h4>
<p>
{
	"nome":"NOME",
	"email":"EMAIL",
	"senha":"SENHABCRYPT"
}
</p>

<h3>Tópico</h3>
<p>Antes de registrar um tópico, é necessário que tenha
pelo menos 1 curso e 1 autor registrado.</p>
<h4>Endpoint POST</h4>
<p>http://localhost:8080/topicos</p>
<h4>Body</h4>
<p>
{
	"titulo":"TITULO",
	"mensagem":"MENSAGEM",
	"idAutor":IDDOAUTOR,
	"idCurso":IDDOCURSO

}
</p>

<h4>Endpoint PUT</h4>
<p>http://localhost:8080/topicos/{id}</p>
<h4>Body</h4>
<p>
{
	"titulo":"TITULO",
	"mensagem":"MENSAGEM",
	"idCurso": IDCURSO
}
</p>

<h4>Endpoint GET</h4>
<p>http://localhost:8080/topicos</p>
<h4>Retorno</h4>
<p>
Esta requisição vai retornar uma página com
grupos de 10 tópicos.
</p>

<h4>Endpoint GET </h4>
<p>http://localhost:8080/topicos/{id}</p>
<h4>Retorno</h4>
<p>
Esta requisição vai retornar apenas o tópico
especificado pelo id.
</p>

<h4>Endpoint DELETE </h4>
<p>http://localhost:8080/topicos/{id}</p>



