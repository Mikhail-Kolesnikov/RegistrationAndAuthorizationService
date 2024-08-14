package Service;

import Repository.UserRepository;

public class ResetPasswordImpl implements ResetPassword{
    @Override
    public boolean perform(UserRepository repository, String... parameters) {
        return false;
    }
}
