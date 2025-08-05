# Demo Spring Security

Đây là một ứng dụng Spring Boot đơn giản thể hiện cách sử dụng Spring Security với Security Filter Chain, Authentication Manager, UserDetailsService và mã hóa mật khẩu bằng BCrypt.

## Cấu trúc dự án

- **pom.xml**: File cấu hình Maven với các thư viện Spring Boot, Spring Security, Thymeleaf và H2 database.
- **Application.java**: Lớp chính khởi động ứng dụng Spring Boot.
- **config/PasswordEncoderConfig.java**: Định nghĩa bean PasswordEncoder sử dụng BCrypt.
- **config/SecurityConfig.java**: Cấu hình Security Filter Chain và Authentication Manager.
- **service/CustomUserDetailsService.java**: Triển khai UserDetailsService để tải thông tin người dùng.
- **entity/User.java**: Entity đại diện cho người dùng với username, password và role.
- **controller/HomeController.java**: Controller xử lý các endpoint để kiểm tra xác thực và phân quyền.
- **templates/login.html**: Trang đăng nhập tùy chỉnh sử dụng Thymeleaf, hỗ trợ CSRF và hiển thị thông báo lỗi.

  ```
  src/main/java/com/example/demo/
  ├── Application.java
  ├── config/
  │   ├── PasswordEncoderConfig.java
  │   ├── SecurityConfig.java
  ├── service/
  │   ├── CustomUserDetailsService.java
  ├── entity/
  │   ├── User.java
  ├── controller/
  │   ├── HomeController.java
  src/main/resources/templates/
  ├── login.html
  pom.xml
  README.md
  ```

## Cách chạy

Mở trình duyệt và truy cập `http://localhost:8080/login`.

## Thông tin đăng nhập thử nghiệm

- **Admin**:
  - Tên người dùng: `admin`
  - Mật khẩu: `admin123`
  - Vai trò: `ROLE_ADMIN`
  - Quyền truy cập: `/home`, `/admin`, `/public`
- **User**:
  - Tên người dùng: `user`
  - Mật khẩu: `user123`
  - Vai trò: `ROLE_USER`
  - Quyền truy cập: `/home`, `/user`, `/public`

## Các thành phần chính

- **Security Filter Chain** (`SecurityConfig.java`): Cấu hình bảo mật HTTP, bao gồm quy tắc xác thực, phân quyền (ví dụ: `/admin` chỉ dành cho ROLE_ADMIN) và xử lý form đăng nhập/đăng xuất.
- **Authentication Manager** (`SecurityConfig.java`): Quản lý quá trình xác thực, sử dụng thông tin từ UserDetailsService để kiểm tra đăng nhập.
- **UserDetailsService** (`CustomUserDetailsService.java`): Tải thông tin người dùng từ danh sách in-memory, cung cấp username, password (mã hóa bằng BCrypt) và role.
- **BCrypt** (`PasswordEncoderConfig.java` và `CustomUserDetailsService.java`): Mã hóa mật khẩu người dùng bằng BCryptPasswordEncoder để đảm bảo an toàn.
- **Thymeleaf** (`login.html`): Sử dụng để render trang đăng nhập, hỗ trợ CSRF token và hiển thị thông báo lỗi khi đăng nhập thất bại.

## Các endpoint

- `/public`: Mọi người đều có thể truy cập.
- `/home`: Yêu cầu xác thực, hiển thị thông tin người dùng đăng nhập.
- `/admin`: Yêu cầu vai trò ROLE_ADMIN.
- `/user`: Yêu cầu vai trò ROLE_USER.
- `/login`: Trang đăng nhập tùy chỉnh, hiển thị lỗi nếu đăng nhập thất bại.
