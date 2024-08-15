package Service;

import Repository.UserRepository;

public class AuthorizationImpl implements Authorization {

   private String login;
   private String password;

    @Override
    public boolean perform(UserRepository repository, String...parameters) {
    //login = parameters[0];
   // password = parameters[3];

    return repository.getUser(login).getPassword().verify(password);

    }

    @Override
    public void askUser() {

    }


}
