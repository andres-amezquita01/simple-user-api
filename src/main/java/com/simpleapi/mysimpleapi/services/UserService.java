package com.simpleapi.mysimpleapi.services;

import com.simpleapi.mysimpleapi.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User userToSave);
    public void removeUser(Long userId);
    public List<User> getAllUsers();
    public User findUserById(Long userId);
    public boolean updateUserState(User userToSave);
}