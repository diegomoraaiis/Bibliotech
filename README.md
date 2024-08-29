# BiblioTech
![image](https://github.com/user-attachments/assets/f77db2a8-7673-40bf-b70a-f85181d388ec)

---

## Funcionalidades

- Tipos de usuários do sistema: Usuário administrativo e usuário comum.
- Permite que o usuário administrador faça inserções, consultas, alterações e exclusões de livros.
- Permite que o usuário comum realize consultas por livros e visualize as páginas "sobre" e "ajuda".
- Permite que usuários cadastrados diretamente pela aplicação visualizem apenas a página destinada à consulta de livros.
- Permite que usuários cadastrados como administradores diretamente no banco de dados possam visualizar a página de gerenciamento.

---

## Visualização do usuário
![image](https://github.com/user-attachments/assets/97b20e06-68d0-471e-b191-7c67f459b323)

---

## Visualização do administrador 
![image](https://github.com/user-attachments/assets/737ae7bc-8e16-48ec-aca4-93b4c9d7ab05)

---

## Página de login
![image](https://github.com/user-attachments/assets/3a57d1a9-d1ca-4c15-8d93-0b36119425e4)

---

## Página de cadastro
![image](https://github.com/user-attachments/assets/df8d1ede-6d51-4797-b3b1-e6bf8b6d7b4e)

---

## Instruções

- Baixe a aplicação do GitHub e execute na IDE de preferência (IDEs testadas: IntelliJ e NetBeans).
- Caso não queira criar um banco de dados, foi disponibilizado dentro da aplicação, uma conexão com um banco de dados já pronto para uso, hospedado em nuvem pelo site Tembo ([Tembo](https://tembo.io/)).
- Caso queira criar um banco de dados local: Execute as instruções SQL no pgAdmin 4, uma ferramenta de administração e desenvolvimento para bancos de dados PostgreSQL.
- Dentro do projeto aberto na IDE, verifique se o arquivo `BancoD.properties` contém as informações que correspondem com o banco de dados criado localmente.
- Caso ocorra algum erro na execução, verifique se o [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/) foi corretamente inserido no projeto e se as configurações de conexão (URL, usuário, senha, etc.) estão corretas.

---

## Estrutura do Banco de Dados

#### Tabela: `disponivel`
Armazena informações sobre livros disponíveis na biblioteca.

**Campos:**

- **id_livro** (INTEGER, PRIMARY KEY, NOT NULL): Identificador único para cada livro. Este campo é gerado automaticamente.
- **titulo** (VARCHAR(255), NOT NULL): Título do livro.
- **autor** (VARCHAR(150), NOT NULL): Autor do livro.
- **editora** (VARCHAR(255), NOT NULL): Editora do livro.
- **genero** (VARCHAR(50)): Gênero do livro.
- **prateleira** (VARCHAR(10), NOT NULL): Localização física do livro na prateleira.
- **quantidade** (INTEGER): Quantidade disponível do livro.
- **corredor** (VARCHAR(10), NOT NULL): Corredor onde o livro está localizado.

#### Tabela: `login`
Armazena informações de login para usuários normais.

**Campos:**

- **id** (INTEGER, PRIMARY KEY, NOT NULL): Identificador único para cada usuário. Este campo é gerado automaticamente.
- **nome** (VARCHAR(50), NOT NULL): Nome do usuário.
- **email** (VARCHAR(70), NOT NULL, UNIQUE): Endereço de e-mail do usuário. Deve ser único na tabela.
- **senha** (VARCHAR(50), NOT NULL): Senha do usuário.

#### Tabela: `loginadmin`
Armazena informações de login para administradores.

**Campos:**

- **id** (INTEGER, PRIMARY KEY, NOT NULL): Identificador único para cada administrador. Este campo é gerado automaticamente.
- **nome** (VARCHAR(100), NOT NULL): Nome do administrador.
- **email** (VARCHAR(100), NOT NULL, UNIQUE): Endereço de e-mail do administrador. Deve ser único na tabela.
- **senha** (VARCHAR(255), NOT NULL): Senha do administrador.

---

### Exemplo de Criação da Tabela

```sql
CREATE TABLE disponivel (
    id_livro SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    editora VARCHAR(255) NOT NULL,
    genero VARCHAR(50),
    prateleira VARCHAR(10) NOT NULL,
    quantidade INTEGER,
    corredor VARCHAR(10) NOT NULL
);

CREATE TABLE login (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(70) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE loginadmin (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Precisa-se inserir um administrador para poder logar na aplicação, deve-se conter "@admin.com"
-- Segue o exemplo abaixo:

INSERT INTO loginadmin (nome, email, senha)
VALUES ('Administrador', 'admin@example.com', 'senhaSegura123');
```
###### Usuário administrativo disponibilizado caso decida utilizar o banco de dados hospedado no servidor pelo Tembo: 
###### "admin@admin.com" e a senha é: "123"

---


## Links das aplicações utilizadas no projeto

- [NetBeans](https://netbeans.apache.org/front/main/download/index.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Tembo](https://tembo.io/)
- [DBeaver](https://dbeaver.io/)
