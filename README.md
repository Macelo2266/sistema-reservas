# 🏨 Sistema de Reservas em Tempo Real

Este projeto é um **Sistema de Reservas em Tempo Real**, desenvolvido em **Java com Spring Boot**, utilizando arquitetura **REST API**.  
O sistema permite o cadastro de usuários, recursos (ex: salas, mesas, quartos) e a realização de reservas com controle de horários para evitar conflitos.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot** (Web, Data JPA, Validation)
- **PostgreSQL** (Banco de dados relacional)
- **Maven** (Gerenciamento de dependências)
- **Insomnia** (Testes da API REST)
- **pgAdmin** (Gerenciamento do banco de dados)

---

## 📌 Estrutura do Projeto

- `model/` → Contém as entidades principais (User, Resource, Reservation).
- `dto/` → Objetos de Transferência de Dados (para entrada/saída da API).
- `repository/` → Interfaces JPA para comunicação com o banco.
- `service/` → Contém as regras de negócio.
- `controller/` → Endpoints REST para comunicação com o cliente.
- `exception/` → Tratamento de erros personalizados.

---

## ⚙️ Como Rodar o Projeto

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/seu-usuario/sistema-reservas.git
   cd sistema-reservas
