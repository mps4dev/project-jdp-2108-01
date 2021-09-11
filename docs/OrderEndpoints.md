# Order Controller endpoints

## 1. Get all orders

### HTTP Request:
`GET /v1/order`

### Body:
empty

### Returns:
**JSON** with array of all orders



## 2. Get orders with exact ID

### HTTP Request:
`GET /v1/order/{id}` where insert order ID instead of {id}

### Body:
empty

### Returns:
**JSON** with order of exact id

**or** 500 Internal Server Error - if there is no order with such ID



## 3. Creating new order

### HTTP Request:
`POST /v1/order/`

### Body:
**Type:** JSON

```
{
    "userId":"<userId>",
    "cartId":"<cartId>"
}
```
Insert userId instead of `<userId>`

Insert cartId instead of `<cartId>`

### Returns:
**JSON** with saved order, for ex.

```
{
    "id":1234,
    "userId":1234,
    "cartId":1234
}
```

**or** 500 Internal Server Error - if you entered `"id"` field in JSON body with number bigger than 0



## 4. Updating existing order

### HTTP Request:
`PUT /v1/order/`

### Body:
**Type:** JSON

```
{
    "id":"<orderId>",
    "userId":"<userId>",
    "cartId":"<cartId>"
}
```
Insert order ID instead of `<orderId>`, user ID instead of `<userId>` and cart ID instead of `<cartId>`

### Returns:
**JSON** with updated order, for ex.

```
{
    "id":1234,
    "userId":1234,
    "cartId":1234
}
```

**or** 500 Internal Server Error - if you filled `"id"` field in JSON body with ID that doesn't exist



## 5. Deleting order with exact ID

### HTTP Request:
`DELETE /v1/order/{id}` where insert order ID instead of {id}

### Body:
empty

### Returns:
empty **JSON**

**or** 500 Internal Server Error - if there is no order with such ID