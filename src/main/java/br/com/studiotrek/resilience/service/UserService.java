package br.com.studiotrek.resilience.service;

import br.com.studiotrek.resilience.repository.orm.UserOrm;

public interface UserService {
    void save(UserOrm orm);

    UserOrm findById(String id);
}
