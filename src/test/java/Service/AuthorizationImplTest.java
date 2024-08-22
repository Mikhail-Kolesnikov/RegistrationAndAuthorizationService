package Service;

import Entity.Password;
import Entity.User;
import Exceptions.PasswordComplexityException;
import Exceptions.UserAlreadyExistsException;
import Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class AuthorizationImplTest {

    private UserRepositoryImpl userRepository;
    private AuthorizationImpl authorization;

    @BeforeEach
    void setUp() throws  PasswordComplexityException, UserAlreadyExistsException {
        File file = new File("test_users.txt");
        if (file.exists()) {
            file.delete();
        }

        userRepository = new UserRepositoryImpl();
        authorization = new AuthorizationImpl(userRepository);

        // Register a user for testing authorization
        Password password = new Password();
        password.setPassword("Password123!");
        User user = new User("john_doe", "John Doe", "john@example.com", password);
        userRepository.addToRepository(user,"");
    }

    @Test
    void testSuccessfulLogin() {
        boolean isLoggedIn = authorization.perform( "john_doe", "", "", "Password123!");
        Assertions.assertTrue(isLoggedIn);
    }

    @Test
    void testFailedLoginWithWrongPassword() {
        boolean isLoggedIn = authorization.perform( "john_doe", "", "", "WrongPassword");
        Assertions.assertFalse(isLoggedIn);
    }

    @Test
    void testFailedLoginWithNonExistentUser() {
        boolean isLoggedIn = authorization.perform(String.valueOf(userRepository), "non_existent_user", "", "", "Password123!");
        Assertions.assertFalse(isLoggedIn);
    }
}