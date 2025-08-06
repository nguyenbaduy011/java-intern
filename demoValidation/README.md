# Spring Validation Demo

Project này minh họa cách sử dụng `@Valid` và `@Validated` trong Spring Boot.

## Cách chạy

1. Mở project trong IntelliJ hoặc IDE bất kỳ
2. Chạy class `DemoApplication.java`
3. Gửi POST request đến `http://localhost:8080/users` với nội dung JSON như:

```json
{
  "name": "Duy",
  "age": 17,
  "email": "not-an-email"
}
```
