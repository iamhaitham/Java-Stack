package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	public Book createBook(Book b) {
        return bookRepository.save(b);
	}
	public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
		Book myBook=findBook(id);
		myBook.setTitle(title);
		myBook.setDescription(desc);
		myBook.setLanguage(lang);
		myBook.setNumberOfPages(numOfPages);
		return bookRepository.save(myBook);
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	
}
