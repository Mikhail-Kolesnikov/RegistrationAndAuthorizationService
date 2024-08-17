package Service;

import Entity.User;
import Exceptions.UserNotFoundException;
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
        try {
            User user = repository.getUser(parameters[0]);
          return user.getPassword().verify(parameters[3]);
        }
   catch (UserNotFoundException e){
       System.out.println(e.getMessage());
       return false;
   }
    }
}

