package com.shreyansh.bookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyBookService {
	
	@Autowired 
	private BookRepository bookRepository;
	
	//Add new book
		public void addNewBook(BookEntity bookEntity) {
			bookRepository.save(bookEntity);
		}
		
	//Add new book
		public void addBookList(List<BookEntity> bookEntity) {
			bookRepository.saveAll(bookEntity);
		}
	
	//make book active/inactive
	public void makeActive(Integer id, Integer active) {
			bookRepository.makeActive(id, active);
	}	
			
		//delete new book
		public void deleteBook(BookEntity bookEntity) {
			bookRepository.delete(bookEntity);
		}
		
		//update book
		public void updateBook(BookEntity bookEntity) {
			Integer id = bookEntity.getId();
			Optional<BookEntity> result = bookRepository.findById(id);
			if(result.isPresent())
				bookRepository.save(bookEntity);
			else throw new RuntimeException("Did not find Book for the id :" +id);  
		}
		
		//get book with id
		public BookEntity getBookById(Integer id) {
			BookEntity bookEntity = null;
			if(bookRepository.existsById(id)) {
				Optional<BookEntity> result = bookRepository.findById(id);
				bookEntity = result.get();
			}
			else throw new RuntimeException("Did not find Person for the id :" +id);  
			return bookEntity;
		}
		
		//get book list
		public List<BookEntity> getAllBooks() {
			List<BookEntity> bookList = new ArrayList<BookEntity>();
			for(BookEntity p : bookRepository.findAll()) {
				bookList.add(p);
			}
			return bookList;
		}

		//get book by name
		public List<BookEntity> getBookByName(String name) {
			return bookRepository.findAllByNameContaining(name, PageRequest.of(0, 4));
		}
	
		//get book by author
		public List<BookEntity> getBookByAuthor(String author) {
			return bookRepository.findByAuthorContaining(author);
		}
		

		// get book by ratings 
		public List<BookEntity> getBookByRatings(Integer ratings) {
			return bookRepository.findByRating(ratings);
		}
		
		//get book by categories
		public List<BookEntity> getBookByCategory(String category) {
			return bookRepository.findByCategory(category);
		}
		
		//get book by Publisher
		public List<BookEntity> getBookByPublisher(String publisher) {
			return bookRepository.findByPublisher(publisher);
		}
		
		//get book by Publisher
		public List<BookEntity> getBookByTopRatings() {
			return bookRepository.findByRatingGreaterThanEqual(3);
		}
		
		//get book by Publisher
		public List<BookEntity> getBookByByTwoPrices(Integer first, Integer second) {
			return bookRepository.findByPriceBetween(first,second);
		}
		
		//All Active/Inactive Books
		public List<BookEntity> getActiveBooks(Integer active) {
			return bookRepository.findByActive(active);
		}
		
	//Delete all books
		public void deleteAllBooks() {
			 bookRepository.deleteAll();
		}
		
	//Delete all books
		public void deleteById(Integer id) {
			 bookRepository.deleteById(id);
		}	
		
	//total number of books available
		public Long booksCount() {
			return bookRepository.count();
		}
}
