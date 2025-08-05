package com.example.demoexeptionhandler.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý lỗi nếu controller không có xử lý local
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    public String handleGlobal(ProductNotFoundException ex) {
        return "GLOBAL HANDLER: " + ex.getMessage();
    }

    // Xử lý fallback cho tất cả exception khác
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleAll(Exception ex) {
        return "GLOBAL HANDLER (GENERIC): " + ex.getMessage();
    }
}
