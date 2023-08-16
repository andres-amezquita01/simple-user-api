package com.simpleapi.mysimpleapi.services.implementations;

import com.simpleapi.mysimpleapi.dao.UserDAO;
import com.simpleapi.mysimpleapi.domain.User;
import com.simpleapi.mysimpleapi.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDAO userDAO;
    public UserServiceImp(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    @Override
    @Transactional(readOnly = false)
    public User saveUser(User userToSave) {
        return userDAO.save(userToSave);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeUser(Long userId) {
        userDAO.deleteById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return (List<User>) userDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userDAO.findById(userId).orElse(null);
    }

    @Override
    public boolean updateUserState(User userToSave) {
        userToSave.setIsActive(!userToSave.getIsActive());
        return userDAO.save(userToSave).getIsActive();
    }
}
