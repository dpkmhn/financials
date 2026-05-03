# Accounting SaaS - Version 2

Upgraded architecture inspired by Zoho Books:
- Spring Boot 3 + Java 21 backend with JPA + Flyway + H2
- Vite React + TypeScript frontend with routing for Dashboard/Customers/Invoices/Bills
- Multi-tenant request context via `X-Org-Id`
- CRUD endpoints for core accounting records + dashboard metrics

## Backend
Run:
```bash
cd backend
mvn spring-boot:run
```

## Frontend
Run:
```bash
cd frontend
npm install
npm run dev
```

## APIs
- `GET /api/dashboard`
- `GET|POST /api/customers`
- `GET|POST /api/invoices`
- `GET|POST /api/bills`
