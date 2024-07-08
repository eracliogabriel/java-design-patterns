# Spring Design Patterns

Este é um exemplo de aplicação Spring que demonstra o uso de diversos padrões de design para construir uma aplicação de gerenciamento de clientes com integração ao serviço ViaCep para busca de endereços, utilizando o banco de dados MySQL para armazenar os dados dos clientes e endereços. A aplicação é composta por várias classes e interfaces que trabalham juntas para fornecer funcionalidades como adicionar, buscar, atualizar e excluir clientes.

## Estrutura do Projeto

O projeto é organizado em pacotes que representam diferentes componentes da aplicação:

- `br.com.dio.springdesignpatterns`: O pacote raiz que contém a classe principal `SpringDesignPatternsApplication`.

- `br.com.dio.springdesignpatterns.model`: Contém as classes `Cliente` e `Endereco`, que representam entidades de dados e são usadas para mapear os dados do banco de dados, além das interfaces `ClienteRepository` e `EnderecoRepository`, que estendem `CrudRepository` e fornecem métodos para acessar os dados do banco de dados.

- `br.com.dio.springdesignpatterns.service`: Contém a interface `ClienteService` e a classe de implementação `ClienteServiceImpl`, que definem e implementam operações de negócios relacionadas aos clientes.

- `br.com.dio.springdesignpatterns.controller`: Contém a classe `ClienteRestController`, que define os pontos de extremidade da API REST para interagir com clientes.

## Tecnologias Utilizadas

- Spring Boot: O framework Spring Boot é usado para construir a aplicação e facilitar o desenvolvimento de aplicativos Java.

- Spring Data JPA: É usado para simplificar o acesso aos dados do banco de dados por meio de repositórios.

- Spring Cloud OpenFeign: Uma biblioteca que facilita a integração com serviços HTTP, neste caso, o serviço ViaCep.

## Configuração

Certifique-se de configurar corretamente o arquivo `application.properties` com as propriedades do banco de dados e o arquivo `pom.xml` com as dependências necessárias.

## Como Executar

Para executar a aplicação, você pode usar o método `main` da classe `SpringDesignPatternsApplication`. Acesse a aplicação por meio do navegador ou uma ferramenta de teste de API REST.
