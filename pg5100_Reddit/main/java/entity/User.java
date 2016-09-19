package entity;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = User.GET_ALL_USERS, query = "SELECT u FROM User u"),
        @NamedQuery(name = User.GET_USER_BY_ID, query = "SELECT u FROM User u WHERE u.userId =?")
})

@Entity
public class User {

    public static final String GET_ALL_USERS = "GET_ALL_USERS";
    public static final String GET_USER_BY_ID = "GET_USER_BY_ID";
    public static final String GET_NUMBEROF_USERS_FROM_COUNTRY = "GET_NUMBEROF_USERS_FROM_COUNTRY";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String surname;


    @Embedded
    private Address address;

    @OneToOne
    private Email email;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Post> posts;

    //No-arg constructor
    public User(){

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
