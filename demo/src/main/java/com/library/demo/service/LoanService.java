package com.library.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.demo.model.Inventory;
import com.library.demo.model.Loan;
import com.library.demo.repository.BookRepository;
import com.library.demo.repository.BorrowerRepository;
import com.library.demo.repository.InventoryRepository;
import com.library.demo.repository.LibrarianRepository;
import com.library.demo.repository.LoanRepository;

@Service
public class LoanService {

	private LoanRepository loanRepository;
	private LibrarianRepository librarianRepository;
	private InventoryRepository inventoryRepository;
	private BorrowerRepository borrowerRepository;
	private BookRepository bookRepository;

	public LoanService(LoanRepository loanRepository, LibrarianRepository librarianRepository,
			InventoryRepository inventoryRepository, BorrowerRepository borrowerRepository,
			BookRepository bookRepository) {
		super();
		this.loanRepository = loanRepository;
		this.librarianRepository = librarianRepository;
		this.inventoryRepository = inventoryRepository;
		this.borrowerRepository = borrowerRepository;
		this.bookRepository = bookRepository;
	}
	public Loan addLoan(Loan loanRequest) {
		return loanRepository.save(loanRequest);
	}

	public Loan getLoan(Integer id) {
		Optional<Loan> loanOptional = loanRepository.findById(id);
		if (loanOptional.isPresent()) {
			return loanOptional.get();
		} else {
			throw new RuntimeException("Loan with id " + id + " doesn't exist ");
		}
	}
}
