package com.shreyansh.bookStore;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-api/books")
public class MyBookStoreController {
	
	@Autowired
	private MyBookService myBookService;
	
	//add new book
		@PostMapping(value = "/addBooks")
		public void addNewBookDetails(@RequestBody BookEntity book){
			   myBookService.addNewBook(book);
		}
		
	//add new book list
		@PostMapping(value = "/addBookList")
		public void addMultipleBookDetails(@RequestBody List<BookEntity> booklist){
			  myBookService.addBookList(booklist);
		}
		
		//get all books
		@GetMapping(value = "/allBooks")
		public List<BookEntity> getAllBookDetails(){
			 return myBookService.getAllBooks();
		}
		
		//get book by id
		@GetMapping(value = "/byId/{id}")
		public BookEntity getBookDetails(@PathVariable Integer id){
			return myBookService.getBookById(id);
		}
			
	 	//get all books by author
		@GetMapping(value = "/byAuthor/{name}")
		public List<BookEntity> getBookByAuthor(@PathVariable String name){
			return myBookService.getBookByAuthor(name);
		}
		
		//get all books by rating
		@RequestMapping(method = RequestMethod.GET, value = "/byRating/{rating}")
		public List<BookEntity> getBookByRatings(@PathVariable Integer rating){		
			return myBookService.getBookByRatings(rating);
		}
		
		//get top rating books
		@RequestMapping(method = RequestMethod.GET, value = "/byTopRating")
		public List<BookEntity> getBookByTopRatings(){		
			return myBookService.getBookByTopRatings();
		}
		
				
		//get all books by name
		@RequestMapping(method = RequestMethod.GET, value = "/byName/{name}")
		public List<BookEntity> getBookByName(@PathVariable String name){
			return myBookService.getBookByName(name);
		}		
		
		//get all books by name
		@RequestMapping(method = RequestMethod.GET, value = "/byPublisher/{name}")
		public List<BookEntity> getBooksByPublisher(@PathVariable String name){
			return myBookService.getBookByPublisher(name);
		}		
		
		//getBookByByTwoPrices
		@RequestMapping(method = RequestMethod.GET, value = "/byPrices/first = {first}/last = {last}")
		public List<BookEntity> getBookByByTwoPrices(@PathVariable Integer first, @PathVariable Integer last){
			return myBookService.getBookByByTwoPrices(first, last);
		}
		
		//getActiveBooks
		@RequestMapping(method = RequestMethod.GET, value = "/activeBooks/{active}")
		public List<BookEntity> getActiveBooks(@PathVariable Integer active){
			return myBookService.getActiveBooks(active);
		}
		
		//make active/inactive
		@RequestMapping(method = RequestMethod.POST, value = "/makeActive/{id}/{active}")
		public void makeBookActive(@PathVariable Integer id, @PathVariable Integer active){
			  myBookService.makeActive(id,active);
		}
		
		//delete all books
			@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAll")
			public void deleteAllBooks(){
				  myBookService.deleteAllBooks();
		}

		//delete By id
		@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
		public void deleteById(@PathVariable Integer id){
			  myBookService.deleteById(id);
		}
		
		//book Count
		@RequestMapping(method = RequestMethod.DELETE, value = "/count")
		public Long bookCount(){
			 return myBookService.booksCount();
		}
}	
