package Service;

import Repository.UserRepository;

public class ExitImpl implements Exit {

private UserRepository repository;

    public ExitImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean perform(String... parameters) {
        boolean b =  repository.save();
        if(!b){
            System.out.println("Failed to save the repository.");
        }
        System.exit(0);
        return false;
    }
}
