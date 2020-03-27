package com.shreyansh.bookStore;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<BookEntity, Integer> {
	public List<BookEntity> findAllByNameContaining(String name, Pageable pageable);
	public List<BookEntity> findByAuthorContaining(String author);
	public List<BookEntity> findByRating(Integer rating);
	public List<BookEntity> findByCategory(String category);
	public List<BookEntity> findByPublisher(String publisher);
	public List<BookEntity> findByRatingGreaterThanEqual(Integer rating);
	public List<BookEntity> findByPriceBetween(Integer firstPrice, Integer lastPrice);
	public List<BookEntity> findByActive(Integer active);
	
	@Modifying
	@Query("update BookEntity b set b.active= :active where b.id= :id")
	public void makeActive(Integer id, Integer active);	
}
	
