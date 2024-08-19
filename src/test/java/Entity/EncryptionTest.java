package Entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptionTest {

 private Encryption encryption;

    @Test
    public void encryption_success(){

        String password = "qwert1234";
        String result = Encryption.SHA1.encrypt(password);

        assertEquals("0da6e416969ca5e6b3e67e33c561ef703aa78029",result);
    }

}