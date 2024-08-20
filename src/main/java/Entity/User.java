package Entity;

import java.util.Objects;

public class User {

    private String userName;
    private String login;
    private Password password;
    private String email;


    public User(String login, String userName, String email, Password password) {
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public  User (String s) {
        if (s.length() != 0) {
            s = s.substring(5, s.length() - 1);
            String[] sl = s.split(",");

            for (int i = 0; i < sl.length; i++) {
                String[] pair = sl[i].split("=");
                pair[0] = pair[0].trim();
                pair[1] = pair[1].trim().replaceAll("^\'|\'$", "");

                switch (pair[0]) {
                    case "login" -> login = pair[1];

                    case "userName" -> userName = pair[1];

                    case "email" -> email = pair[1];

                    case "password" -> password = new Password(pair[1]);

                }
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password.getPasswordHash() +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login)&& Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }

}
