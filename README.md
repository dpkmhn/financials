# Accounting SaaS - Version 2 (Revamped UI)

A modern accounting platform inspired by Zoho Books.

## Stack
- Backend: Spring Boot 3 + Java 21 + JPA + Flyway + H2
- Frontend: Vite + React + TypeScript + Recharts

## Core Functionalities Included
- Dashboard with financial KPIs and cash-flow visualization
- Customers management
- Invoices management
- Bills management
- Banking transactions overview
- Expense workflow overview
- Reports hub (P&L, Balance Sheet, A/R aging)
- Multi-tenant context through `X-Org-Id`
- Auto-seeded in-memory mock dataset with 500 customers, 500 invoices, and 10 bills per customer (5,000 bills total)

## Run Backend
```bash
cd backend
mvn spring-boot:run
```

## Run Frontend
```bash
cd frontend
npm install
npm run dev
```
