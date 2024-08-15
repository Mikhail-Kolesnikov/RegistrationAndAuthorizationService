package Service;

import Repository.UserRepository;

public interface ResetPassword extends Service{

    boolean perform(UserRepository repository, String... parameters);

}
