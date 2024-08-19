package Main;

import Controller.UserController;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File( "Users.txt");
        UserRepository repository = new UserRepositoryImpl(file);
        UserController userController = new UserController(repository);
        userController.startProgram();
        
    }
}
