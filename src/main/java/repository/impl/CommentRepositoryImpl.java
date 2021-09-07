package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Comment;
import domain.Like;
import domain.Tweet;
import domain.User;
import repository.CommentRepository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
                ("from comment_table c where c.user_id = :user_id", Comment.class);
        query.setParameter("user_id", userID);
        try{
            return (Comment) query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public Comment findByTweetID(Long tweetID) {
        Query query = entityManager.createQuery
                ("from comment_table c where c.tweet_id = :tweet_id", Comment.class);
        query.setParameter("tweet_id", tweetID);
        try{
            return (Comment) query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
