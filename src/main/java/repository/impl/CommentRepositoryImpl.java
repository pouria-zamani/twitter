package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Comment;
import domain.Tweet;
import repository.CommentRepository;
import util.ApplicationContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment, Long> implements CommentRepository {
    public CommentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public Comment findByUserID(Long userID) {
        Query query = entityManager.createQuery
                ("from Comment c where c.user = :user_id", Comment.class);
        query.setParameter("user_id", userID);
        try{
            return (Comment) query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public List findByTweet(Tweet tweet) {
        Query query = entityManager.createQuery
                ("from Comment c where c.tweet = :tweet_id", Comment.class);
        query.setParameter("tweet_id", tweet);
        try{
            return query.getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
}
