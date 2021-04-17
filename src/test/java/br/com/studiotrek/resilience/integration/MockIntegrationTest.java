package br.com.studiotrek.resilience.integration;

import br.com.studiotrek.resilience.ResilienceApplicationTests;
import br.com.studiotrek.resilience.integration.implementation.MockIntegrationImpl;
import br.com.studiotrek.resilience.integration.implementation.MockyIntegrationWithFeign;
import io.github.resilience4j.fallback.FallbackMethod;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MockIntegrationTest extends ResilienceApplicationTests {

    @InjectMocks
    private MockIntegrationImpl integration;

    @Mock
    private MockyIntegrationWithFeign feign;

    @Override
    public void init() {

    }

    @Test
    public void callApiSuccess() {
        when(feign.callApi(anyString())).thenReturn("Ronaldo");

        integration.callApi(anyString());

        verify(feign).callApi(anyString());
    }

    @Test
    public void callApiFallback() throws Throwable {
        Method testMethod = integration.getClass().getMethod("callApi", String.class);
        FallbackMethod fallbackMethod = FallbackMethod.create("callApiFallback",
                testMethod, new Object[]{"test"}, integration);
        assertThat(fallbackMethod.fallback(new RuntimeException("err")))
                .isEqualTo("Ronaldo");
    }

}
