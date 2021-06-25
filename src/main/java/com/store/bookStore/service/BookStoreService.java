package com.store.bookStore.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.store.bookStore.entity.BookInfo;
import com.store.bookStore.repository.BookRepository;

@Service
public class BookStoreService {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Get all books
	 * 
	 * @return
	 */
	public List<BookInfo> getAllBooks() {
		List<BookInfo> books = new ArrayList<BookInfo>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}

	/**
	 * get book by id
	 * 
	 * @param id
	 * @return
	 */
	public BookInfo getBook(int id) {

		return bookRepository.findById(id).orElse(null);

	}

	/**
	 * create book
	 * 
	 * @param book
	 */
	public void addBook(BookInfo book) {
		if (book != null) {
			bookRepository.save(book);
		}

	}

	/**
	 * update book
	 * 
	 * @param id
	 * @param book
	 * @return
	 */
	public BookInfo updateBook(int id, BookInfo book) {
		BookInfo existingBook = bookRepository.findById(id).orElse(null);
		if (existingBook != null) {
			existingBook.setId(existingBook.getId());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setCategory(book.getCategory());
			existingBook.setClassification(book.getClassification());
			existingBook.setDescription(book.getDescription());
			existingBook.setIsbn(book.getIsbn());
			existingBook.setName(book.getName());
			existingBook.setPrice(book.getPrice());
			bookRepository.save(existingBook);
		}
		return existingBook;

	}

	/**
	 * delete book
	 * 
	 * @param id
	 */
	public void deleteBook(int id) {

		bookRepository.deleteById(id);
	}

	/**
	 * patch update
	 * 
	 * @param id
	 * @param fields
	 * @return
	 */
	public BookInfo patchUpdateBook(int id, Map<Object, Object> fields) {
		BookInfo existingBook = bookRepository.findById(id).orElse(null);
		if (existingBook != null) {
			fields.forEach((k, v) -> {
				Field field = ReflectionUtils.findField(BookInfo.class, (String) k);
				field.setAccessible(true);
				if (field.getType().isEnum()) {
					Method valueOf;
					try {
						valueOf = field.getType().getMethod("valueOf", String.class);
						Object value = valueOf.invoke(null, v);
						field.set(existingBook, value);
					} catch (NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					ReflectionUtils.setField(field, existingBook, v);
				}

			});

			bookRepository.save(existingBook);
		}

		return existingBook;
	}
}
