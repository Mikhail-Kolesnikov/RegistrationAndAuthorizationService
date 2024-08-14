package Entity;

import java.util.HashMap;

public class Password {
    private String passwordHash;
//    private String encryption;
    private Encryption encryption;

    public Password(String passwordHash, Encryption encryption) {
        this.passwordHash = encryption.encrypt(passwordHash);
        this.encryption = encryption;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Encryption getEncryption() {
        return encryption;
    }
}



    //    public Password() {
//    }
//
//    public void setPassword() {
//
//    }
}
