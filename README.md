Sistema de Barbearia
Este projeto é um sistema de agendamento para uma barbearia, permitindo que os clientes se cadastrem, façam login e recebam notificações de seus agendamentos.

Tecnologias Utilizadas
Java Spring Boot: Framework para o desenvolvimento de aplicações back-end.
Spring Security: Usado para gerenciar autenticação e autorização dos clientes no sistema.
JPA (Java Persistence API): Utilizado para o mapeamento objeto-relacional e persistência de dados.
Banco de Dados H2: Banco de dados em memória para simplificar o desenvolvimento e os testes locais.
Twilio: Serviço de envio de SMS para notificações de agendamentos.
Funcionalidades
Cadastro de Cliente: Os clientes podem se cadastrar no sistema.
Login de Cliente: Login seguro utilizando Spring Security.
Agendamento de Serviço: Os clientes podem agendar um horário para serviços na barbearia.
Notificação de Agendamento: Os clientes recebem notificações sobre seus agendamentos através de SMS, utilizando a API do Twilio.
Instalação e Configuração
Pré-requisitos
Java 17 ou superior.
Maven para gerenciar dependências e construir o projeto.
Passos para Executar
Clone o repositório:

bash
Copiar código
git clone https://github.com/usuario/sistema-barbearia.git
cd sistema-barbearia
Configure as credenciais do Twilio no arquivo application.properties:

properties
Copiar código
twilio.accountSid=SEU_ACCOUNT_SID
twilio.authToken=SEU_AUTH_TOKEN
twilio.phoneNumber=SEU_NUMERO_DE_TELEFONE_TWILIO
Execute a aplicação:

bash
Copiar código
mvn spring-boot:run
Endpoints Principais
Cadastro de Cliente: POST /auth/cadastro
Login de Cliente: POST /auth/login
Agendamento de Serviço: POST /agendamentos/solicitar
Notificações de Agendamento: Notificações de lembrete enviadas automaticamente via Twilio.
Banco de Dados H2
Para acessar o console do banco de dados H2:

URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (sem senha por padrão)
