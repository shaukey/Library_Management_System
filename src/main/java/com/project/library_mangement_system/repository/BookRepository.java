package com.project.library_mangement_system.repository;

import com.project.library_mangement_system.model.Book;
import com.project.library_mangement_system.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    public Book findByTag(String tag);
    public List<Book> findByCategory(Category category);
    public List<Book> findByCategoryAndStatus(Category category, Integer status);
    public Long countByStatus(Integer status);
}
