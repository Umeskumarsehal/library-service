# Library Service Microservice

## Prerequisites
Make sure the following are installed on your system
    - Docker
    - Docker compose
    - Maven

## 🚀 Quick Start
1. Clone project repo using below command
    - git clone https://github.com/Umeskumarsehal/library-service.git

2. Change directory to project root 
    - cd library-service/src/library-service/

3. Build project jar using below command 
    - mvn clean package -DskipTests=true

4. Run Application with docker compose using below command
    - docker-compose up --build


## 📱 API Ready
**Swagger**: http://localhost:8081/swagger-ui/index.html

## Endpoints
- `POST /api/books` - Create
- `GET /api/books` - List  
- `GET /api/books/{id}` - Get
- `PUT /api/books/{id}` - Update (partial OK)
- `DELETE /api/books/{id}` - Soft delete

**MySQL**: localhost:3307 (librarydb/libraryuser/librarydbpass)

---

**Done!** Test in Swagger UI.