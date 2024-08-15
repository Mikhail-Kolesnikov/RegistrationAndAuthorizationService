package Repository;

import Entity.User;
import Exceptions.UserNotFoundException;

public interface UserRepository {
    public void addToRepository( User user);
    public User getUser(String login);
    public User getUser(String login, String email)throws UserNotFoundException;
}
