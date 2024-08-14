package Controller;

import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Service.*;

import java.util.Scanner;

public class UserController {

    public Scanner scanner;

    private UserRepositoryImpl repository;

    private int loginAttempts;

    public UserController(UserRepository repository) {
        this.repository = (UserRepositoryImpl) repository;
    }


    public void startProgram() {
        while (true) {
            String commandLine = scanner.nextLine();
            Command command = Command.valueOf(commandLine);

            switch (command) {
                case REGISTER_USER -> registerUser();
                case AUTHORIZE_USER -> authorizeUser();
                case RESET_PASSWORD -> resetPassword();
            }
        }
    }




    private void registerUser() {
String login = "";
String userName = "";
String email = "";
String password1 = "";
String password2 = "";
// ask user
// verify password1 == password2 in while


        Service service = new RegistrationImpl();
        boolean result = service.perform(repository, new String[]{login, userName, email, password1});
        if (result) {
            System.out.println("Registration is successful.");

        } else {
            System.out.println("Registration failed.");

        }
    }


    private void authorizeUser() {
        String login = "";
        String password = "";

//вопросы поьзователю про логин , пассворд

        Service service = new AuthorizationImpl();
        boolean result = service.perform(repository, new String[]{login, "", "", password});
        if (result) {
            System.out.println("Login is successful.");
            loginAttempts = 0;
        } else {
            System.out.println("Login failed.");
            loginAttempts++;
        }
    }


    private void resetPassword() {


    }

}
