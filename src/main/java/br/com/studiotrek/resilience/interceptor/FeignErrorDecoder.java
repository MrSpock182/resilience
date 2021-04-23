package br.com.studiotrek.resilience.interceptor;

import br.com.studiotrek.resilience.exception.InternalServerError;
import br.com.studiotrek.resilience.exception.RequestTimeout;
import br.com.studiotrek.resilience.exception.ServiceUnavailable;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        System.out.println(response.status());
        switch (response.status()) {
            case 408:
                return new RequestTimeout(response.toString());
            case 503:
                return new ServiceUnavailable(response.toString());
            default:
                return new InternalServerError(response.toString());
        }
    }
}
