package Controller;

import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Service.*;

import java.util.HashMap;
import java.util.Scanner;

public class UserController {

    public Scanner scanner = new Scanner(System.in);
    private UserRepositoryImpl repository;
    private int loginAttempts;

    public UserController(UserRepository repository) {
        this.repository = (UserRepositoryImpl) repository;
    }

    HashMap<String, Service> services = new HashMap<>();
    public void registerService(String string, Service service){
        services.put(string, service);
    }



    public void startProgram() {
        //здрасьте,
        while (true) {
           // выбор опреции,


            // енам как меню
            for (int i = 1; i <= Command.values().length; i++) {
                System.out.println( i  +  ". " + Command.values()[i - 1].toString());
            }

            int commandLine = scanner.nextInt();
            Command c =  Command.values()[commandLine - 1];
           services.get(c.name()).askUser();
           services.get(c.name()).perform(repository);


        }
    }


    private void registerUser() {
String login = "";
String userName = "";
String email = "";
String password1 = "";
String password2 = "+";
// ask user


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
