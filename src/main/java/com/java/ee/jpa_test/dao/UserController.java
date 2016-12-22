package com.java.ee.jpa_test.dao;

import com.java.ee.jpa_test.model.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserController {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query nativeQuery = entityManager.
                createNativeQuery("SELECT * FROM USERS", UsersEntity.class);

        List<UsersEntity> resultList = nativeQuery.getResultList();
        System.out.println(resultList);
    }
}
