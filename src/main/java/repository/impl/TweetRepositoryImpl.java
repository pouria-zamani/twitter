package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Tweet;
import domain.User;
import repository.TweetRepository;

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
        Query query = entityManager.createQuery
                ("from tweet_table t where t.user_id = :user_id", Tweet.class);
        query.setParameter("user_id", userID);
        try{
            return query.getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
}
