package br.com.studiotrek.resilience.integration.implementation;

import br.com.studiotrek.resilience.integration.MockIntegration;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MockIntegrationImpl implements MockIntegration {

    private final MockyIntegrationWithFeign integration;

    public MockIntegrationImpl(final MockyIntegrationWithFeign integration) {
        this.integration = integration;
    }

    @Override
    @Cacheable(cacheNames = "mocky")
    @CircuitBreaker(name = "mocky-resilience")
    @Bulkhead(name = "mocky-resilience")
    @Retry(name = "mocky-resilience", fallbackMethod = "callApiFallback")
    public String callApi(final String id) {
        return integration.callApi(id);
    }

    private String callApiFallback(final String id, final Exception ex) {
        return "Ronaldo";
    }

}