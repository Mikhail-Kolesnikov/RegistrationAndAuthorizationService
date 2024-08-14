package Repository;

import Entity.Password;
import Entity.User;
import Exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
 HashMap < String, User > userRepository  = new HashMap<>();

   public void addToRepository( User user){
       userRepository.put(user.getLogin(), user);
   }

   public User getUser(String login){
      return userRepository.get(login);
   }

    public User getUser(String login, String email) throws UserNotFoundException {
  User user = getUser(login);
  if(user.getEmail().equals(email)){
      return user;
  } else throw new UserNotFoundException("Invalid login or email.");
}


}
