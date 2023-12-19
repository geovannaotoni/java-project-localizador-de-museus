# 📍🏛️ Localizador de Museus
Neste projeto foi desenvolvido uma API em Java cuja principal funcionalidade é facilitar a busca por museus baseada em sua localização. Os dados foram retirados desta [série histórica](http://dados.cultura.gov.br/dataset/series-historicas-cadastro-nacional-de-museus). Essa aplicação utilizou o Spring Web, camadas de controle e serviço, injeção de dependências, exceções customizadas, gerenciadores de erros e testes unitários para cobertura de código.

## ⚙️ Instalação das dependências
Para instalar as dependências do projeto, execute o comando `mvn install`. Isso fará o download das dependências configuradas no `pom.xml`, além de baixar as dependências indiretas.

## :white_check_mark: Funcionalidades Implementadas
#### (1) Criação das classes de Modelo e DTO com os atributos especificados.
#### (2) Habilitação do `Spring Boot Actuator` com a rota de verificação da saúde da aplicação.
#### (3) Criação da classe Service e dos métodos `createMuseum`, `getClosestMuseum` e `getMuseum`.
#### (4) Criação da classe Controller.
#### (5) Criação da rota POST `/museums`.
#### (6) Criação da rota GET `/museums/closest` para retornar o museu mais próximo.
#### (7) Criação da rota GET `/museums/{id}`
#### (8) Criação do `GeneralControllerAdvice` para tratar as exceções e gerar respostas.
#### (9) Implementação de testes unitários para as classes `CollectionTypeController` e `CollectionTypeService`.
#### (10) Implementação do controller, service e testes unitários para a rota `GET /museums/{id}`
 
## 🐋 Docker
Este projeto inclui uma configuração Docker para facilitar a execução da aplicação em um ambiente isolado. Para executar a aplicação usando Docker, siga as instruções abaixo:
1. Certifique-se de ter o Docker instalado em sua máquina.
2. Na pasta raiz do projeto, execute o comando `docker build -t docker-java-image .` para construir a imagem Docker.
3. Após a construção da imagem, execute o comando `docker run --name museum-container -p 8080:8080 docker-java-image` para iniciar o container da aplicação.
4. Agora você pode acessar a API através do endereço http://localhost:8080/museums.

## 🧹 Linter (Checkstyle)
O Checkstyle é usado para fazer a análise estática do código. Este projeto já vem com as dependências relacionadas ao linter configuradas no arquivo `pom.xml`. Caso deseje rodar o Checkstyle manualmente, basta executar o comando `mvn checkstyle:check`.

## :information_source: Considerações finais
Este projeto é apenas para fins educacionais. Qualquer dúvida ou sugestão, sinta-se à vontade para entrar em contato.
