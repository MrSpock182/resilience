package br.com.studiotrek.resilience.service.implement;

import br.com.studiotrek.resilience.exception.InternalServerError;
import br.com.studiotrek.resilience.exception.NotFound;
import br.com.studiotrek.resilience.repository.UserRepository;
import br.com.studiotrek.resilience.repository.orm.UserOrm;
import br.com.studiotrek.resilience.service.UserService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @CacheEvict(value="userService", allEntries=true)
    public void save(final UserOrm orm) {
        repository.save(orm);
    }

    @Override
    @Retry(name = "mocky-resilience", fallbackMethod = "findByIdFallback")
    @CircuitBreaker(name = "mocky-resilience")
    @Bulkhead(name = "mocky-resilience")
    @Cacheable(cacheNames = "userService")
    public UserOrm findById(final String id) {
        try {
            Optional<UserOrm> optional = repository.findById(id);

            if(optional.isEmpty()) {
                throw new NotFound("User don't exists");
            }

            return optional.get();
        } catch (NotFound ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
    }

    public UserOrm findByIdFallback(final String id, final Exception ex) {
        return new UserOrm(UUID.randomUUID().toString(), "FALLBACK");
    }
}
