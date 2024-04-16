package org.task24.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.task24.entity.User;
import org.task24.entity.UserDTO;
import org.task24.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EntryServiceTest
{
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder encoder;
    @InjectMocks
    private EntryService entryService;

    @Test
    void testAddUser_Successful()
    {
        UserDTO newUser = new UserDTO();
        newUser.setName("testUser");
        newUser.setPassword("password");
        newUser.setConfirmPassword("password");
        when(userRepository.existsByName(newUser.getName())).thenReturn(false);
        when(encoder.encode(newUser.getPassword())).thenReturn("encodedPassword");

        boolean result = entryService.addUser(newUser);

        assertTrue(result);
        verify(userRepository, times(1)).existsByName(newUser.getName());
        verify(encoder, times(1)).encode(newUser.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testAddUser_UserAlreadyExists()
    {
        UserDTO existingUser = new UserDTO();
        existingUser.setName("testUser");
        existingUser.setPassword("password");
        existingUser.setConfirmPassword("password");
        when(userRepository.existsByName(existingUser.getName())).thenReturn(true);

        boolean result = entryService.addUser(existingUser);

        assertFalse(result);
        verify(userRepository, times(1)).existsByName(existingUser.getName());
        verify(encoder, never()).encode(anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testFindUserByName_UserExists()
    {
        String username = "existingUser";
        User user = new User();
        when(userRepository.findUserByName(username)).thenReturn(Optional.of(user));

        Optional<User> result = entryService.findUserByName(username);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
        verify(userRepository, times(1)).findUserByName(username);
    }

    @Test
    void testFindUserByName_UserDoesNotExist()
    {
        String username = "nonExistingUser";
        when(userRepository.findUserByName(username)).thenReturn(Optional.empty());

        Optional<User> result = entryService.findUserByName(username);

        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findUserByName(username);
    }
}