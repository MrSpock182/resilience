//package br.com.studiotrek.resilience.configuration;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.cache.CacheBuilder;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.concurrent.ConcurrentMapCache;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.util.Collections;
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//public class CacheConfiguration extends CachingConfigurerSupport {
//
//    @Bean
//    public CacheManager cacheManager() {
//        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager() {
//            @Override
//            protected Cache createConcurrentMapCache(final String name) {
//                return new ConcurrentMapCache(name,
//                        CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES)
//                                .maximumSize(100).build().asMap(), false);
//            }
//        };
//        cacheManager.setCacheNames(Collections.singletonList("user"));
//        return cacheManager;
//    }
//
//    @Bean
//    @Primary
//    public RedisCacheConfiguration defaultCacheConfiguration(final ObjectMapper mapper) {
//        return RedisCacheConfiguration.defaultCacheConfig()
//                .serializeKeysWith(RedisSerializationContext
//                        .SerializationPair.fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext
//                        .SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(mapper)));
//    }
//
//}
