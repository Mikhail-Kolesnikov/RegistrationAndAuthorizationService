package Service;

import Repository.UserRepository;

public class AuthorizationImpl implements Authorization {

    private UserRepository repository;
    private String login;
    private String password;

    public AuthorizationImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean perform(String... parameters) {

        return repository.getUser(login).getPassword().verify(password);

    }
}

