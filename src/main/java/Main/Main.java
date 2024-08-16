package Main;

import Controller.Command;
import Controller.UserController;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Service.AuthorizationImpl;
import Service.ExitImpl;
import Service.RegistrationImpl;
import Service.ResetPasswordImpl;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File( "Users.txt");
        UserRepository repository = new UserRepositoryImpl(file);
        UserController userController = new UserController(repository);
        userController.startProgram();



    }
}
