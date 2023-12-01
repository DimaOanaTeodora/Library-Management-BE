package com.library.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.demo.model.Borrower;
import com.library.demo.model.Inventory;
import com.library.demo.repository.BookRepository;
import com.library.demo.repository.BorrowerRepository;
import com.library.demo.repository.InventoryRepository;
import com.library.demo.repository.LibrarianRepository;
import com.library.demo.repository.LoanRepository;

@Service
public class BorrowerService {
	private LoanRepository loanRepository;
	private LibrarianRepository librarianRepository;
	private InventoryRepository inventoryRepository;
	private BorrowerRepository borrowerRepository;
	private BookRepository bookRepository;

	public BorrowerService(LoanRepository loanRepository, LibrarianRepository librarianRepository,
			InventoryRepository inventoryRepository, BorrowerRepository borrowerRepository,
			BookRepository bookRepository) {
		super();
		this.loanRepository = loanRepository;
		this.librarianRepository = librarianRepository;
		this.inventoryRepository = inventoryRepository;
		this.borrowerRepository = borrowerRepository;
		this.bookRepository = bookRepository;
	}
	
	public Borrower addBorrower(Borrower borrowerRequest) {
		return borrowerRepository.save(borrowerRequest);
	}

	public Borrower getBorrower(Integer id) {
		Optional<Borrower> borrowerOptional = borrowerRepository.findById(id);
		if (borrowerOptional.isPresent()) {
			return borrowerOptional.get();
		} else {
			throw new RuntimeException("Borrower with id " + id + " doesn't exist ");
		}
	}
}
