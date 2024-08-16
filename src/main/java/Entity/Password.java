package Entity;


import Exceptions.PasswordComplexityException;

public class Password {
    private String passwordHash;
    private Encryption encryption;

    public Password(){
        this.encryption = Encryption.SHA1;
    };

    public Password(String passwordHash) {
        this.passwordHash = passwordHash;
        this.encryption = Encryption.SHA1;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Password(String passwordHash, Encryption encryption) {
        this.passwordHash = passwordHash;
        this.encryption = encryption;
    }

    public Encryption getEncryption() {
        return encryption;
    }

    public boolean hasDigit(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }


    public void setPassword(String password) throws PasswordComplexityException {
//проверки на соответствие пороля( не менее 6 символов и минимумм одна цифра)

        if (password.length() < 6) {
            throw new PasswordComplexityException("The password length is less than 6 symbols.");
        }
        if (!this.hasDigit(password)) {
            throw new PasswordComplexityException("The password requires at least one digit.");
        }

        this.passwordHash = encryption.encrypt(password);
    }


    public boolean verify(String password) {
        String tempHash = encryption.encrypt(password);
        return this.passwordHash.equals(tempHash);
    }

}
