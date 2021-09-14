# AnaliseCreditoApp

## Prerequisitos
JDK 11

Postgre 13.3

PgAdmin 4  ou outra plataforma de desenvolvimento para PostgreSQL

Maven 3.8.1

IDE de sua escolha(Preferência Sprint Tool Suite 4)

## Criar o banco de dados
Executar o script abaixo
```
CREATE DATABASE dock
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```    
## Alterar o application.properties de acordo com as configurações locais do PostgreSQL
```shell script
/AnaliseAppApiPortador/src/main/resources/application.properties
/AnaliseAppApiUsuario/src/main/resources/application.properties
```


## Executar a aplicação
A aplicação foi criada sobre microserviço. Seguir esta sequência de execução abaixo:

![image](https://user-images.githubusercontent.com/16020782/133340964-6acc68c7-7583-498c-a11e-837145b4225c.png)

1. Executar o Discovery
```shell script
br.com.dock.analiseapp.discovery.AnaliseAppDiscoveryServiceApplication
```
1.1 Para visualizar os micro serviços disponiveis acessar este endereço: http://localhost:9999/

2. Executar os micro serviços de Usuários e Portadores
```shell script
br.com.dock.analiseapp.api.AnaliseAppApiUsuarioApplication
br.com.dock.analiseapp.api.AnaliseAppApiPortadorApplication
```

3. Executar o API Gateway
```shell script
br.com.dock.analiseapp.api.AnaliseAppApiGatewayApplication
```

## Endpoints
Importar a Collection anexo ao projeto
```shell script
AnaliseApp.postman_collection.json
```
