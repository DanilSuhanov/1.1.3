package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    Session session = Util.getSessionFactory().openSession();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session.beginTransaction();
        User user = User.builder()
                .name(name)
                .lastName(lastName)
                .age(age)
                .build();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        session.beginTransaction();
        User deleteUser = session.find(User.class, id);
        if (deleteUser != null) {
            session.remove(deleteUser);
        }
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        session.beginTransaction();
        List<User> userList = session.createQuery("from User", User.class).getResultList();
        session.getTransaction().commit();
        return userList;
    }

    @Override
    public void cleanUsersTable() {

    }
}
