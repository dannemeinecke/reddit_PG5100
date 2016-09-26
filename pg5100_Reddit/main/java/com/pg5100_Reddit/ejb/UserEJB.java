package com.pg5100_Reddit.ejb;

import com.pg5100_Reddit.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

@Stateless
public class UserEJB {

    @PersistenceContext
    private EntityManager em;

    public User getUserById(int id){

        return null;
    }

    public String createNewUser(@NotNull String userId, @NotNull String name, @NotNull String surName){
        if(alreadyInDataBase(userId)){
            return null;
        }
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setSurname(surName);

        em.persist(user);

        return userId;
    }

    private boolean alreadyInDataBase(String userId) {
        User user = em.find(User.class, userId);
        return user != null;
    }

    public void changeUserName(@NotNull String userId, @NotNull String firstName){
            User user = em.find(User.class, userId);
            if(user != null) {
                user.setName(firstName);
            }
    }
    public User findUser(@NotNull String id){
        return em.find(User.class, id);
    }
}
