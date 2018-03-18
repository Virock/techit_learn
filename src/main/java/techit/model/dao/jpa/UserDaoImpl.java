package techit.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import techit.model.User;
import techit.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User order by id", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUser(String username) {
        return entityManager.createQuery("from User where username= :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<User> getUsers(int position, Long id) {
        return entityManager.createQuery("from User where position = :position and id = :id", User.class)
                .setParameter("position", User.Position.values()[position])
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUser(String username, String email) {
        return entityManager.createQuery("from User where username = :username and email = :email", User.class)
                .setParameter("username", username)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<User> getUsers(int position, Long pos, Long id) {
        return entityManager.createQuery("from User where position = :position or position = :pos and unitid = :unitid", User.class)
                .setParameter("position", position)
                .setParameter("pos", pos)
                .setParameter("unitid", id)
                .getResultList();
    }

}
