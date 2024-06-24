 # ForumHub

<p align="center">
  <img src="https://img.shields.io/static/v1?label=SPRING&message=framework&color=048C25&style=for-the-badge&logo=SPRING"/>
  <img src="https://img.shields.io/static/v1?label=MIT&message=LICENSE&color=8A2BE2&style=for-the-badge"/>
  <img src="https://img.shields.io/static/v1?label=STATUS&message=completed&color=green&style=for-the-badge"/>
  <img src="https://img.shields.io/static/v1?label=MYSQL&message=database&color=blue&style=for-the-badge&logo=MYSQL"/>
</p>

## 💻 Descrição do Projeto

O ForumHub é uma APIRest criada a partir de um desafio da formação ONE (Parceria entre Alura e Oracle).

É um fórum com um CRUD completo de tópicos, onde cada tópico está relacionado a um curso, a um autor (que deve estar cadastrado no momento da criação) e pode possuir diversas respostas.

O projeto conta com cadastro de usuários (a senha é salva utilizando criptografia HMAC256) e autenticação/autorização utilizando Token JWT (O token dura cerca de 2h).



## ⚙️ Funcionalidades

- [x]  Topicos;
- [x]  Usuários;
- [x]  Cursos;
- [x]  Respostas;
- [ ]  Perfis

## Linguagens, Dependências e Bibliotecas Utilizadas 📚

- [JAVA 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [MYSQL 8.0](https://dev.mysql.com/downloads/mysql/8.0.html)
- [IntelliJ IDEA Community](https://www.jetbrains.com/pt-br/idea/download/?section=windows)
- [Lombok](https://projectlombok.org)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [JWT](https://jwt.io/)


## Como Rodar a Aplicação ▶️

```bash
git clone https://github.com/kddez/one-challenge-forumhub.git

mvn clean install
```
## Iniciando/Configurando o Banco de Dados e Conectando ao Projeto

Para iniciar e configurar o banco de dados e conectá-lo ao projeto, siga estas etapas:

1. **Instalação e Configuração do PostgreSQL**:
   - Certifique-se de ter o MYSQL instalado em seu sistema. Você pode baixá-lo em [MYSQL Downloads]([https://dev.mysql.com/downloads/mysql/8.0.html).

2. **Criação do Banco de Dados**:
   - No terminal, com o projeto já aberto, utilize os seguintes comandos:
     ```
     > mysql -u username -p
     - digite a senha logo após
     > create database dbname;
     ```

3. **Configuração do Projeto**:
   - Com o projeto aberto em sua IDE, navegue até `src > main > resources > application.properties`.
   - Dentro do arquivo `application.properties`, defina as seguintes variáveis de ambiente de acordo com as especificações do seu banco de dados:
     ```
     DB_HOST   >>>> ex.: localhost
     DB_NAME   >>>> ex.: db_forum
     DB_USER   >>>> ex.: user
     DB_PASSWORD >>>> ex.: password
     ```

4. **Pronto para Rodar a Aplicação**:
   - Após configurar corretamente as variáveis de ambiente, você está pronto para executar a aplicação.


## Licença 

The [MIT License](LICENSE) (MIT)


