package Service;

import Entity.Password;
import Entity.User;
import Exceptions.PasswordComplexityException;
import Exceptions.UserAlreadyExistsException;
import Repository.UserRepository;

import java.util.Scanner;

public class RegistrationImpl  implements Registration{

    public String password;
    Scanner scanner = new Scanner(System.in);
    private UserRepository repository;
    public String login;
    public String userName;
    public String email;

    public RegistrationImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean perform(String ...parameters) {
        try{
            login = parameters[0];
            userName = parameters[1];
            email = parameters[2];

            Password password = new Password();
            password.setPassword(parameters[3]);
            User user = new User(login, userName, email, password);
            repository.addToRepository(user, parameters[4]);

        }
        catch (PasswordComplexityException e){
            e.printStackTrace();
            return false;
        }
           catch (UserAlreadyExistsException e){
               System.out.println(e.getMessage());
                return false;
           }

        return true;
    }

}
