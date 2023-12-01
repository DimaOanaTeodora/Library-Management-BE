package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.demo.model.Loan;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	
}