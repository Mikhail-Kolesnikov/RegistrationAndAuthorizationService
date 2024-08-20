package Service;

import Entity.Password;
import Entity.User;
import Exceptions.PasswordComplexityException;
import Exceptions.UserAlreadyExistsException;
import Repository.UserRepository;

import java.util.Scanner;

public class RegistrationImpl  implements Registration{

    Scanner scanner = new Scanner(System.in);
    private UserRepository repository;
    private String login;
    private String userName;
    private String email;

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

            try {
                repository.addToRepository(user, parameters[4]);
            }
           catch (UserAlreadyExistsException e){
               System.out.println(e.getMessage());
                return false;
           }
        }
        catch (PasswordComplexityException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
