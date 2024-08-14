package Main;

import Controller.UserController;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepositoryImpl();
        UserController userController = new UserController(repository);
userController.startProgram();


    }
}
