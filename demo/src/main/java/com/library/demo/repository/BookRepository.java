package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.demo.model.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
