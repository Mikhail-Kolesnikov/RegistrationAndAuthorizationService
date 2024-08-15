package Repository;

import Entity.User;
import Exceptions.UserNotFoundException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class UserRepositoryImpl implements UserRepository {

    private File file;

    public UserRepositoryImpl(File file) {
        this.file = file;
    }

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

    @Override
    public boolean saveUser(User user) {

        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(user.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();

            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }


}
