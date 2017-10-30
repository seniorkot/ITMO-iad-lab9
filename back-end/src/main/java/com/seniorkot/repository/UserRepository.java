package com.seniorkot.repository;

import com.seniorkot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findOneByLogin(String login);
    User findOneByLoginAndPassword(String login, String password);
}
