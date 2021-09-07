package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Like;
import domain.Tweet;
import domain.User;
import repository.LikeRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
        Query query = entityManager.createQuery
                ("from like_table l where l.user_id = :user_id", Like.class);
        query.setParameter("user_id", userID);
        try{
            return (Like) query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public Like findByTweetID(Long tweetID) {
        Query query = entityManager.createQuery
                ("from like_table l where l.tweet_id = :tweet_id", Like.class);
        query.setParameter("tweet_id", tweetID);
        try{
            return (Like) query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
