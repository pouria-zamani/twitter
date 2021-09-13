package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.User;
import repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery
                ("from User U where U.userName = :user_name", User.class);
        query.setParameter("user_name",username);
        try{
            return (User) query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
