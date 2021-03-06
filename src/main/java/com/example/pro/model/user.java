package com.example.pro.model;



import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String role;
    @CreationTimestamp
    private Timestamp createdate;

}
