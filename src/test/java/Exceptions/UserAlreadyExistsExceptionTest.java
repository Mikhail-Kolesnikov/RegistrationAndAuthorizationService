package Exceptions;

import Entity.Password;
import Entity.User;
import Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAlreadyExistsExceptionTest {

@Test
    public void testUserAlreadyExists_success(){
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    User user = new User("Qwert", "Qwert", "qwert123@com",
            new Password("asdf123"));

    Assertions.assertDoesNotThrow(() -> {userRepository.addToRepository(user, "");});

    Assertions.assertThrows(UserAlreadyExistsException.class, () ->
    {userRepository.addToRepository(user, "") ;});
}


}