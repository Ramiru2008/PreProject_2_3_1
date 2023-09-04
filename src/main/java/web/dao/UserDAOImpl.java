package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static int USERS_COUNT;
    @PersistenceContext
    private EntityManager em;
    List <User> users;
    {
        users = new ArrayList<>();
        users.add(new User(++USERS_COUNT, "Roman","Kudasov", 43));
        users.add(new User(++USERS_COUNT, "Ivan", "Petrov", 18));
        users.add(new User(++USERS_COUNT, "Peter", "Ivanov", 20));

    }
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
        // FIXME: 28.08.2023 remove limit
         // return users.stream().limit(5).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void add (User user) {
     em.persist(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return em.find(User.class, id); }

    @Override
    @Transactional
    public void removeUserById (Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    @Transactional
    public void edit(User user) {
     em.merge(user);
    }

}
