package com.dum.OnlineBookstore.repository;

import com.dum.OnlineBookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepo extends JpaRepository<Category, Long> {


}
