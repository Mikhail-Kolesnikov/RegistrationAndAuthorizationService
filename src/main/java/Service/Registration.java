package Service;

import Repository.UserRepository;

public interface Registration extends Service {

  boolean perform(UserRepository repository, String ...parameters);

}
