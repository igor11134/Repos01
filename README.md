
# NIОКР Management MVP

Моно-репозиторий для MVP информационной системы управления НИОКР.

## Структура

- `backend` — Java 21, Spring Boot, PostgreSQL, Spring Security, OpenAPI
- `frontend` — React, TypeScript, Vite, Ant Design, TanStack Query, Zustand
- `infra` — `docker-compose` с PostgreSQL, MinIO, backend и frontend

## Быстрый запуск

1. Перейдите в корень репозитория:
   ```bash
   cd c:\Users\pilot\YandexDisk\Git\Reposit_01
   ```
2. Запустите все сервисы через Docker Compose:
   ```bash
   docker compose -f infra/docker-compose.yml up --build
   ```

## Доступные сервисы

- Frontend: http://localhost:4173
- Backend API: http://localhost:8080
- Health endpoint: http://localhost:8080/api/health
- MinIO console: http://localhost:9001

## Backend

- Health-check endpoint: `/api/health`
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/api-docs

## Frontend

Стартовая страница показывает MVP описание и кнопку для проверки работоспособности backend.

## Примечания

- Если используется `docker-compose`, можно заменить `docker compose` на `docker-compose`.
- Сервис `backend` ждет, пока PostgreSQL станет доступен.
 