package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Like;
import domain.Tweet;
import domain.User;
import repository.LikeRepository;
import util.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class LikeRepositoryImpl extends BaseRepositoryImpl<Like, Long> implements LikeRepository {
    public LikeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Like> getEntityClass() {
        return Like.class;
    }

    @Override
    public Like findByUserID(Long userID) {
        User user = ApplicationContext.getUserRepository().findById(userID);
        Query query = entityManager.createQuery
                ("from Like l where l.user = :user_id", Like.class);
        query.setParameter("user_id", user);
        try{
            return (Like) query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public List findByTweet(Tweet tweet) {
        Query query = entityManager.createQuery
                ("from Like l where l.tweet = :tweet_id", Like.class);
        query.setParameter("tweet_id", tweet);
        try{
            return query.getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
}
