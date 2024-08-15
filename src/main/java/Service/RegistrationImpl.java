package Service;

import Repository.PasswordRepository;

public class RegistrationImpl implements Registration{
    private final PasswordRepository repository;

    public RegistrationImpl(PasswordRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean register(String userName, String login, String password) {
        if(repository.findByLogin(login) !=null){
            System.out.println("Такой логин уже существует");
            return false;
        }
        if (password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*].*")) {
            System.out.println("Некорректный пароль");

        }

        return false;




    }
}
