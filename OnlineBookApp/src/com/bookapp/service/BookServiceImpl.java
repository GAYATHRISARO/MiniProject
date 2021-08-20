package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {

	
    @Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		List<Book> bookList=showBooks();
		boolean isPresent=false;
    	for(Book book:bookList)
    	{
    		if(book.getBookId()==bookid)
    		{
    			isPresent=true;
    			return book;
    		}
    	}
    	if(!isPresent) {
    		throw new BookNotFoundException("Book is not available");
    	}
    	return null;
	}
    
	@Override
	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
		List<Book> bookAuthor=showBooks();
		List<Book> bookByAuthor=new ArrayList<>();
		boolean isPresent=false;
		for(Book book:bookAuthor)
		{
			if(book.getAuthor().equals(author))
			{
				isPresent=true;
				bookByAuthor.add(book);
			}
		}
		if(!isPresent) {
			throw new BookNotFoundException("Author is not available");
		}
		return bookByAuthor;
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		List<Book> bookCategory=showBooks();
		List<Book> category1=new ArrayList<>();
		boolean isPresent=false;
		for(Book book:bookCategory)
		{
			if(category.equalsIgnoreCase(book.getCategory()))
			{
				isPresent=true;
				category1.add(book);
				
			}
		}
		if(!isPresent) {
			throw new BookNotFoundException("Category is not available");
		}
		return category1;
	}

	@Override
	public List<Book> getAllBooks() {
		
		return showBooks();
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		List<Book> bookPrice=showBooks();
		List<Book> lessPrice=new ArrayList<>();
		for(Book book:bookPrice) {
			if(book.getPrice()<price) {
				lessPrice.add(book);
			}
			throw new BookNotFoundException("No books ..");
		}
		return lessPrice;
	}

	public List<Book> showBooks(){
    	return Arrays.asList(new Book("Java in action","Kathy","Tech",1900,1),
                     new Book("Sam club","Robin","Self",400,2),
                     new Book("Captain Robin Hook","Hal","Children",800,3),
                     new Book("Pooh Tales","Kathy","Children",700,4),
                     new Book("LeaderShip","Robin","Self",1900,5),
                     new Book("C language","ABC","Self",2400,6));
    }
}
