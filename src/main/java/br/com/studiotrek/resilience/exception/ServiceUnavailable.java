package br.com.studiotrek.resilience.exception;

public class ServiceUnavailable extends RuntimeException {
    public ServiceUnavailable(String message) {
        super(message);
    }

    public ServiceUnavailable(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUnavailable(Throwable cause) {
        super(cause);
    }
}
