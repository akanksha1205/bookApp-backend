package com.digital.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digital.user.entity.BookEntity;


@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer>{
	
	@Query(value = "SELECT * FROM digital_book.book_table b where b.category = :category or b.title = :title or b.author = :author or b.price = :price or b.publisher = :publisher", nativeQuery = true)
	List<BookEntity> searchAllBooks(@Param("category") String category, @Param("title") String title, @Param("author") String author, @Param("price") String price, @Param("publisher") String publisher);

	@Modifying
	@Query(value = "Update digital_book.book_table b set b.title=:title, b.author=:author, b.publisher=:publisher, b.released_date=:releasedDate, b.category=:category, b.price=:price, b.active=:active,b.content=:content where b.book_id=:bookID", nativeQuery = true)
	void editBook(@Param("bookID") Integer bookId, @Param("category") String category,@Param("title") String title, @Param("author") String author, @Param("price") String price, @Param("publisher") String publisher, @Param("releasedDate") String releasedDate, @Param("active") String active, @Param("content") String content);
}
