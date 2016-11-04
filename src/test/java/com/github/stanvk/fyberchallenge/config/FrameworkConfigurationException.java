package com.github.stanvk.fyberchallenge.config;

/**
 * Created by Anastasiia on 05.11.2016.
 */
public class FrameworkConfigurationException extends RuntimeException {
    public FrameworkConfigurationException(String message) {
        super(message);
    }

    public FrameworkConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
