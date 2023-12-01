package com.library.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.demo.model.Inventory;
import com.library.demo.model.Librarian;
import com.library.demo.repository.BookRepository;
import com.library.demo.repository.BorrowerRepository;
import com.library.demo.repository.InventoryRepository;
import com.library.demo.repository.LibrarianRepository;
import com.library.demo.repository.LoanRepository;

@Service
public class LibrarianService {

	private LoanRepository loanRepository;
	private LibrarianRepository librarianRepository;
	private InventoryRepository inventoryRepository;
	private BorrowerRepository borrowerRepository;
	private BookRepository bookRepository;

	public LibrarianService(LoanRepository loanRepository, LibrarianRepository librarianRepository,
			InventoryRepository inventoryRepository, BorrowerRepository borrowerRepository,
			BookRepository bookRepository) {
		super();
		this.loanRepository = loanRepository;
		this.librarianRepository = librarianRepository;
		this.inventoryRepository = inventoryRepository;
		this.borrowerRepository = borrowerRepository;
		this.bookRepository = bookRepository;
	}

	public Librarian addLibrarian(Librarian librarianRequest) {
		return librarianRepository.save(librarianRequest);
	}

	public Librarian getLibrarian(Integer id) {
		Optional<Librarian> librarianOptional = librarianRepository.findById(id);
		if (librarianOptional.isPresent()) {
			return librarianOptional.get();
		} else {
			throw new RuntimeException("Librarian with id " + id + " doesn't exist ");
		}
	}
}
