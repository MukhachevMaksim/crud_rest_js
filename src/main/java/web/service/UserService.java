package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    void add(User user);
    void removeUserById(Long id);
    List<User> listUsers();
    void update(Long id, User user);
}
