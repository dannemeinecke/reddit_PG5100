package com.pg5100_Reddit.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    @Size (min = 1, max = 500)
    private String text;

    private Integer upVote;
    private Integer downVote;

    //jpa2.1 -> java 7model
    private Date createdDate;

    @OneToMany(fetch = FetchType.LAZY) //Lazy is the default here, as data structure might be big
    private List<Comment> commentList;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}


