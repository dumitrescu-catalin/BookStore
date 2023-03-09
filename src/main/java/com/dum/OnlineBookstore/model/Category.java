package com.dum.OnlineBookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Table(name = "categories")
@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;

    @JsonIgnore
    @OneToMany
    private List<BookEntity> books;


}



