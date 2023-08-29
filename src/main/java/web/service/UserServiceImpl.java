package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl (UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void add (User user) {
        userDAO.add(user);
    }

    @Override
    public void removeUserById (int id) {
        userDAO.removeUserById(id);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }
}
