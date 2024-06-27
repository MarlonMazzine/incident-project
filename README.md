# Guia de Introdução


## Rodando o projeto

* Faça o download do projeto;
* Após isso você deverá baixar e configurar o [apache-maven](https://maven.apache.org/download.cgi) na versão mais recente e o [Java jdk17](https://www.oracle.com/br/java/technologies/downloads/#java17);
* Em seguida deve abrir o caminho do projeto no terminal e executar o comando abaixo:
```
mvn spring-boot:run
```
* Por fim a api estará rodando no endereço:
```
http://localhost:8080/
```

## Bibliotecas utilizadas

* [H2 Database Engine](https://mvnrepository.com/artifact/com.h2database/h2) para faciliar a persistência dos dados;
* [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa) para simplificar toda implementação do repositório;
* [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) para simplificar o desenvolvimento da API.

## Requisições

* [Insomnia - API Client](https://insomnia.rest/download) para realizar as requisições para a API.
* Todas essas requisições podem ser baixadas através deste [repositório](https://github.com/MarlonMazzine/cURL-incident-project).
