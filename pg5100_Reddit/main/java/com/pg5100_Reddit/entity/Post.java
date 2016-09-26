package com.pg5100_Reddit.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private Integer upVote;
    private Integer downVote;

    private Date createdDate;

    @OneToMany
    private List<Comment> commentList;

    @OneToOne
    private User user;


}
