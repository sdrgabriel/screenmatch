# Projeto de estudos spring-security

Bem-vindo ao repositório do projeto "Screenmatch", desenvolvido com o proposite de estudos de Spring Boot e Spring Security utilizando arquitetura limpa multi-modal.

Este projeto visa implementar uma API para cadastrar usuarios e fazer pesquisa em uma API externa.

## 👨‍💻 Desenvolvedores

- Gabriel Ricardo dos Santos

## 💡 Tecnologias

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen?style=for-the-badge)
![Gradle](https://img.shields.io/badge/Gradle-8.12.1-C71A36?style=for-the-badge&logo=gradle)


## 📦 Estrutura do Projeto

```plaintext
br.com.sdrgabriel.infrastructure
|-- config                  // Configurações da aplicação
|   controller              // Controllers REST
|   dto
|   |-- request             // DTOs de entrada
|   |-- response            // DTOs de saida
|   |   |-- exception       // DTOs de erro
|   entity                  // Entidades do banco
|   mapper                  // Conversores DTO ↔ Entity
|   respository             // Interfaces JPA
|   service                 
|   |-- conteudo            // Implementação do gateway de conteudo
|   |-- usuario             // Implementação do gateway de usuário
|   utils                   // Utilitários
|  Application.java         // Classe principal
```

```plaintext
br.com.sdrgabriel.application
|-- usecaseimpl
|  |--  conteudo            // Implementação do usecase de conteudo
|  |--  usuario             // Implementação do usecase de usuário
```

```plaintext
br.com.sdrgabriel.adapters
|-- gateway                 // Interfaces do gateway
|-- usecase                 // Interfaces do usecase
```

```plaintext
br.com.sdrgabriel.core
|-- domain                 // Classes de dominio
|-- exception              // Classes de exceção
```

## ▶️ Como Executar o Projeto

Para rodar o projeto localmente, siga os passos abaixo:

1. **Clone o repositório:**

    ```bash
    git clone <https://github.com/sdrgabriel/screenmatch.git>    
    ```

2. **Navegue até o diretório do projeto:**

    ```bash
    cd screenmatch    
    ```

3. **Colocar as variáveis de ambiente do arquivo que foi anexado com a documentação**

    >caso isso nao seja feito o projeto nao ira fazer build.
   
4. **Construa o projeto com Maven:**

    ```bash
    .\gradlew.bat clean build --refresh-dependencies    
    ```

5. **Inicie a aplicação localmente:**

    ```bash
    .\gradlew bootRun    
    ```
   
## Configurando Variáveis de Ambiente

Deve-se criar um arquivo .env na raiz do projeto contendo as variáveis:

| Variável                        | Descrição                                                                   | Exemplo         |
|---------------------------------|-----------------------------------------------------------------------------|-----------------|
| `OMDB_API_KEY`                  | API KEY do OMDB                                                             | `fXf615X3`      |

Pode-se pegar a chave da api aqui [OMDB API](https://www.omdbapi.com/apikey.aspx)

## 👥 Contribuindo

Contribuições são bem-vindas! Para contribuir com o projeto, por favor siga estes passos:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção (`git checkout -b feature/nova-feature`).
3. Faça commit das suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Envie suas alterações para o repositório (`git push origin feature/nova-feature`).
5. Abra um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
