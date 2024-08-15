package Service;

import Repository.UserRepository;

public interface Authorization extends Service {

    boolean perform(UserRepository repository, String...parameters);

}
