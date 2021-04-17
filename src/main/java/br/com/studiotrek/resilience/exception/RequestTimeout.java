package br.com.studiotrek.resilience.exception;

public class RequestTimeout extends RuntimeException {
    public RequestTimeout(String message) {
        super(message);
    }

    public RequestTimeout(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestTimeout(Throwable cause) {
        super(cause);
    }
}
