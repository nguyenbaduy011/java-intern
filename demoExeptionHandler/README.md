# Exception Handler Demo (Spring Boot)

## Mục tiêu

- Thể hiện cách xử lý exception theo 2 cách:
  - Local (`@ExceptionHandler` trong controller)
  - Global (`@ControllerAdvice`)

## Cấu trúc file

- `ProductController.java`: API `/products/{id}`
- `ProductNotFoundException.java`: Custom exception
- `GlobalExceptionHandler.java`: Toàn cục
- `@ExceptionHandler(...)`: Cục bộ trong controller

## Cách chạy

1. Mở project trong IntelliJ hoặc IDE bất kỳ.
2. Chạy `DemoApplication.java`.
3. Dùng trình duyệt hoặc Postman:
   - `GET http://localhost:8080/products/1` → "Product Found!"
   - `GET http://localhost:8080/products/999` → "LOCAL HANDLER: Product with id 999 not found"

## Ghi chú

- Nếu xóa `@ExceptionHandler` local trong controller, thì global handler sẽ được dùng.
