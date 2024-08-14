package Repository;

import Entity.User;

import java.util.HashMap;
import java.util.Map;

public class PasswordRepositoryImpl implements PasswordRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getLogin(), user);

    }

    @Override
    public User findByLogin(String login) {
        return users.get(login);
    }
}
