# pix-api🤑

## 🎯Objetivo

Aplicação criada na playlist de [vídeos do youtube](https://youtube.com/playlist?list=PLcYPkX4lzn975reTvcXGq7nN2OEZBopWL&feature=shared)

---

Este projeto usa Quarkus, o framework Java Supersônico e Subatômico.

Para mais sobre acesse: https://quarkus.io/ .

## Executando aplicação em dev mode

```shell script
./mvnw compile quarkus:dev
```

## Build de prod e execução

Criar pacote do build de prod:
```shell script
./mvnw package
```

Executar a aplicação com comando `java -jar target/quarkus-app/quarkus-run.jar`.

## Guias relacionados

- RESTEasy Classic JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy Classic
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more