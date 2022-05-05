package com.project.library_mangement_system.repository;

import com.project.library_mangement_system.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findAllByOrderByNameAsc();
}
