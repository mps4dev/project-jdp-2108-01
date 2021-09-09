# Group Controller endpoints



## 1. Get all product groups

###HTTP Request:
`GET /v1/group/`

###Body:
empty

###Returns:
**JSON** with array of all product groups



## 2. Get product group with exact ID

###HTTP Request:
`GET /v1/group/{id}` where insert group ID instead of {id} 

###Body:
empty

###Returns:
**JSON** with group of exact id

**or** 500 Internal Server Error - if there is no group with such ID



## 3. Creating new product group

###HTTP Request:
`POST /v1/group/`

###Body:
**Type:** JSON
 
```
{
    "name":"<groupName>",
    "productsIds":[<id1>, <id2>, ..., <idN>]
}
```
Insert group name instead of `<groupName>`

It's not necessary to include `"productsIds"` filed, but you can define which products will be in the group by inserting their IDs in array instead of `<id1>`, `<id2>`, etc.

###Returns:
**JSON** with saved group, for ex.
```
{
    "id":1234,
    "name":"groupName",
    "productsIds":[231231, 321312, 23123]
}
```

**or** 500 Internal Server Error - if you entered `"id"` field in JSON body with number bigger than 0



## 4. Updating existing product group

###HTTP Request:
`PUT /v1/group/`

###Body:
**Type:** JSON

```
{
    "id":<groupId>,
    "name":"<groupName>",
    "productsIds":[<id1>, <id2>, ..., <idN>]
}
```
Insert group ID instead of `<groupId>`, group name instead of `<groupName>` and product(s) IDs instead of `<id1>`, `<id2>`, etc. in array.

###Returns:
**JSON** with updated group, for ex.
```
{
    "id":1234,
    "name":"groupName",
    "productsIds":[231231, 321312, 23123]
}
```

**or** 500 Internal Server Error - if you filled `"id"` field in JSON body with ID that doesn't exist



## 5. Deleting product group with exact ID

###HTTP Request:
`DELETE /v1/group/{id}` where insert group ID instead of {id}

###Body:
empty

###Returns:
empty **JSON**

**or** 500 Internal Server Error - if there is no group with such ID
