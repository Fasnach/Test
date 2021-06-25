package com.store.bookStore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.store.bookStore.entity.BookInfo;

@Repository
public interface BookRepository extends CrudRepository<BookInfo, Integer> {

}
