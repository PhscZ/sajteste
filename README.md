.\mvnw spring-boot:run

http://localhost:8080/pessoas (POST, raw, JSON)

{
  "nome": "Pessoa da Silva",
  "idade": 24
}

http://localhost:8080/pessoas/228a0cf5-1162-4d76-84c3-e44c720c3ff5

http://localhost:8080/h2-console/
jdbc:h2:file:./data/testdb
