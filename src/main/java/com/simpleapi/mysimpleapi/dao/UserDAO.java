package com.simpleapi.mysimpleapi.dao;

import com.simpleapi.mysimpleapi.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
}
