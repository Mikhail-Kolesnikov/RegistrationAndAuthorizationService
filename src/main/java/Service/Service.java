package Service;

import Repository.UserRepository;

public interface Service {
    String login = "";
    String userName = "";
    String email = "";
    String password = "";


    boolean perform(UserRepository repository, String... parameters);
    void askUser();
}

