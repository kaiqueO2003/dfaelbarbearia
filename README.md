# Sistema de Barbearia

Este projeto é um sistema de agendamento para barbearias, que permite aos clientes se cadastrarem, fazer login, agendar horários e receber notificações sobre seus compromissos.

## Tecnologias Utilizadas

- **Java Spring Boot**: Framework para o desenvolvimento de aplicações back-end.
- **Spring Security**: Gerenciamento de autenticação e autorização dos clientes.
- **JPA (Java Persistence API)**: Mapeamento objeto-relacional para persistência de dados.
- **Banco de Dados H2**: Banco de dados em memória para simplificar o desenvolvimento e testes.
- **Twilio**: Serviço de envio de SMS para notificação dos agendamentos.

## Funcionalidades

- **Cadastro de Cliente**: Clientes podem se registrar no sistema.
- **Login de Cliente**: Login seguro com Spring Security.
- **Agendamento de Serviço**: Clientes podem agendar horários para serviços na barbearia.
- **Notificação de Agendamento**: Clientes recebem notificações por SMS dos agendamentos via Twilio.

## Instalação e Configuração

### Pré-requisitos

- **Java 17** ou superior.
- **Maven** para gerenciar dependências e construir o projeto.

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone git@github.com:kaiqueO2003/dfaelbarbearia.git

2. Configure as credenciais do Twilio no arquivo application.properties:
- `twilio.accountSid=SEU_ACCOUNT_SID`
- `twilio.authToken=SEU_AUTH_TOKEN`
- `twilio.phoneNumber=SEU_NUMERO_DE_TELEFONE_TWILIO`


## Endpoints principais
- **Cadastro de Cliente**: `POST /auth/cadastro`
- **Login de Cliente**: `POST /auth/login`
- **Agendamento de Serviço**: `POST /agendamentos/solicitar`
- **Notificações de Agendamento**: Enviadas automaticamente via Twilio.

## Banco de Dados H2
- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuário**: `sa`
- **Senha**: (sem senha por padrão)


  
