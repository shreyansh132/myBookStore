package com.shreyansh.bookStore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicUpdate
@Table(name = "new_books")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false)	
	private String name;
	
	@Column(name = "author", length = 60, nullable = false)	
	private String author;
	
	@Column(name = "description", columnDefinition = "varchar(1000) default 'No Description available'")	
	private String description;
	
	@Column(name = "price", nullable = false)	
	private Integer price;

	@Column(name = "rating", nullable = false)	
	private Integer rating;
	
	@Column(name = "category", nullable = false , length = 120)	
	private String category;
	
	@Column(name = "publication_date", nullable = false)	
	private String publicationDate;
	
	@Column(name = "publisher", nullable = false)	
	private String publisher;
	
	@Column(name = "active", nullable = false)	
	private Integer active;
	
	public BookEntity() {}
	
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", rating=" + rating + ", category=" + category + ", publicationDate="
				+ publicationDate + ", publisher=" + publisher + ", active=" + active + "]";
	}
	
	public BookEntity(Integer id, String name, String author, String description, Integer price, Integer rating,
			String category, String publicationDate, String publisher, Integer active) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.category = category;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
		this.active = active;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
