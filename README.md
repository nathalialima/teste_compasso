## **Teste Crud Spring Boot Compasso UOL**

Criar uma api que implemente um crud de cidade e cliente

## Tecnologias

- SpringBoot
- Lombok
- HSQLDB

## Manter Cidade

Criar Cidade

- **Post:** /city/create

- **Payload:**

```json
{
  "name": "string",
  "state": "string"
}
```

- **Exemplo:**

```json
{
  "name": "teste",
  "state": "teste"
}
```

- **Retorno**

```json
{
  "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
  "name": "teste",
  "state": "teste"
}
```
Buscar Cidade pelo ID
- **GET:** /city/id/{UUID idCliente}

- **Exemplo:** /city/id/6a84a47e-be4e-4899-96b3-afa6707954b6

- **Retorno**

```json
{
  "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
  "name": "teste",
  "state": "teste"
}
```

Buscar Cidade por Nome

- **Post:** /city/name

- **Payload:**

```json
{
  "name": "string"
}
```

- **Exemplo:**

```json
{
  "name": "teste"
}
```

- **Retorno**

```json
[
  {
    "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
    "name": "teste",
    "state": "teste"
  }
]
```

Buscar Cidade por Estado

- **Post:** /city/state/

- **Payload:**

```json
{
  "state": "string"
}
```

- **Exemplo:**

```json
{
  "state": "teste"
}
```

- **Retorno**

```json
[
  {
    "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
    "name": "teste",
    "state": "teste"
  }
]
```

## Manter Cliente

Criar Cliente

- **Post:** /client/create

- **Payload:**

```json
{
  "completeName": "string",
  "gender": "string",
  "bornDate": "date",
  "age": "integer",
  "cityId": "uuid"
}
```

- **Exemplo:**

```json
{
  "completeName": "teste",
  "gender": "teste",
  "bornDate": "2019-01-02",
  "age": 1,
  "cityId": "6a84a47e-be4e-4899-96b3-afa6707954b6"
}
```

- **Retorno:**

```json
{
  "id": "dabc7f89-9b32-4e12-8bb3-8573d8d7e192",
  "completeName": "teste",
  "gender": "teste",
  "bornDate": "2019-01-02",
  "age": 1,
  "city": {
    "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
    "name": "teste",
    "state": "teste"
  }
}
```

Buscar Cliente por ID

- **GET:**  /client/id/{UUID idCliente}

- **Exemplo**: /client/id/dabc7f89-9b32-4e12-8bb3-8573d8d7e192

- **Retorno:**

```json
{
  "id": "dabc7f89-9b32-4e12-8bb3-8573d8d7e192",
  "completeName": "teste",
  "gender": "teste",
  "bornDate": "2019-01-02",
  "age": 1,
  "city": {
    "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
    "name": "teste",
    "state": "teste"
  }
}
```

Buscar Cliente pelo Nome

- **Post:** /client/name/


- **Payload:**

```json
{
  "name": "string"
}
```

- **Exemplo:**

```json
{
  "name": "teste"
}
```

- **Retorno:**

```json
{
  "id": "dabc7f89-9b32-4e12-8bb3-8573d8d7e192",
  "completeName": "teste",
  "gender": "teste",
  "bornDate": "2019-01-02",
  "age": 1,
  "city": {
    "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
    "name": "teste",
    "state": "teste"
  }
}
```

Editar nome do cliente

- **Put:** /client/update/{UUID idCliente}

- **Payload:**/client/update/dabc7f89-9b32-4e12-8bb3-8573d8d7e192

```json
{
  "name": "string"
}
```

- **Exemplo:**

```json
{
  "name": "outro teste"
}
```

- **Retorno:**

```json
{
  "id": "dabc7f89-9b32-4e12-8bb3-8573d8d7e192",
  "completeName": "outro teste",
  "gender": "teste",
  "bornDate": "2019-01-02",
  "age": 1,
  "city": {
    "id": "6a84a47e-be4e-4899-96b3-afa6707954b6",
    "name": "teste",
    "state": "teste"
  }
}
```

Deletar Cliente

- **Delete:** /client/remove/{UUID idCliente}
- **Exemplo:**  /client/remove/dabc7f89-9b32-4e12-8bb3-8573d8d7e192
