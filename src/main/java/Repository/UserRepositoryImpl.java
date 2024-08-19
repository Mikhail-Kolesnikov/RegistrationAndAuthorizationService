package Repository;

import Entity.User;
import Exceptions.UserNotFoundException;
import Exceptions.UserAlreadyExistsException;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private File file;

    public UserRepositoryImpl(File file) {
        this.file = file;
        load(file.getName());
    }

    HashMap < String, User > userRepository  = new HashMap<>();

   public void addToRepository (User user, String overwrite) throws UserAlreadyExistsException {
     if( userRepository.get(user.getLogin()) != null){
       if(overwrite.isEmpty()){
        throw new UserAlreadyExistsException("This User is already registered.");
       }
     }
       userRepository.put(user.getLogin(), user);
   }

   public User getUser(String login) throws UserNotFoundException {

       User user = userRepository.get(login);
       if(user == null){
           throw new UserNotFoundException("Invalid login or email.");
       }
      return userRepository.get(login);
   }

   public User getUser(String login, String email) throws UserNotFoundException {
  User user = getUser(login);
  if(user.getEmail().equals(email)){
      return user;
  } else throw new UserNotFoundException("Invalid login or email.");
}


    @Override
    public boolean save() {
        List<User> users = this.userRepository.values().stream().toList();

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (User user : users) {
                bufferedWriter.write(user.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void load (String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            for (String line; (line = br.readLine()) != null; ) {
                User user = new User(line);
                addToRepository(user, "+");
            }

        } catch (IOException e) {
            System.out.println("Cannot load the history.");
            e.printStackTrace();
        } catch ( UserAlreadyExistsException e1){
            System.out.println("Duplicate user will be ignored.");
            e1.printStackTrace();
        }
    }
}
