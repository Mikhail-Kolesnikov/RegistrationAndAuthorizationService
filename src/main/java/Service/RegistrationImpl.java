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
        String password1 = "";
        String password2 = "+";

        System.out.println("Enter your login: ");
        login = scanner.nextLine();
        System.out.println("Enter  your name:");
        userName = scanner.nextLine();
        System.out.println("Enter your email: ");
        email = scanner.nextLine();

        while(!password1.equals(password2)){
            System.out.println("Enter your password: ");
            password1 = scanner.nextLine();

            System.out.println("Repeat your password: ");
            password2 = scanner.nextLine();
            if(!password1.equals(password2)){
                System.out.println("Your passwords don't match.");
            }
            password = password1;
        }
    }
}
