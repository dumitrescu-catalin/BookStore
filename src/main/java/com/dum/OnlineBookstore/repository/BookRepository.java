package com.dum.OnlineBookstore.repository;

import com.dum.OnlineBookstore.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {


    Collection<BookEntity> findByTitle(String title);

    Collection<BookEntity> findByAuthor(String author);

    Collection<BookEntity> findByPrice(BigDecimal price);

    List<BookEntity> findByQuantityInStocks(Integer quantityInStocks);

}
