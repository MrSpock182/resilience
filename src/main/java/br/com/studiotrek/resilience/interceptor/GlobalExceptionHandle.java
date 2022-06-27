package br.com.studiotrek.resilience.interceptor;

import br.com.studiotrek.resilience.exception.InternalServerError;
import br.com.studiotrek.resilience.exception.NotFound;
import br.com.studiotrek.resilience.exception.RequestTimeout;
import br.com.studiotrek.resilience.exception.ServiceUnavailable;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ResponseBody
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(RequestTimeout.class)
    public String handleErrorTimeout(final RequestTimeout ex, final WebRequest request) {
        return "REQUEST_TIMEOUT";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ServiceUnavailable.class)
    public String handleErrorUnavailable(final ServiceUnavailable ex, final WebRequest request) {
        return "SERVICE_UNAVAILABLE";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerError.class)
    public String handleErrorInternal(final InternalServerError ex, final WebRequest request) {
        return "INTERNAL_SERVER_ERROR";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public String handleErrorNotFound(final NotFound ex, final WebRequest request) {
        return "NOT_FOUND";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CallNotPermittedException.class)
    public String resilience4j(final CallNotPermittedException ex, final WebRequest request) {
        return "CIRCUIT_BREAKER_CLOSE";
    }

}
