package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    User getUserById(Long id);
    void add(User user);
    void removeUserById(Long id);
    List<User> listUsers();
    void update(Long id, User user);
}
