package br.com.studiotrek.resilience.integration.implementation;

import br.com.studiotrek.resilience.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mocky", url = "${feign.client.config.mocky.url}", configuration = FeignConfiguration.class)
public interface MockyIntegrationWithFeign {
    @GetMapping("/{id}")
    String callApi(@PathVariable("id") final String id);
}
