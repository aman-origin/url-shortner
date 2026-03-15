# URL Shortener API Documentation

Base URL

```
http://localhost:8080
```

---

## 1. Create Short URL

Endpoint

```
POST /api/url/shorten
```

Request Body

```json
{
  "url": "https://example.com"
}
```

Response

```json
{
  "shortUrl": "http://localhost:8080/aB93kP"
}
```

---

## 2. Redirect to Original URL

Endpoint

```
GET /{shortCode}
```

Example

```
GET /aB93kP
```

Behavior

* Looks up the short code
* Redirects user to original URL

HTTP Response

```
302 Redirect
Location: https://example.com
```

---

## Error Response Example

```json
{
  "message": "Short URL not found"
}
```
