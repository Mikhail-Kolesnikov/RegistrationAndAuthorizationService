package Service;

import Entity.Password;
import Entity.User;
import Exceptions.PasswordComplexityException;
import Repository.UserRepository;

public class RegistrationImpl  implements Registration{

    @Override
    public boolean perform(UserRepository repository, String ...parameters) {
        try{
            Password password = new Password();
            password.setPassword(parameters[3]);
            User user = new User(parameters[0],parameters[1],parameters[2],password);
            repository.addToRepository(user);
        }
        catch (PasswordComplexityException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
