package com.rosu.cotroller;

import com.rosu.model.User;
import com.rosu.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {
    public void initialize() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("TODOFx");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserRepository userRepository = new UserRepository(entityManager);
        User user = new User();

        user.setUsername("blah");
        user.setPassword("blah");

        userRepository.save(user);

    }
}
