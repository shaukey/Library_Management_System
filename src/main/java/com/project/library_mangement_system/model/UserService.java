package com.project.library_mangement_system.model;

import com.project.library_mangement_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAllByOrderByDisplayNameAsc();
    }

    public List<User> getAllActiveUsers() {
        return userRepository.findAllByActiveOrderByDisplayNameAsc(1);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public User addNew(User user) {
        user.setPassword( passwordEncoder.encode(user.getPassword()) ); //Comment
        user.setCreatedDate( new Date() ); //Comment
        user.setLastModifiedDate( user.getCreatedDate() ); //Comment
        user.setActive(1); //Comment
        return userRepository.save(user);
    }

    public User update(User user) {
        user.setLastModifiedDate( new Date() );
        return userRepository.save( user );
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
