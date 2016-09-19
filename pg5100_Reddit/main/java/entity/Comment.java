package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    @Size (min = 1, max = 500)
    private String text;

    private Integer upVote;
    private Integer downVote;

    private Date createdDate;

}
