package com.bookapp.client;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;
import java.util.Scanner;

public class MainUser {

	public static void main(String[] args) {
		BookService bookService=new BookServiceImpl();
        Scanner s=new Scanner(System.in);
        System.out.println(" Enter your choice ...");
        System.out.println(" 1.Id \n 2.Author\n 3.Category\n 4.Price\n 5.All");
        int n=s.nextInt();
        switch(n)
        {
        	case 1:
        		int id=s.nextInt();
                  try {
        	           System.out.println(bookService.getBookById(id));
                  }
                  catch(BookNotFoundException e) {
                  	System.out.println(e.getMessage());
                  }
                  break;
        	case 2:
        		 String author=s.next();
                   try {
        	            System.out.println(bookService.getBooksByAuthor(author));
                   }
                   catch(BookNotFoundException e) {
                   	System.out.println(e.getMessage());
                   }
                   break;
        	case 3:
        		String category=s.next();
                   try {
    	                System.out.println(bookService.getBooksByCategory(category));
                   }
        	        catch(BookNotFoundException e) {
        	         System.out.println(e.getMessage());
                    }
                   break;
        	case 4:
        		double price=s.nextDouble();
        		try {
	                System.out.println(bookService.getBooksByLessPrice(price));
               }
    	        catch(BookNotFoundException e) {
    	         System.out.println(e.getMessage());
                }
        		break;
        	case 5:
			System.out.println(bookService.getAllBooks());
        		break;
        }
        s.close();
	}

}
