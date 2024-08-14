package Entity;


public class Password {
    private String passwordHash;
    private Encryption encryption;

    public Password(String passwordHash) {
        this.passwordHash = passwordHash;
        this.encryption = Encryption.SHA1;
    }


    public Password(String passwordHash, Encryption encryption) {
        this.passwordHash = passwordHash;
        this.encryption = encryption;
    }

    public Encryption getEncryption() {
        return encryption;
    }


    public void setPassword( String password) {
// тут должны быть проверки на соответствие пороля( не менее 6 символов и минимумм одна цифра)
// exception  invalidPasswordCriteria

        this.passwordHash = encryption.encrypt(password);
    }

    public  boolean verify(String password){
        String tempHash = encryption.encrypt(password);
        return this.passwordHash.equals(tempHash);
    }



}
