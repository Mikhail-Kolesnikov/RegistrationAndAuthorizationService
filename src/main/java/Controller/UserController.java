package Controller;

import Entity.Password;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Service.*;

import java.util.HashMap;
import java.util.Scanner;

import static Service.Service.*;

public class UserController {

    public Scanner scanner = new Scanner(System.in);

    private UserRepositoryImpl repository;
    private int loginAttempts;

    public UserController(UserRepository repository) {
        this.repository = (UserRepositoryImpl) repository;
    }


    public void startProgram() {
        //здрасьте,

        while (true) {

            // выбор опреции,
            System.out.println();

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
        String password = "";
        String login = "";
        String userName = "";
        String email = "";

        System.out.println("Enter your login: ");
        login = scanner.nextLine();
        System.out.println("Enter  your name:");
        userName = scanner.nextLine();
        System.out.println("Enter your email: ");
        email = scanner.nextLine();

        while (!password1.equals(password2)) {
            System.out.println("Enter your password: ");
            password1 = scanner.nextLine();

            System.out.println("Repeat your password: ");
            password2 = scanner.nextLine();
            if (!password1.equals(password2)) {
                System.out.println("Your passwords don't match.");
            }
            password = password1;
        }


        RegistrationImpl service = new RegistrationImpl();


        boolean isOk = service.perform(this.repository, new String[]{login, userName, email, password1});
        if (isOk) {

            System.out.println("Registration is successful.");

        } else {
            System.out.println("Registration failed.");
        }
    }


    private void authorizeUser() {

//вопросы поьзователю про логин , пассворд

        AuthorizationImpl service = new AuthorizationImpl();

        boolean result = service.perform(this.repository, new String[]{login, "", "", password});
        if (result) {
            System.out.println("Login is successful.");
            loginAttempts = 0;
        } else {
            System.out.println("Login failed.");
            loginAttempts++;
        }
    }


    public void resetPassword() {
        ResetPasswordImpl r = new ResetPasswordImpl();
        r.askUser();
        r.perform(repository);

    }



    public void exit() {
        ExitImpl e = new ExitImpl();
        e.askUser();
        e.perform(repository);
    }

}

