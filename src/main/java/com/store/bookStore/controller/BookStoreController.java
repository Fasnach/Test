/**
 * 
 */
package com.store.bookStore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.bookStore.entity.BookInfo;
import com.store.bookStore.service.BookStoreService;

/**
 * @author Fasna
 *
 */
@RestController
public class BookStoreController {
	@Autowired
	private BookStoreService bookStoreService;

	/**
	 * Get all books
	 * 
	 * @return
	 */
	@GetMapping("/books")
	public ResponseEntity<List<BookInfo>> getAllBooks() {
		return new ResponseEntity<List<BookInfo>>(bookStoreService.getAllBooks(), HttpStatus.OK);
	}

	/**
	 * Get the book with given id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/books/{id}")
	public ResponseEntity<BookInfo> getBook(@PathVariable int id) {
		BookInfo bookInfo = bookStoreService.getBook(id);
		if (bookInfo != null)
			return new ResponseEntity<BookInfo>(bookStoreService.getBook(id), HttpStatus.OK);
		else
			return new ResponseEntity("No books found with the given id ", HttpStatus.NOT_FOUND);
	}

	/**
	 * Create book
	 * 
	 * @param book
	 * @return
	 */
	@PostMapping("/books")
	public ResponseEntity<Object> addBook(@RequestBody BookInfo book) {
		bookStoreService.addBook(book);
		return new ResponseEntity("Successfully created a book", HttpStatus.CREATED);
	}

	/**
	 * update book
	 * 
	 * @param id
	 * @param book
	 * @return
	 */
	@PutMapping("/books/{id}")
	public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody BookInfo book) {
		BookInfo bookInfo = bookStoreService.updateBook(id, book);

		if (bookInfo != null)
			return new ResponseEntity("Updated Successfully ", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity("Unable to find book with the given id ", HttpStatus.NOT_FOUND);
	}

	/**
	 * delete book
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		bookStoreService.deleteBook(id);
		return new ResponseEntity("Delete the book successfully ", HttpStatus.OK);
	}

	/**
	 * patch method
	 * 
	 * @param id
	 * @param fields
	 * @return
	 */
	@PatchMapping("/books/{id}")
	public ResponseEntity<Object> patchUpdate(@PathVariable int id, @RequestBody Map<Object, Object> fields) {
		BookInfo bookInfo = bookStoreService.patchUpdateBook(id, fields);
		if (bookInfo != null)
			return new ResponseEntity("Updated Successfully ", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity("Unable to find book with the given id ", HttpStatus.NOT_FOUND);
	}

}
