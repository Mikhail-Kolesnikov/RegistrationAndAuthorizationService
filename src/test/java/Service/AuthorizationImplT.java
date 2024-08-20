package Entity;

import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Service.AuthorizationImpl;
import Service.RegistrationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationImplT {
    private UserRepositoryImpl userRepository;
    @BeforeEach
    public void beforeTest() {
        File file = new File("test_users.txt");
        User user = new User("testPassword");
       userRepository = new UserRepository(file);

}
    @Test
    public void testPerform() {
        AuthorizationImpl authorization = new AuthorizationImpl(userRepository);

        // Вызываем тестируемый метод с корректными параметрами
        boolean result = authorization.perform(userRepository, "testUser", "testPassword");

        // Проверяем, что метод вернул true
        assertTrue(result);

        // Вызываем тестируемый метод с некорректным паролем
        result = authorization.perform(userRepository, "testUser", "wrongPassword");

        // Проверяем, что метод вернул false
        assertFalse(result);
    }
}

@Test
public void testPerform_InvalidPassword_ShouldReturnFalse() {
    // Arrange

    RegistrationImpl registration = new RegistrationImpl(userRepository);

    // Задаем значения полей для регистрации
    registration.login = "testUser";
    registration.userName = "Test User";
    registration.email = "test@example.com";
    registration.password = "123"; // Некорректный пароль

    // Act
    boolean result = registration.perform(userRepository);

    // Assert
    assertFalse(result);
    assertNull(userRepository.getUser("testUser")); // Пользователь не должен быть добавлен
}
