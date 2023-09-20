package ru.rudchenko.CRUDAPP.DAO;

import ru.rudchenko.CRUDAPP.model.User;


import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> allUser(String name, String surname, Integer age, String city);
    User userById(long id);
    void update(long id, User user);
    void delete(long id);



}
