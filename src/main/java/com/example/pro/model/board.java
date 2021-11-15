package com.example.pro.model;



import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Data
public class board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2,max = 30,message = "2자이상 30자 이하로 써주세요")
    private String title;
    private String content;
    @CreationTimestamp
    private Timestamp writedate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;
}
