# Sistema de Controle de Clientes e Agenda de Serviços para Lava Rápido

## 📋 Descrição Geral

Este é um sistema desktop desenvolvido em Java utilizando Swing e o padrão de arquitetura MVC. O objetivo é permitir o gerenciamento de clientes, tipos de serviços e controle da agenda de um lava rápido. 

A aplicação permite:

- Cadastrar e gerenciar clientes
- Definir e listar tipos de serviços
- Agendar, visualizar e controlar serviços realizados para cada cliente
 
---

## 🛠️ Guia de Inicialização

1. **Instale o PostgreSQL**  
   Baixe e instale o PostgreSQL a partir do site oficial:  
   [https://www.postgresql.org/download/](https://www.postgresql.org/download/)
   também é necessário instalar como biblioteca na IDE.

3. **Crie o banco de dados e suas tabelas**  
   - Abra o PgAdmin ou outro cliente SQL de sua preferência  
   - Crie um banco com o nome desejado (ex: `lava_rapido`)  
   - Execute o conteúdo do arquivo `Banco de dados.txt` para criar as tabelas

4. **Configure a conexão com o banco de dados**  
   - No projeto, abra o arquivo `Conn.java`  
   - Substitua as credenciais conforme o seu ambiente:
     ```java
     String url = "jdbc:postgresql://localhost:5432/seu_banco";
     String user = "seu_usuario";
     String password = "sua_senha";
     ```

5. **Execute o projeto**  
   - Compile e execute a aplicação usando sua IDE de preferência (como NetBeans ou IntelliJ)  
   - O sistema estará pronto para uso!

---

## 🚀 Funcionalidades Principais

### 🧑‍💼 Gestão de Clientes
- Cadastrar, editar, excluir e listar clientes
- Atributos do cliente:
  - Nome
  - CPF
  - Telefone
  - E-mail
  - Placa do veículo

### 🧽 Gestão de Tipos de Serviços
- Cadastrar e listar serviços oferecidos (ex: lavagem simples, completa, com cera, detalhada)
- Atributos do tipo de serviço:
  - Nome
  - Descrição
  - Preço

### 📆 Controle da Agenda de Serviços
- Agendamento de serviços para clientes
- Escolha do tipo de serviço, data e hora
- Visualização da agenda (diária/semanal)
- Edição e cancelamento de agendamentos

---

## 📐 Requisitos Técnicos

#### Serviços de Negócio
- `ClienteService`
- `TipoServicoService`
- `AgendamentoService`

#### Camadas MVC
- Controllers e Views separados para cada módulo (clientes, serviços, agenda)
- Relacionamentos bem definidos entre as classes
- Organização em pacotes: `model`, `view`, `controller`

### 📈 Diagrama de Sequência
- Fluxo modelado: **Agendamento de Serviço**
  - Usuário interage com a View
  - Controller recebe evento e invoca lógica no Service
  - Service atualiza Model e retorna resultado
  - View é atualizada com feedback

---

## 💻 Implementação em Java

- Interface gráfica com Swing
- Arquitetura MVC
- Controle de eventos centralizado nos Controllers
- Persistência de dados:
  - Banco de dados (PostgreSQL)
- Validações:
  - Evitar conflitos de agendamento (sobreposição de horários)
  - Verificação de dados obrigatórios

---

## 🛠 Tecnologias Utilizadas

- Java 8+
- Java Swing (GUI)
- UML para modelagem
- Organização em pacotes conforme MVC
- IDE recomendada: InteliJ

---


## 👨‍💻 Autor

Desenvolvido como parte de um estudo/prática sobre desenvolvimento de aplicações desktop com Java.

---

## 📎 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
