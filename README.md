# Sistema API Clientes

🚧 **Projeto em construção** 🚧

Esse projeto é parte dos meus estudos no curso de **Análise e Desenvolvimento de Sistemas**. O objetivo é desenvolver uma **API REST** para gerenciar clientes, com funcionalidades de CRUD, utilizando **Java**, **Spring Boot** e **Swagger** para a documentação da API. O banco de dados utilizado é o **PostgreSQL**.

## Funcionalidades

Atualmente, a API permite as seguintes operações:

- **Cadastrar** novos clientes
- **Atualizar** dados de clientes existentes
- **Excluir** clientes
- **Listar** todos os clientes ou buscar um cliente específico por ID

## Tecnologias utilizadas

- **Java 17**
- **Spring Boot**
- **Swagger/OpenAPI** para a documentação dos endpoints
- **PostgreSQL** como banco de dados
- **Maven** para gerenciamento de dependências

## Como executar o projeto localmente

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/sistema-apiclientes.git

   instale as dependências:

Se você está utilizando o Maven, execute:

./mvnw spring-boot:run
Acesse a API através de http://localhost:8080/swagger-ui.html, onde você pode testar os endpoints diretamente.

Endpoints
1. POST /api/clientes
Cadastra um novo cliente.

Body (JSON):

{
  "nome": "Carlos Pereira",
  "cpf": "345.678.901-23",
  "email": "carlos.pereira@exemplo.com"
}

2. PUT /api/clientes
Atualiza os dados de um cliente existente.

Body (JSON):

{
  "idCliente": 2,
  "nome": "Carlos Pereira Silva",
  "cpf": "345.678.901-23",
  "email": "carlos.pereira.silva@exemplo.com"
}

3. DELETE /api/clientes/{idCliente}
Exclui um cliente com o ID especificado.

4. GET /api/clientes
Retorna uma lista de todos os clientes cadastrados.

5. GET /api/clientes/{idCliente}
Retorna os dados de um cliente específico, identificado pelo ID.

Tratamento de erros
A API trata erros de forma clara e simples. Alguns dos códigos de status mais comuns são:

200 OK: A operação foi bem-sucedida.

201 CREATED: O recurso foi criado com sucesso.

404 NOT FOUND: O cliente não foi encontrado.

500 INTERNAL SERVER ERROR: Erro inesperado no servidor.

Como contribuir
Esse projeto está em andamento, mas ficarei feliz em receber contribuições. Se você tiver sugestões de melhorias ou quiser ajudar de alguma forma, basta abrir uma issue ou enviar um pull request.

Status do Projeto
🚧 Em desenvolvimento –  As funcionalidades básicas de CRUD estão implementadas, mas ainda faltam alguns ajustes e melhorias.






