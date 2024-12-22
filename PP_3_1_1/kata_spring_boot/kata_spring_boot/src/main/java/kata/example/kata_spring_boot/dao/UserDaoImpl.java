package kata.example.kata_spring_boot.dao;

import org.springframework.stereotype.Repository;
import kata.example.kata_spring_boot.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        System.out.println(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}