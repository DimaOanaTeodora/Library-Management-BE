package com.library.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.demo.model.Book;
import com.library.demo.repository.BookRepository;
import com.library.demo.repository.BorrowerRepository;
import com.library.demo.repository.InventoryRepository;
import com.library.demo.repository.LibrarianRepository;
import com.library.demo.repository.LoanRepository;

@Service
public class BookService {
	private LoanRepository loanRepository;
	private LibrarianRepository librarianRepository;
	private InventoryRepository inventoryRepository;
	private BorrowerRepository borrowerRepository;
	private BookRepository bookRepository;

	public BookService(LoanRepository loanRepository, LibrarianRepository librarianRepository,
			InventoryRepository inventoryRepository, BorrowerRepository borrowerRepository,
			BookRepository bookRepository) {
		super();
		this.loanRepository = loanRepository;
		this.librarianRepository = librarianRepository;
		this.inventoryRepository = inventoryRepository;
		this.borrowerRepository = borrowerRepository;
		this.bookRepository = bookRepository;
	}

	public Book addBook(Book bookRequest) {
		return bookRepository.save(bookRequest);
	}

	public Book getBook(Integer id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if (bookOptional.isPresent()) {
			return bookOptional.get();
		} else {
			throw new RuntimeException("Book with id " + id + " doesn't exist ");
		}
	}
}
