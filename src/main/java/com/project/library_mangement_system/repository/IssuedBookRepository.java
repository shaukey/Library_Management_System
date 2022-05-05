package com.project.library_mangement_system.repository;

import com.project.library_mangement_system.model.Book;
import com.project.library_mangement_system.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {
    public Long countByBookAndReturned(Book book, Integer returned);
}
