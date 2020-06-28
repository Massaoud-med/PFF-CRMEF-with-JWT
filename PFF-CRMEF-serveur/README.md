

# ==============================
# DATABASE CONNECTION
# ===============================
 
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/CRMEF
spring.datasource.username=postgres
spring.datasource.password=enable
 
# ===============================
# JPA / HIBERNATE
# ===============================
 
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.servlet.multipart.max-file-size=2MB
spring.servlet.multipart.max-request-size=2MB

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
