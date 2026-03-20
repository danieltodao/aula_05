cole isso no postman:
{
"info": {
"name": "Catalogo API",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
},
"variable": [
{
"key": "baseUrl",
"value": "http://localhost:8080/api/v1/categorias"
}
],
"item": [
{
"name": "Listar todos as categorias",
"request": {
"method": "GET",
"url": "{{baseUrl}}"
}
},
{
"name": "Buscar categoria por ID",
"request": {
"method": "GET",
"url": "{{baseUrl}}/1"
}
},
{
"name": "Criar nova Categoria",
"request": {
"method": "POST",
"url": "{{baseUrl}}",
"header": [
{
"key": "Content-Type",
"value": "application/json"
}
],
"body": {
"mode": "raw",
"raw": "{\n  \"nome\": \"Calcados\",\n  \"descricao\": \"Tipo de calcados\"\n}"
}
}
}
]
}