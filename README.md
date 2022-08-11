<img src="./java.png" width="80" height="80" alt="logo">

# Webserver Jersey with Java

### About

> Project that publishes the service for querying company data stored in a database.
The fields in the Companies table will be: company name and address.

### Commands

```bash
chmod +x rebuild.sh
./rebuild.sh
```

#### or

```bash
./gradlew war

mv build/libs/api_unyleya-1.0.war build/libs/ROOT.war

docker-compose up
```

### Restfull Methods

```
GET - http://localhost:8080/api/v1/companyes
GET - http://localhost:8080/api/v1/company/1
POST - http://localhost:8080/api/v1/company
PUT - http://localhost:8080/api/v1/company/1
DELETE - http://localhost:8080/api/v1/company/1
```

### Create by
© [Giovane Santos](https://giovanesantossilva.github.io/)
