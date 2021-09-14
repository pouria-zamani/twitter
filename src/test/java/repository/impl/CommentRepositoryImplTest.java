package repository.impl;

import domain.Comment;
import domain.Tweet;
import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CommentRepository;
import util.ApplicationContext;
import util.HibernateUtil;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {

    @Test
    @DisplayName("Find Comment By User method")
    void findByUser() {
        User user = ApplicationContext.getUserRepository().findById(5L);
        Comment expectedComment = ApplicationContext.getCommentRepository().findById(6L);
        Comment actualComment = ApplicationContext.getCommentRepository().findByUser(user);

        assertEquals(expectedComment,actualComment);
    }

    @Test
    @DisplayName("Find Comment By Tweet method")
    void findByTweet() {
        Tweet tweet = ApplicationContext.getTweetRepository().findById(4L);
        Comment expectedComment = ApplicationContext.getCommentRepository().findById(6L);
        List<Comment> actualComments = ApplicationContext.getCommentRepository().findByTweet(tweet);

        assertTrue(actualComments.contains(expectedComment));
    }
}