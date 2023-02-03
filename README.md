
# Library Management System

A Library Management System is an application used by librarian and users to borrow a book, return a book.




## API Reference

#### Register User

```http
  POST /api/user/register
```



#### Update User

```http
  PUT /api/user/update/{userId}
```

#### Delete User

```http
  DELETE /api/user/delete/{userId}
```

#### Borrow a book

```http
  PUT /api/user/borrow/{userId}/{bookId}
```

#### Return Book

```http
  PUT /api/user/return/{issueId}
```






## Deployment

To deploy this project run on Postman

```bash
   http://localhost:8777/
```


## Tech Stack


    -> Java
    -> Spring
    -> Spring Boot
    -> Spring Data JPA
    -> Hibernate
    -> MySQL
    -> Postman
