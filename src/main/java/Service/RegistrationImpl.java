package Service;

import Entity.Password;
import Entity.User;
import Exceptions.PasswordComplexityException;
import Repository.UserRepository;

import java.util.Scanner;

public class RegistrationImpl  implements Registration{

    Scanner scanner = new Scanner(System.in);

    String login = "";
    String userName = "";
    String email = "";
    String password = "";


    @Override
    public boolean perform(UserRepository repository, String ...parameters) {
        try{
            Password password = new Password();
            password.setPassword(this.password);
            User user = new User(login, userName, email, password);
            repository.addToRepository(user);
        }
        catch (PasswordComplexityException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public void askUser() {

    }
}
