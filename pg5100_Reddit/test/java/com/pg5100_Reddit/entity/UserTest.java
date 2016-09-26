package com.pg5100_Reddit.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserTest {

    //https://www.lynda.com/Java-tutorials/Java-EE-Essentials-Enterprise-JavaBeans/170059-2.html
    private EntityManagerFactory factory;
    private EntityManager em;

    @Before
    public void init(){
        factory = Persistence.createEntityManagerFactory("DB");
        em = factory.createEntityManager();
    }
    @After
    public void tearDown(){
        em.close();
        factory.close();
    }

    //TO-DO
    @Test
    public void testUserGiveComment(){
        User user = new User();
        user.setName("Thomas");

        Post post = new Post();
    }

    @Test
    public void testPersistUsers(){

        User user1 = new User();
        User user2 = new User();

        user1.setUserId("1");
        user1.setName("Peter");
        user1.setSurname("Griffin");
        user1.setAddress(new Address());


        user2.setUserId("2");
        user2.setName("Johan");
        user2.setSurname("Larsson");
        user2.setAddress(new Address());

       // assertNull(user1.getUserId());
       // assertNull(user2.getUserId());

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            em.persist(user1);
            em.persist(user2);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            fail();
        }


        assertNotNull(user1.getUserId());
        System.out.println("Generated ID : " + user1.getUserId());

        Query query = em.createQuery("SELECT u FROM User u");
        List<User> userListResult = query.getResultList();

        for (User user : userListResult) {
            System.out.println(user.getName());
            System.out.println(user.getSurname());
        }

        assertEquals(2 , userListResult.size());
    }

    private void fail() {
        System.out.println("SMTH went wrong!");
    }

    @Test
    public void testGetAllUserDistinctCountry(){

        User user1 = new User();
        user1.setUserId("1");
        Address address1 = new Address();
        address1.setCountry("Sweden");

        User user2 = new User();
        user2.setUserId("2");
        Address address2 = new Address();
        address2.setCountry("Norway");

        User user3 = new User();
        user3.setUserId("3");
        Address address3 = new Address();
        address3.setCountry("Somalia");

        User user4 = new User();
        user4.setUserId("4");
        Address address4 = new Address();
        address4.setCountry("Somalia");

        user1.setAddress(address1);
        user2.setAddress(address2);
        user3.setAddress(address3);
        user4.setAddress(address4);

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{

            em.persist(user1);
            em.persist(user2);
            em.persist(user3);
            em.persist(user4);
            tx.commit();

        }catch(Exception e){
            tx.rollback();
            fail();
        }


        assertNotNull(user1.getUserId());
        assertNotNull(user2.getUserId());
        assertNotNull(user3.getUserId());
        assertNotNull(user4.getUserId());

        int counter;

        Query query = em.createQuery("SELECT distinct(u.address.country) FROM User u");
        List<String> userDistinct = query.getResultList();

        for (String string : userDistinct) {
            System.out.println(string);
        }

        counter = userDistinct.size();

        assertEquals(3, counter);
    }

}
