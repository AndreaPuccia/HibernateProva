package com.andrea.puccia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("hello world!");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST_PERSISTENCE");
        EntityManager entityManager = factory.createEntityManager();
        Student s = new Student();
        s.setCognome("Mario");
        s.setNome("Rossi");
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
        System.out.println(s.toString());
        System.out.println("ciaooooooo");
    }
}
