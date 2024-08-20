package Service;

import Entity.Password;
import Entity.User;
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
    void setUp() throws IOException {
        File file = new File("test_users.txt");
        if (file.exists()) {
            file.delete();
        }
        System.out.println();
        userRepository = new UserRepositoryImpl(file);
        authorization = new AuthorizationImpl();

        // Register a user for testing authorization
        User user = new User("john_doe", "John Doe", "john@example.com", new Password("Password123!"));
        userRepository.addToRepository(user);
    }

    @Test
    void testSuccessfulLogin() {
        boolean isLoggedIn = authorization.perform(userRepository, "john_doe", "", "", "Password123!");
        Assertions.assertTrue(isLoggedIn);
    }

    @Test
    void testFailedLoginWithWrongPassword() {
        boolean isLoggedIn = authorization.perform(userRepository, "john_doe", "", "", "WrongPassword");
        Assertions.assertFalse(isLoggedIn);
    }

    @Test
    void testFailedLoginWithNonExistentUser() {
        boolean isLoggedIn = authorization.perform(userRepository, "non_existent_user", "", "", "Password123!");
        Assertions.assertFalse(isLoggedIn);
    }
}