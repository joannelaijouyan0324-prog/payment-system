package com.joanne.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class handles HTTP requests
 * And its return value goes directly into HTTP response body.
 */
@RestController
public class HealthController {

    /**
     * Health check endpoint.
     *
     * @return a simple status message indicating that the payment system is operational.
     */
    @GetMapping("/health")
    public String health() {
        return "Payment system is running";
    }

}
