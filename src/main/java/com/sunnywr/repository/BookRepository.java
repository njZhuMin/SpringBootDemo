package com.sunnywr.repository;

import com.sunnywr.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // 通过名称查询
    List<Book> findByName(String name);

    List<Book> findByNameContaining(String name);
}
