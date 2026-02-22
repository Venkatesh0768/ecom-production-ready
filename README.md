# 🛒 Ecommerce — Production Ready

> A fully production-grade ecommerce platform with automated CI/CD pipeline and containerized deployment.

---

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/Venkatesh0768/ecom-production-ready.git
cd ecom-production-ready
```

### 2. Configure Environment Variables

In the **root folder**, create a `.env` file and add the following:
```env
POSTGRES_USER=postgres
POSTGRES_PASSWORD=password
POSTGRES_DB=ecom_db
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/ecom_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=password
```

> ⚠️ **Note:** Never commit your `.env` file to version control. Add it to `.gitignore`.

### 3. Build & Run with Docker
```bash
cd ecom-backend
docker compose up -d
```

### 4. Access the Application

Once the containers are running, open your browser and visit:
```
http://localhost:5000
```

---

## 🏗️ Architecture

| Layer       | Technology              |
|-------------|-------------------------|
| Backend     | Spring Boot (Java)      |
| Database    | PostgreSQL              |
| Container   | Docker & Docker Compose |
| CI/CD       | Automated Pipeline      |

---

## 📋 Prerequisites

Before getting started, make sure you have the following installed:

- [Docker](https://docs.docker.com/get-docker/) `v20+`
- [Docker Compose](https://docs.docker.com/compose/install/) `v2+`
- [Git](https://git-scm.com/)

---

## 📁 Project Structure
```
ecom-production-ready/
├── ecom-backend/          # Spring Boot backend application
│   └── docker-compose.yml
├── .env                   # Environment variables (create this)
└── README.md
```

---

## 🔧 Useful Commands
```bash
# View running containers
docker compose ps

# View logs
docker compose logs -f

# Stop all services
docker compose down

# Rebuild containers
docker compose up -d --build
```

---
