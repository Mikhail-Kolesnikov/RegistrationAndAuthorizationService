package Repository;

import Entity.User;
import Exceptions.UserAlreadyExistsException;
import Exceptions.UserNotFoundException;

public interface UserRepository {
     void addToRepository( User user, String overwrite) throws UserAlreadyExistsException;
     User getUser(String login);
     User getUser(String login, String email)throws UserNotFoundException;
    boolean save();
    boolean load(String s);

}
