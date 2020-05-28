package com.andrea.puccia.it;

import com.andrea.puccia.Student;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppIT
{
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @BeforeClass
    public static void setUpClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("TEST_PERSISTENCE");
    }

    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Student s").executeUpdate();
        entityManager.getTransaction().commit();
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @AfterClass
    public static void tearDownClass() {
        entityManagerFactory.close();
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
        assertTrue(true);
    }
}
