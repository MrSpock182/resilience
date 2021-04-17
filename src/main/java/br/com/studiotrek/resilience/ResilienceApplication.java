package br.com.studiotrek.resilience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCaching
@EntityScan(basePackages = "br.com.studiotrek.resilience")
@EnableFeignClients(basePackages = "br.com.studiotrek.resilience")
@SpringBootApplication(scanBasePackages = "br.com.studiotrek.resilience")
public class ResilienceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResilienceApplication.class, args);
    }
}
