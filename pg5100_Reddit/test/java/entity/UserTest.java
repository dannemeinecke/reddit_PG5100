package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserTest {

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

    @Test
    public void testUserGiveComment(){
        User user = new User();
        user.setName("Thomas");

    }

    @Test
    public void testPersistUsers(){

        User user1 = new User();
        User user2 = new User();


        user1.setName("Peter");
        user1.setSurname("Griffin");
        user1.setAddress(new Address());

        user2.setName("Johan");
        user2.setSurname("Larsson");
        user2.setAddress(new Address());

        assertNull(user1.getUserId());
        assertNull(user2.getUserId());

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


}
