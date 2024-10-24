# Case Join - Backend

Este projeto é a API backend para o sistema **Case Join**, que gerencia produtos e categorias, implementado com **Java Spring Boot**.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **JPA/Hibernate**
- **PostgreSQL**
- **Jakarta Validation**
- **Autenticação com JWT**
- **Lombok**
- **Maven**

## Funcionalidades

- Autenticação com **JWT** para login de usuários
- CRUD de **Categorias** e **Produtos**
- Relacionamento **Many-to-One** entre **Produto** e **Categoria**
- Validações de dados com Jakarta Bean Validation
- Documentação da API (Swagger)

## Instalação
### Pré-requisitos

- [JDK 17]
- [Maven]

## Configure o banco de dados:

Para utilizar o PostgreSQL, crie o banco e atualize o arquivo src/main/resources/application.properties com suas credenciais de banco de dados.

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/case-join
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: create
```

## Acessando a Documentação da API (Swagger)

Após iniciar a aplicação, você pode acessar a documentação da API gerada pelo Swagger. Para isso, siga os passos abaixo:

1. **Certifique-se de que a aplicação está em execução**. Você deve ver no terminal a mensagem de que a aplicação está rodando, em `http://localhost:9000`.

2. **Abra seu navegador e acesse a seguinte URL**: ```http://localhost:9000/case-join/swagger-ui/index.html#/```


