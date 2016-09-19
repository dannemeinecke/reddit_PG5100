package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Email {

    @Id
    @GeneratedValue
    private Long id;

    private String emailAddress;

}
