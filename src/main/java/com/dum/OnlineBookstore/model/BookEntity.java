package com.dum.OnlineBookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String isbn;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private String publisher;
    private BigDecimal price;
    @Column(name = "quantity_in_stock")
    private Integer quantityInStocks;
    private LocalDate date;

}
