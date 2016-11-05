package com.github.stanvk.fyberchallenge.ui.common;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public class UiException extends RuntimeException {
    public UiException(String message) {
        super(message);
    }

    public UiException(String message, Throwable cause) {
        super(message, cause);
    }
}
