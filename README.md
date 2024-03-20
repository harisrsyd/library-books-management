# library-books-management
This is the repository for one of the stages in the Java Developer Selection process at PT. Javan Cipta Solusi

# Book API Spec

## Get All Books

Endpoint : GET /api/books

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "long-identity",
      "title": "Atomic Habits",
      "publishYear": "2021",
      "author": "James Clear"
    }
  ]
}
```

Response Body (Failed) :

```json
{
  "errors" : "Unauthorized"
}
```

## Get Book Details

Endpoint : GET /api/books/{id}

Response Body (Success) :

```json
{
  "data": {
    "id": "long-identity",
    "title": "Atomic Habits",
    "publishYear": "2021",
    "author": "James Clear",
    "publisher": "Gramedia Pustaka Utama",
    "isbn": "9786020667188",
    "language": "Indonesia"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "errors" : "Book is not found"
}
```

## Create/Insert new Book

Endpoint : POST /api/books

Request Body :

```json
{
  "title" : "Atomic Habits",
  "publishYear" : "2021",
  "author" : "James Clear",
  "publisher" : "Gramedia Pustaka Utama",
  "isbn" : "9786020667188",
  "language" : "Indonesia"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "long-identity",
    "title": "Atomic Habits",
    "publishYear": "2021",
    "author": "James Clear",
    "publisher": "Gramedia Pustaka Utama",
    "isbn": "9786020667188",
    "language": "Indonesia"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "ISBN format invalid, publishYear invalid, ..."
}
```

## Update Book

Endpoint : PUT /api/books/{id}

Request Body :

```json
{
  "title" : "Atomic Habits",
  "publishYear" : "2021",
  "author" : "James Clear",
  "publisher" : "Gramedia Pustaka Utama",
  "isbn" : "9786020667188",
  "language" : "Indonesia"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "long-identity",
    "title": "Atomic Habits",
    "publishYear": "2021",
    "author": "James Clear",
    "publisher": "Gramedia Pustaka Utama",
    "isbn": "9786020667188",
    "language": "Indonesia"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "ISBN format invalid, publishYear invalid, ..."
}
```

## Remove Book

Endpoint : DELETE /api/books/{id}

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Contact is not found"
}
```
