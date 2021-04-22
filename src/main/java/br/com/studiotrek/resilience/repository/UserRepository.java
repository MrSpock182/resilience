package br.com.studiotrek.resilience.repository;

import br.com.studiotrek.resilience.repository.orm.UserOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserOrm, String> {
}
