package br.com.studiotrek.resilience.resource;

import br.com.studiotrek.resilience.integration.MockIntegration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class MockApi {

    private final MockIntegration integration;

    public MockApi(MockIntegration integration) {
        this.integration = integration;
    }

    @ResponseStatus(OK)
    @GetMapping("/hello")
    public String mock() {
//        return integration.callApi("bb065c58-5c09-4b4c-9d17-7e981a287578");
//        return integration.callApi("df2801f1-a8d6-462f-9472-ccfd004294d0");
        return integration.callApi("d4ea1aa9-12f6-4cbf-95e5-50d6485e93e2");
    }

}
