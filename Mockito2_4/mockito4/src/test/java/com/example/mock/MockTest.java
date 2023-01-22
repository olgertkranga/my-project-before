package com.example.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.mock.Book;
import com.example.mock.BookRepository;

public class MockTest {

	@Test
	public void demoMock(){
		BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
		BookService bookService = new BookService(bookRepositoryMock);
		
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit In Action", 400, LocalDate.now());
		
		bookService.addBook(book1);
		bookService.addBook(book2);
		
		bookRepositoryMock.verify(book2, 1);
		
	}

	@Test
	public void demoMockWithMockito(){
		BookRepository bookRepositoryMock = Mockito.mock(BookRepository.class);
		BookService bookService = new BookService(bookRepositoryMock);
		
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit In Action", 400, LocalDate.now());
		
		bookService.addBook(book1);
		bookService.addBook(book2);
		
		Mockito.verify(bookRepositoryMock, Mockito.times(1)).save(book2);
		Mockito.verify(bookRepositoryMock, Mockito.times(0)).save(book1);
		
		//Mockito.verify(bookRepositoryMock).save(book2);
		//Mockito.verify(bookRepositoryMock).save(book1);
		
	}
	
}
