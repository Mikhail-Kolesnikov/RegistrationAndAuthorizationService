package Controller;

import Entity.Password;
import Entity.User;
import Exceptions.UserNotFoundException;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Service.*;

import java.util.HashMap;
import java.util.Scanner;

import static Service.Service.*;

public class UserController {

    public Scanner scanner = new Scanner(System.in);
    private UserRepositoryImpl repository;
    private RegistrationImpl service1;
    private AuthorizationImpl service2;
    private ResetPasswordImpl service3;
    private ExitImpl service4;

    private int loginAttempts;

    public UserController(UserRepository repository) {
        this.repository = (UserRepositoryImpl) repository;
        this.service1 = new RegistrationImpl(this.repository);
        this.service2 = new AuthorizationImpl(this.repository);
        this.service3 = new ResetPasswordImpl(this.repository);
        this.service4 = new ExitImpl(this.repository);
    }



    public void startProgram() {
        System.out.println("You are welcome to the program! ");

        while (true) {
            System.out.println("Choose your operation from the following list: ");
            for (int i = 1; i <= Command.values().length; i++) {
                System.out.println(i + ". " + Command.values()[i - 1].toString());
            }

            int commandLine = scanner.nextInt();
            Command c = Command.values()[commandLine - 1];
            switch (c) {
                case REGISTER_USER -> registerUser();
                case AUTHORIZE_USER -> authorizeUser();
                case RESET_PASSWORD -> resetPassword();
                case EXIT -> exit();

            }
        }
    }


    private void registerUser() {
        String password1 = "";
        String password2 = "+";
        String login = "";
        String userName = "";
        String email = "";

        scanner = new Scanner(System.in);
        System.out.print("Enter your login: ");
        login = scanner.nextLine();
        System.out.print("Enter  your name:");
        userName = scanner.nextLine();
        System.out.print("Enter your email: ");
        email = scanner.nextLine();

        while (!password1.equals(password2)) {
            System.out.print("Enter your password: ");
            password1 = scanner.nextLine();
            System.out.print("Repeat your password: ");
            password2 = scanner.nextLine();
            if (!password1.equals(password2)) {
                System.out.println("\nYour passwords don't match.");
            }
        }

        boolean isOk = service1.perform(new String[]{login, userName, email, password1, ""});
        if (isOk) {
            System.out.println("Registration is successful.");
        } else {
            System.out.println("Registration failed.");
        }
    }


    private void authorizeUser() {
        while (loginAttempts < 6) {

            String password = "";
            String login = "";

            System.out.print("Enter your login: ");
            login = scanner.nextLine();
            System.out.print("Enter  your password: ");
            password = scanner.nextLine();

            boolean result = service2.perform(new String[]{login, "", "", password});
            if (result) {
                System.out.println("Login is successful.");
                loginAttempts = 0;
                return;
            } else {
                System.out.println("Login failed.");
                loginAttempts++;
            }
        }
    }

    public void resetPassword() {
        String password1 = "";
        String password2 = "+";
        String login = "";
        String userName = "";
        String email = "";

        System.out.print("Enter your login: ");
        login = scanner.nextLine();
        System.out.print("Enter your email: ");
        email = scanner.nextLine();

        try {
            User user =  repository.getUser(login, email);
            userName = user.getUserName();

            while (!password1.equals(password2)) {
                System.out.print("Enter your password: ");
                password1 = scanner.nextLine();
                System.out.print("Repeat your password: ");
                password2 = scanner.nextLine();

                if (!password1.equals(password2)) {
                    System.out.println("Your passwords don't match.");
                }
            }
        }

       catch ( UserNotFoundException e){
           System.out.println(e.getMessage());
       }

        boolean isOk = service1.perform(new String[]{login,userName, email, password1, "x"});
        if (isOk) {
            System.out.println("Password is reset successfully.");
        } else {
            System.out.println("Password reset failed.");
        }


    }



    public void exit() {
        ExitImpl e = new ExitImpl(repository);
        e.perform();
    }

}

