package Service;

import Entity.User;
import Repository.PasswordRepository;

public class AuthorisationImpl implements Authorisation{
    private final PasswordRepository repository;

    public AuthorisationImpl(PasswordRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean login(String login, String password) {
        User user = repository.findByLogin(login);
        if(user != null){
            String encryptedPassword= user.getPassword().getEncryption().encrypt(password);
            return user.getPassword().getPasswordHash().equals(encryptedPassword);

        }
        return false;


    }
}
