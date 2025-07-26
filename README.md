# Sistema de Gerenciamento de Funcionários

Este projeto implementa um sistema de gerenciamento de funcionários com uma API REST em Spring Boot e múltiplos clientes em diferentes linguagens de programação.

## Estrutura do Projeto

---
## Autores
DAVID SILVA FERNANDES DE OLIVEIRA - 539402

JEFERSON MATEUS LOPES ALVES -  538653

---

## Estrutura
```
SD-TRABALHO-3/
├── README.md
└── sd/
    ├── cliente.py          # Cliente em Python
    ├── ClienteJava.java    # Cliente em Java
    ├── cliente.js          # Cliente em Node.js
    ├── pom.xml             # Configuração Maven
    └── src/
        └── main/
            └── java/
                └── com/
                    └── exemplo/
                        ├── SupermercadoApplication.java
                        ├── HomeController.java
                        ├── FuncionarioController.java
                        ├── FuncionarioService.java
                        ├── Funcionario.java
                        ├── Gerente.java
                        ├── Vendedor.java
                        ├── Caixa.java
                        └── Balconista.java
```

## Servidor Spring Boot

### Pré-requisitos
- Java 17 ou superior
- Maven

### Como executar o servidor

1. Navegue até o diretório `sd/`:
   ```bash
   cd sd/
   ```

2. Compile o projeto:
   ```bash
   mvn compile
   ```

3. Execute o servidor:
   ```bash
   mvn spring-boot:run
   ```

O servidor estará disponível em `http://localhost:8080`

### Endpoints da API

- `GET /funcionarios` - Lista todos os funcionários
- `POST /funcionarios` - Cadastra um novo funcionário
- `GET /` - Página inicial

## Clientes Disponíveis

### 1. Cliente Python (`cliente.py`)

**Pré-requisitos:**
- Python 3.x
- Biblioteca `requests`

**Instalação das dependências:**
```bash
pip install requests
```

**Execução:**
```bash
python sd/cliente.py
```

### 2. Cliente Java (`ClienteJava.java`)

**Pré-requisitos:**
- Java 11 ou superior

**Compilação:**
```bash
cd sd/
javac ClienteJava.java
```

**Execução:**
```bash
java ClienteJava
```

### 3. Cliente JavaScript (`cliente.js`)

**Pré-requisitos:**
- Node.js
- NPM

**Instalação das dependências:**
```bash
npm install node-fetch@2
```

**Execução:**
```bash
node sd/cliente.js
```

## Funcionalidades dos Clientes

Todos os clientes oferecem as mesmas funcionalidades através de um menu interativo:

1. **Listar funcionários** - Exibe todos os funcionários cadastrados
2. **Cadastrar novo funcionário** - Permite inserir nome e cargo de um novo funcionário
3. **Sair** - Encerra o programa

## Exemplo de Uso

1. Inicie o servidor Spring Boot
2. Execute qualquer um dos clientes
3. Use o menu interativo para:
   - Listar funcionários existentes
   - Cadastrar novos funcionários
   - Sair do programa

## Estrutura das Classes

O sistema implementa herança com as seguintes classes:

- `Funcionario` (classe base)
  - `Gerente`
  - `Vendedor`
  - `Caixa`
  - `Balconista`

Cada tipo de funcionário pode ter comportamentos específicos implementados através de polimorfismo.

## Tecnologias Utilizadas

- **Backend:** Spring Boot (Java)
- **Clientes:** Python, Java, Node.js
- **Build Tool:** Maven
- **Protocolo:** HTTP/REST

## Contribuição

Para adicionar novos clientes ou funcionalidades:

1. Mantenha a mesma estrutura de menu dos clientes existentes
2. Use a URL base `http://localhost:8080/funcionarios`
3. Implemente as operações GET (listar) e POST (cadastrar)
4. Documente as dependências necessárias 
