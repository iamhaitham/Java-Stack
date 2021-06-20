package com.codingdojo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookInfo {
	private final BookService bookService;
	public BookInfo(BookService bookService) {
		this.bookService=bookService;
	}
    @RequestMapping(value="/books/{id}",method=RequestMethod.GET)
    public String info(Model model,@PathVariable(value="id") Long id) {
    	Book book=bookService.findBook(id);
    	model.addAttribute("book",book);
    	return "Show.jsp";
    }
    @RequestMapping(value="/books/{id}",method=RequestMethod.POST)
    public String deleteBook(@PathVariable(value="id")Long id) {
    	bookService.deleteBook(id);
    	return "redirect:/books/{id}";
    }
    


}
