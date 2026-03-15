# URL Shortener Backend

A backend service that generates short URLs and redirects users to the original links.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* H2 / MySQL
* Swagger (OpenAPI)
* Maven

---

## Features

* Generate short URLs
* Redirect short URLs to original links
* Collision-safe short code generation
* Click tracking for each short URL
* REST API with Swagger documentation
* Global exception handling
* Layered backend architecture
* Git feature branch workflow

---

## Architecture

    Client → Controller → Service → Repository → Database

---

## API Endpoints

### Create Short URL

POST `/api/url/shorten`

Request:

```json
{
  "url": "https://google.com"
}
```

Response:

```json
{
  "shortUrl": "http://localhost:8080/aB93kP"
}
```

---

### Redirect Short URL

GET `/{shortCode}`

Example:

```
http://localhost:8080/aB93kP
```

Redirects to the original URL.

---

## Swagger Documentation

After running the application:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Running the Project

Clone the repository

```
git clone https://github.com/<your-username>/url-shortener.git
```

Run the application

```
mvn spring-boot:run
```

The server will start at:

```
http://localhost:8080
```

---

## Example Flow

1. Create short URL using `/api/url/shorten`
2. Receive short URL
3. Open short URL in browser
4. User is redirected to original link

---

## Author

Aman Kumar
