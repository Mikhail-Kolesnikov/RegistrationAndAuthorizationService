package Repository;

import Entity.User;
import Exceptions.UserNotFoundException;

public interface UserRepository {
     void addToRepository( User user);
     User getUser(String login);
     User getUser(String login, String email)throws UserNotFoundException;
    boolean saveUser(User user);

}
