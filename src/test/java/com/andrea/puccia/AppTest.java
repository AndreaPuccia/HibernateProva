package com.andrea.puccia;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    @BeforeClass
    public static void setup(){
        factory = Persistence.createEntityManagerFactory("TEST_PERSISTENCE");
        entityManager = factory.createEntityManager();
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void firstTest()
    {
        Student s = new Student();
        s.setCognome("Mario");
        s.setNome("Rossi");
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
        System.out.println(s.toString());
        TypedQuery<Student> q = entityManager.createQuery("from Student",Student.class);
        Student result = q.getSingleResult();
        System.out.println(result.toString());
        assertTrue(result.equals(s));
    }

    @Test
    public void assertTrueTest(){
        System.out.println("Ciaoooo");
        assertTrue(true);
    }
}
