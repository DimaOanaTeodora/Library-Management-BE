package com.library.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.model.Book;
import com.library.demo.service.BookService;
import com.library.demo.service.BorrowerService;
import com.library.demo.service.InventoryService;
import com.library.demo.service.LibrarianService;
import com.library.demo.service.LoanService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

import org.springframework.http.*;

@RestController
@RequestMapping("/books")
public class BookController {

	private LoanService loanService;
	private BookService bookService;
	private InventoryService inventoryService;
	private LibrarianService librarianService;
	private BorrowerService borrowerService;

	public BookController(LoanService loanService, BookService bookService, InventoryService inventoryService,
			LibrarianService librarianService, BorrowerService borrowerService) {
		super();
		this.loanService = loanService;
		this.bookService = bookService;
		this.inventoryService = inventoryService;
		this.librarianService = librarianService;
		this.borrowerService = borrowerService;
	}

	@PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Book> addBook(@RequestBody Book bookRequest) {
		Book bookResponse = bookService.addBook(bookRequest);
		return ResponseEntity.ok().body(bookService.getBook(bookResponse.getId()));
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Book> getBook(@PathVariable Integer id) {
		return ResponseEntity.ok().body(bookService.getBook(id));
	}
}
