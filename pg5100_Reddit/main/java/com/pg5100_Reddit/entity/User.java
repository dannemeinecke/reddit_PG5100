package com.pg5100_Reddit.entity;

import com.pg5100_Reddit.validation.Age;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = User.GET_ALL_USERS, query = "SELECT u FROM User u"),
        @NamedQuery(name = User.GET_USER_BY_ID, query = "SELECT u FROM User u WHERE u.userId =?"),
        @NamedQuery(name = User.GET_NUMBEROF_USERS_FROM_COUNTRY, query = "SELECT DISTINCT(u.address) FROM User u")
})

@Entity
public class User {

    public static final String GET_ALL_USERS = "GET_ALL_USERS";
    public static final String GET_USER_BY_ID = "GET_USER_BY_ID";
    public static final String GET_NUMBEROF_USERS_FROM_COUNTRY = "GET_NUMBEROF_USERS_FROM_COUNTRY";

    @Id
    @NotNull
    private String userId;

    @NotNull
    @Size(min = 2 , max = 50)
    private String name;

    @Size(min = 2 , max = 50)
    private String middleName;

    @NotNull
    @Size(min = 2 , max = 100)
    private String surname;

    @NotNull
    private Date registrationDate;

    @NotNull
    @Age(min = 10)
    private Date birthDate;

    @Embedded
    @Cascade(CascadeType.ALL)
    private Address address;

    @OneToOne
    @Pattern(regexp =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private Email email;

    //No-arg constructor
    public User(){

    }

    public User(String name, String surname, Address address, Email email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
