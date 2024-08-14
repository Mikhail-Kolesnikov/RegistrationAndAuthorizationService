package Repository;

import Entity.User;

public interface PasswordRepository  {
    void save(User user);
    User findByLogin(String login);

}
