package Controller;

public enum Command {

    REGISTER_USER("Register a new user"),
    AUTHORIZE_USER("Log in to the system"),
    RESET_PASSWORD("Reset  your password"),
    EXIT("Exit.");
    private String string;

    Command(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
