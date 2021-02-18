package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleDao roleDao;

    @Override
    public User getUserByName(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :userEmail", User.class);
        return query.setParameter("userEmail", email).getSingleResult();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void update(Long id, User user) {
        User previousUser = entityManager.find(User.class, id);
        previousUser.setFirstName(user.getFirstName());
        previousUser.setLastName(user.getLastName());
        previousUser.setAge(user.getAge());
        previousUser.setEmail(user.getEmail());
        previousUser.setPassword(user.getPassword());
        previousUser.setRoles(user.getRoles());
        entityManager.merge(previousUser);
    }

}
