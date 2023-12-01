package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.demo.model.Librarian;

import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
	
}