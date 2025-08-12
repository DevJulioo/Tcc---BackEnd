# Dashboard Backend (Spring Boot 3, Java 21)

## Requisitos
- Java 21
- Maven 3.9+

## Rodando
```bash
mvn spring-boot:run
```

A API subirá em `http://localhost:8080`.

- H2 Console: `/h2-console` (JDBC URL: `jdbc:h2:mem:dashboarddb`)
- Endpoints:
  - `GET /api/dashboards`
  - `POST /api/dashboards`
  - `GET /api/dashboards/{id}`
  - `GET /api/dashboards/{id}/widgets`
  - `POST /api/dashboards/{id}/widgets`
  - `POST /api/widgets`

## Produção
Troque H2 por um banco real (PostgreSQL/MySQL) e ajuste `application.yml`.