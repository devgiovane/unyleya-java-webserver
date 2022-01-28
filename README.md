# Webserver Jersey with Java

### About

Observamos na Unidade 3 que o Jersey facilita a construção de Web Services com Java. 
Baseado no projeto da unidade 3, construa um projeto que publique o serviço para consulta de dados de Empresas armazenadas em um banco de dados. 
Os campos da tabela Empresas serão: nome da empresa e endereço.

### Commands

```bash
chmod +x rebuild.sh
./rebuild.sh
```

#### or

```bash
./gradlew war

mv build/libs/api_unyleya-1.0.war build/libs/unyleya.war

docker-compose up
```

### Restfull Methods

```
GET - http://localhost:8080/unyleya/api/v1/companyes
GET - http://localhost:8080/unyleya/api/v1/company/1
POST - http://localhost:8080/unyleya/api/v1/company
PUT - http://localhost:8080/unyleya/api/v1/company/1
DELETE - http://localhost:8080/unyleya/api/v1/company/1
```
