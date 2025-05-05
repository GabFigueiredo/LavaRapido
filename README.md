# Sistema de Controle de Clientes e Agenda de Serviços para Lava Rápido

## 📋 Descrição Geral

Este é um sistema desktop desenvolvido em Java utilizando Swing e o padrão de arquitetura MVC. O objetivo é permitir o gerenciamento de clientes, tipos de serviços e controle da agenda de um lava rápido. 

A aplicação permite:

- Cadastrar e gerenciar clientes
- Definir e listar tipos de serviços
- Agendar, visualizar e controlar serviços realizados para cada cliente

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
