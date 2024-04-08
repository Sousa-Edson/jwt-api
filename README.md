

# API com Spring Security e JWT

Este é um exemplo de aplicação RESTful construída com Spring Boot, utilizando Spring Security para autenticação e autorização, e JWT (JSON Web Token) para gerenciamento de sessões.

## Descrição

O objetivo deste projeto é fornecer uma estrutura básica para construção de APIs seguras com Spring Security e JWT. A aplicação utiliza uma configuração simples de segurança para proteger endpoints e gerenciar a autenticação dos usuários.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6.3 ou superior
- PostgreSQL (ou outro banco de dados suportado pelo Spring Boot)

## Instalação e Configuração

1. Clone este repositório: `git clone https://github.com/Sousa-Edson/jwt-api.git`
2. Acesse o diretório do projeto: `cd jwt-api`
3. Configure as propriedades do banco de dados no arquivo `application.properties`
4. Execute a aplicação: `mvn spring-boot:run`

## Utilização

Após iniciar a aplicação, você pode acessar os endpoints protegidos utilizando ferramentas como cURL, Postman ou qualquer cliente HTTP. 
Aqui estão os métodos adicionados ao README:

### Métodos da API

#### Login
Endpoint para autenticar um usuário e obter um token JWT.

- **URL**
  ```
  POST /auth/login
  ```

- **Corpo da Requisição (JSON)**
  ```json
  {
      "login": "seu-usuario",
      "password": "sua-senha"
  }
  ```

- **Resposta de Sucesso**
  - Código: 200 OK
  - Corpo da Resposta (JSON):
    ```json
    {
        "token": "{token-jwt}"
    }
    ```

#### Registro
Endpoint para registrar um novo usuário.

- **URL**
  ```
  POST /auth/register
  ```

- **Corpo da Requisição (JSON)**
  ```json
  {
      "login": "novo-usuario",
      "password": "senha-nova-usuario",
      "role": "ROLE_USER" // ou outro papel desejado
  }
  ```

- **Resposta de Sucesso**
  - Código: 200 OK

- **Possíveis Respostas de Erro**
  - Código: 400 Bad Request
    - Motivo: Usuário já existente.

---

### Exemplo de acesso a endpoint protegido

Para acessar um endpoint protegido, inclua o token JWT obtido na etapa de autenticação no cabeçalho de autorização da requisição:

```
Authorization: Bearer {token}
```


 
