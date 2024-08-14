package Controller;

import java.util.Scanner;

public class UserController {
    public Scanner scanner;


    public void startProgram() {
        while (true) {
            String commandLine = scanner.nextLine();
            Command command = Command.valueOf(commandLine);

            switch (command) {
                case REGISTER_USER -> registerUser();
                case AUTHORISE_USER -> authoriseUser();
                case RESET_PASSWORD -> resetPassword();
            }
        }
    }

    private void registerUser() {


    }


    private void authoriseUser() {


    }


    private void resetPassword() {
    }


}
