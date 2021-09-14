package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import com.github.javafaker.App;
import domain.Tweet;
import domain.User;
import repository.TweetRepository;
import util.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet, Long> implements TweetRepository {
    public TweetRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Tweet> getEntityClass() {
        return Tweet.class;
    }

    @Override
    public List<Tweet> findByUserID(Long userID) {
        User user = ApplicationContext.getUserRepository().findById(userID);
        Query query = entityManager.createQuery
                ("from Tweet t where t.user = :user_id", Tweet.class);
        query.setParameter("user_id", user);
        try{
            return query.getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
}
