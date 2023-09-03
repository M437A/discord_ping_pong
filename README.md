# Ping-Pong Bot

## Description

Ping-Pong Bot is a task designed for Discord. When you send `!ping`, this bot will save information about your message to a PostgreSQL database.

## Stack

- Java
- Spring
- Hibernate
- Liquibase
- Docker

## Getting Started

To use this bot, follow these steps:

1. Add your Discord token to `application.yaml`.
2. Run the Docker container.

To run the Docker container, you can use the following commands:

```bash
docker-compose up --build
docker-compose up -d
