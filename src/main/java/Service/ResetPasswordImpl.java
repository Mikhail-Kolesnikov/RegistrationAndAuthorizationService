package Service;

import Repository.UserRepository;

public class ResetPasswordImpl implements ResetPassword{

    private UserRepository repository;

    public ResetPasswordImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean perform( String... parameters) {
        return false;
    }

}
