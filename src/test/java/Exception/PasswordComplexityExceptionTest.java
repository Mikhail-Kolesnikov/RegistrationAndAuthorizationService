package Exception;
import Entity.Password;
import Exceptions.PasswordComplexityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PasswordComplexityExceptionTest {

    @Test
        public void tooShortPassword_fail_test() {
            Password password = new Password();
            Assertions.assertThrows(PasswordComplexityException.class, () -> {
                password.setPassword("qwe1");
            });

        }

        @Test
        public void password_withoutDigit_test() {
            Password password = new Password();
            Assertions.assertThrows(PasswordComplexityException.class, () -> {
                password.setPassword("qwertyyy");
            });
        }


        @Test
        public void correctPassword_success() {
            Password password = new Password();
            Assertions.assertDoesNotThrow(() -> {
                password.setPassword("qwert12");
            });
        }
    }

