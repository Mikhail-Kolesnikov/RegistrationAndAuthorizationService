package Service;

import Entity.User;
import Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class RegistrationImplTest {

    private UserRepositoryImpl userRepository;
    private RegistrationImpl registration;

    @BeforeEach
    void setUp() throws IOException {
        File file = new File("test_users.txt");
        if (file.exists()) {
            file.delete();
        }
        userRepository = new UserRepositoryImpl(file);
        registration = new RegistrationImpl();
    }

    @Test
    void testSuccessfulRegistration() {
        boolean isRegistered = registration.perform(userRepository, "john_doe", "John Doe", "john@example.com", "Password123!");
        Assertions.assertTrue(isRegistered);

        User user = userRepository.getUser("john_doe");
        Assertions.assertNotNull(user);
        Assertions.assertTrue(user.getPassword().verify("Password123!"));
    }

    @Test
    void testRegistrationWithWeakPassword() {
        boolean isRegistered = registration.perform(userRepository, "jane_doe", "Jane Doe", "jane@example.com", "weak");
        Assertions.assertFalse(isRegistered);
    }
}