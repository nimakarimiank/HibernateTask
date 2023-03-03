package database.entities;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity(name = "users")
public class Users {
    @Id
    @Column(name = "user_id")
    private int id;

}
