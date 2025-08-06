package com.example.demologging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Khởi tạo Logger cho class này
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    // Endpoint để demo các mức log
    @GetMapping("/log/{input}")
    public String logMessage(@PathVariable String input) {
        // Ghi log ở các mức khác nhau
        logger.debug("DEBUG: Received input: {}", input);
        logger.info("INFO: Processing input: {}", input);
        logger.warn("WARN: Input may need validation: {}", input);
        if ("error".equalsIgnoreCase(input)) {
            logger.error("ERROR: Invalid input detected: {}", input);
            return "Error logged for input: " + input;
        }
        return "Logged input: " + input;
    }

    // Endpoint để demo exception logging
    @GetMapping("/log/error")
    public String logError() {
        try {
            throw new RuntimeException("Sample exception for logging");
        } catch (Exception e) {
            // Ghi log exception với stack trace
            logger.error("ERROR: Exception occurred", e);
            return "Exception logged";
        }
    }
}
