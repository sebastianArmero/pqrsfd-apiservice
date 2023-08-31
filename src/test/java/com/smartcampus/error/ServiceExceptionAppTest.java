package com.smartcampus.error;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class ServiceExceptionAppTest {

    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Test error message";

        // Call the constructor
        ServiceExceptionApp exception = new ServiceExceptionApp(errorMessage);

        // Assertions
        assertEquals(errorMessage, exception.getMessage());
        // Add assertions to verify the logging behavior (e.g., using a mock logger)
    }

    @Test
    public void testConstructorWithMessageAndCause() {
        String errorMessage = "Test error message";
        Throwable cause = new RuntimeException("Test cause");

        // Call the constructor
        ServiceExceptionApp exception = new ServiceExceptionApp(errorMessage, cause);

        // Assertions
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
        // Add assertions to verify the logging behavior (e.g., using a mock logger)
    }
}
