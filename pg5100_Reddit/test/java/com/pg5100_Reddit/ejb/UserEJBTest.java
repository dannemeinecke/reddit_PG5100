package com.pg5100_Reddit.ejb;

import com.pg5100_Reddit.entity.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class UserEJBTest {

    @Deployment
    public static JavaArchive createDeployment() {
        /*
            This creates a Jar file containing the given classes, and
            then deploy it to WildFly
         */
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.pg5100_Reddit").addAsResource("META-INF/persistence.xml");
    }

    @EJB
    private UserEJB userEJB;

    @Test
    public void testGetUserById() throws Exception {

    }

    @Test
    public void testCreateNewUser() throws Exception {
        String id = userEJB.createNewUser("123","Nisse","Peedddo");

        assertNotNull(id);
    }
    @Test
    public void changeUserName() throws Exception {
        String id = userEJB.createNewUser("123", "Nisse", "Peedddo");
        userEJB.changeUserName(id, "Tommy");
        User user = userEJB.findUser(id);
        assertEquals(user.getName(), "Tommy");
    }
}