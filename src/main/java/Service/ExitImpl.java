package Service;

import Repository.UserRepository;

public class ExitImpl implements Exit {

    @Override
    public boolean perform(UserRepository repository, String... parameters) {
        System.exit(0);
        return false;
    }

    @Override
    public void askUser() {}
}
