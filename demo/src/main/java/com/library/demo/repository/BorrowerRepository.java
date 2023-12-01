package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.demo.model.Borrower;

import java.util.Optional;

public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
}