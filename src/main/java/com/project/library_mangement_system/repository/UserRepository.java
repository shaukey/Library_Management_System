package com.project.library_mangement_system.repository;

import com.project.library_mangement_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByOrderByDisplayNameAsc();
    public List<User> findAllByActiveOrderByDisplayNameAsc(Integer active);
    public User findByUsername(String username);
}
