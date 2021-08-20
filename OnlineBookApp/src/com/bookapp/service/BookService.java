package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import java.util.*;
public interface BookService {
Book getBookById(int bookid) throws BookNotFoundException;
List<Book> getBooksByAuthor(String author) throws BookNotFoundException;
List<Book> getBooksByCategory(String category) throws BookNotFoundException;
List<Book> getAllBooks();
List<Book> getBooksByLessPrice(double price) throws BookNotFoundException;
}
