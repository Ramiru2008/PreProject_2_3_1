package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List <User> getAllUsers();
    void add (User user);
    void removeUserById(int id);
    void edit(User user);

}
