package service;

import model.Login;
import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
