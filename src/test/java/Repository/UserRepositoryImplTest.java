package Repository;

import Entity.Password;
import Entity.User;
import Exceptions.UserAlreadyExistsException;
import Exceptions.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class UserRepositoryImplTest {

    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() throws IOException {
        File file = new File("test_users.txt");
        if (file.exists()) {
            file.delete();
        }

        userRepository = new UserRepositoryImpl();
    }

    @Test
    void testAddAndRetrieveUser() throws UserAlreadyExistsException, UserNotFoundException {
        User user = new User("john_doe", "John Doe", "john@example.com", new Password("passwordHash"));
        userRepository.addToRepository(user, "");

        User retrievedUser = userRepository.getUser("john_doe");
        Assertions.assertEquals(user, retrievedUser);
    }

    @Test
    void testSaveUser() {
        File file = new File("test_users.txt");
        userRepository = new UserRepositoryImpl(file);
        User user = new User("john_doe", "John Doe", "john@example.com", new Password("passwordHash"));
        boolean saved = userRepository.save();

        Assertions.assertTrue(saved);
    }

    @Test
    void testGetUserByLoginAndEmail() throws UserNotFoundException, UserAlreadyExistsException{
        User user = new User("john_doe", "John Doe", "john@example.com", new Password("passwordHash"));
        userRepository.addToRepository(user,"");

        User retrievedUser = userRepository.getUser("john_doe", "john@example.com");
        Assertions.assertEquals(user, retrievedUser);
    }

    @Test
    void testGetUserByLoginAndEmail_NotFound() {
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userRepository.getUser("non_existent_user", "non_existent@example.com");
        });
    }
}
