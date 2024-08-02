# Projeto IA com Spring Boot

Bem-vindo ao projeto de API de Integração com Inteligência Artificial utilizando Spring Boot e Spring AI. Este projeto exemplifica como integrar um modelo de IA com uma API para gerar conteúdo dinâmico baseado em prompts de texto.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.2**
- **Spring AI 1.0.0-M1**
- **OpenAI API**

## Instalação

### Pré-requisitos

Certifique-se de ter instalado o [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) e o [Maven](https://maven.apache.org/install.html).

### Passos para instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/stfn-anderson/dojo-spring-ai.git
   cd dojo-spring-ai
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

### Gerar Piada

- **Descrição:** Gera uma piada baseada em um tema.
- **Endpoint:** `/openai/piada`
- **Método:** `GET`
- **Parâmetro:** `tema` (String)
- **Exemplo de Requisição:**
  ```
  GET /openai/piada?tema=programação
  ```
- **Exemplo de Resposta:**
  ```json
  "Por que os programadores gostam de natureza? Porque ela tem muitos bugs!"
  ```

### Listar Filmes

- **Descrição:** Gera uma lista de 5 filmes com base em uma categoria.
- **Endpoint:** `/openai/filme`
- **Método:** `GET`
- **Parâmetro:** `categoria` (String)
- **Exemplo de Requisição:**
  ```
  GET /openai/filme?categoria=ação
  ```
- **Exemplo de Resposta:**
  ```json
  "1. Mad Max: Estrada da Fúria, 2. John Wick, 3. Vingadores: Ultimato, 4. Gladiador, 5. Matrix"
  ```

### Resumir Livro

- **Descrição:** Gera um resumo de um livro com base em seu nome.
- **Endpoint:** `/openai/resumo/livro/outputconverter`
- **Método:** `GET`
- **Parâmetro:** `nome` (String)
- **Exemplo de Requisição:**
  ```
  GET /openai/resumo/livro/outputconverter?nome=O Senhor dos Anéis
  ```
- **Exemplo de Resposta:**
  ```json
  "Nome: O Senhor dos Anéis, Autor: J.R.R. Tolkien, Gênero: Fantasia, Resumo: Um épico conto de aventura..."
  ```

### Resumir Livro (Versão 2)

- **Descrição:** Gera um resumo detalhado de um livro, incluindo nome, autor, gênero e resumo.
- **Endpoint:** `/openai/resumo/livro/chatclient`
- **Método:** `GET`
- **Parâmetro:** `nome` (String)
- **Exemplo de Requisição:**
  ```
  GET /openai/resumo/livro/chatclient?nome=1984
  ```
- **Exemplo de Resposta:**
  ```json
  {
    "nome": "1984",
    "autor": "George Orwell",
    "genero": "Distopia",
    "resumo": "Uma obra que aborda um regime totalitário e o controle absoluto sobre a vida das pessoas."
  }
  ```

### Resumir Livro por Categoria

- **Descrição:** Fornece um resumo de um livro recomendando o melhor para uma categoria.
- **Endpoint:** `/openai/resumo/livro/categoria`
- **Método:** `GET`
- **Parâmetro:** `categoria` (String)
- **Exemplo de Requisição:**
  ```
  GET /openai/resumo/livro/categoria?categoria=fantasia
  ```
- **Exemplo de Resposta:**
  ```json
  {
    "categoria": "fantasia",
    "livro": "Harry Potter e a Pedra Filosofal",
    "ano": "1997",
    "resenha": "A primeira aventura do jovem bruxo Harry Potter...",
    "autor": "J.K. Rowling",
    "resumo": "Harry descobre ser um bruxo e inicia sua jornada em Hogwarts..."
  }
  ```

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contribuindo

Contribuições são sempre bem-vindas! Por favor, veja o arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para mais detalhes.

## Links Essenciais

- https://docs.spring.io/spring-ai/reference/index.html
- https://platform.openai.com/assistants
- https://platform.openai.com/settings/organization/billing/overview
- https://github.com/spring-projects/spring-ai
