package Service;

import Repository.UserRepository;

public class ExitImpl implements Exit {

private UserRepository repository;

    public ExitImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean perform(String... parameters) {
        repository.save();
        System.exit(0);
        return false;
    }
}
