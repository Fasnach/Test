package com.store.bookStore.exception;

public class BookStoreException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final Integer code;

	public Integer getCode() {
		return code;
	}

	public BookStoreException(Integer code, String message) {
		super(message);
		this.code = code;
	}

}
