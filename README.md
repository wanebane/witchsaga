# Spring Boot Application
## Witch Saga : Return of The Coder!

## Tech :
- [x] Spring Boot
- [x] Java 11
- [x] Lombok
- [x] Swagger UI
- [x] Validation
- [x] Junit

## Test App
Run the application before and check setting on `application.yml`

### Default Port
```yaml
server:
  port: 8085
  servlet:
    context-path: /api/v1
```

### Sample Request
```json
{
  "totalPerson": 3,
  "persons": [
    {
      "ageOfDeath": 10,
      "yearOfDeath": 12
    },
    {
      "ageOfDeath": 13,
      "yearOfDeath": 17
    },
    {
      "ageOfDeath": 15,
      "yearOfDeath": 20
    }
  ]
}
```

### Open Swagger UI

Open new browser and paste this url `localhost:8085/api/v1/swagger-ui/index.html`