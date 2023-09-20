package ru.rudchenko.CRUDAPP.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rudchenko.CRUDAPP.DAO.UserDaoImpl;
import ru.rudchenko.CRUDAPP.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;
    @Override
    //@Transactional
            @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public List<User> allUser(String name, String surname, Integer age, String city) {
        return userDao.allUser(name, surname, age, city);
    }

    @Override
    @Transactional
    public User userById(long id) {
        return userDao.userById(id);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }
}
