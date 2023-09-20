package ru.rudchenko.CRUDAPP.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.rudchenko.CRUDAPP.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> allUser(String name, String surname, Integer age, String city) {
        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    @Override
    public User userById(long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void update(long id, User updatedUser) {
        User user1 = userById(id);
        user1.setName(updatedUser.getName());
        user1.setSurname(updatedUser.getSurname());
        user1.setAge(updatedUser.getAge());
        user1.setCity(updatedUser.getCity());
    }

    @Override
    public void delete(long id) {
        entityManager.remove(userById(id));
    }
}
