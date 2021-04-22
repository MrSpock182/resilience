package br.com.studiotrek.resilience.service.implement;

import br.com.studiotrek.resilience.repository.UserRepository;
import br.com.studiotrek.resilience.repository.orm.UserOrm;
import br.com.studiotrek.resilience.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
    @Cacheable(cacheNames = "userService")
    public UserOrm findById(final String id) {
        try {
            Thread.sleep(2000);
            return repository.findById(id).get();
        } catch (Exception ex) {
            return null;
        }
    }
}
