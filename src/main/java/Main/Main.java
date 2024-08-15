package Main;

import Controller.Command;
import Controller.UserController;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Service.AuthorizationImpl;
import Service.ExitImpl;
import Service.RegistrationImpl;
import Service.ResetPasswordImpl;

public class Main {
    public static void main(String[] args) {

        UserRepository repository = new UserRepositoryImpl();
        UserController userController = new UserController(repository);
        userController.startProgram();


    }
}
