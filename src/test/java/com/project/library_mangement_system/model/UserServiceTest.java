package com.project.library_mangement_system.model;

import com.project.library_mangement_system.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;
    private User user;
    private List<User> userList;

    @Before
    public void setUp()  {
        this.userService=new UserService(this.userRepository);
        user=new User("Owner","Shaukey","Shaukey","admin");
        user=userService.addNew(user);
    }

    @Test
    public void testGetAllUsers() {
        userList=userService.getAllUsers();
        verify(userRepository).findAllByOrderByDisplayNameAsc();
        assertNotNull(userList);
    }

    @Test
    public void testGetAllActiveUsers() {
        userList=userService.getAllActiveUsers();
        verify(userRepository).findAllByActiveOrderByDisplayNameAsc(1);
        assertNotNull(userList);
    }

    @Test
    public void testGetByUsername() {
        User user=userService.getByUsername("Sin");
        verify(userRepository).findByUsername("Sin");
        assertNull(user);
    }

    @Test
    public void testAddNew() {
        User user=new User("Tokyo","Tok","din314","admin");
        userService.addNew(user);
        verify(userRepository).save(user);
        assertNotNull(user);
    }

    @Test
    public void testUpdate() {
        User user=new User("Berlin","Ber","Sul14","librarian");
        userService.update(user);
        verify(userRepository).save(user);
        assertNotNull(user);
    }

    @Test
    public void testDelete() {
        userService.delete(user);
        verify(userRepository).delete(user);
        assertNull(user);
    }

    @Test
    public void testTestDelete() {
        userService.delete(1L);
        verify(userRepository).deleteById(1L);
        assertNull(user);
    }
}