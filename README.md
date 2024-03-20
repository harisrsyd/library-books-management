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
  "errors" : " "
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
    "language": "Indonesia",
    "pages" : "200"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "errors" : "Book is not found"
}
```

## Insert Book

Endpoint : POST /api/books

Request Body :

```json
{
  "title" : "Atomic Habits",
  "publishYear" : "2021",
  "author" : "James Clear",
  "publisher" : "Gramedia Pustaka Utama",
  "isbn" : "9786020667188",
  "language" : "Indonesia",
  "pages" : "200"
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
    "language": "Indonesia",
    "pages" : "200"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "title invalid, publishYear invalid, ..."
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
  "language" : "Indonesia",
  "pages" : "200"
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
    "language": "Indonesia",
    "pages" : "200"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "title invalid, publishYear invalid, Book is not found..."
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
  "errors" : "Book is not found"
}
```
