package Repository;

import Entity.Password;
import Entity.User;

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


}
