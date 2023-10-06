# Infnet-Dep-Inj-Project
Projeto INFNET - Matéria de Injeção de Dependência com Java.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Ter instalada a versão do Java JDK 11 ou superior;
* Ter instalado o Apache Maven 3.x.x;
* Utilizar uma IDE para Java - Eclipse, IntelliJ ou Visual Studio Code;
* Ter instalado o MySQL 5.7 ou superior;
* Ter instalado o Docker e Docker Compose.

## 🚀 Realizando o Setup

Faça o clone o repositório e:

1. Na pasta **docker**, execute o comando *docker compose up -d* para subir o banco;
2. Crie a database **dbRegEscolar** -> *CREATE DATABASE IF NOT EXISTS dbRegEscolar*;
3. Vá até a pasta **project** e execute o comando: *mvn spring-boot:run -X -e*.
