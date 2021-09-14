package repository.impl;

import com.github.javafaker.App;
import domain.Like;
import domain.Tweet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LikeRepositoryImplTest {

    @Test
    @DisplayName("Find Like By User ID method")
    void findByUserID() {
        Like actualLike = ApplicationContext.getLikeRepository().findByUserID(5L);
        Like expectedLike = ApplicationContext.getLikeRepository().findById(7L);

        assertEquals(expectedLike,actualLike);
    }

    @Test
    @DisplayName("Find Like By Tweet method")
    void findByTweet() {
        Tweet tweet = ApplicationContext.getTweetRepository().findById(4L);

        Like expectedLike = ApplicationContext.getLikeRepository().findById(7L);
        List<Like> actualLikes = ApplicationContext.getLikeRepository().findByTweet(tweet);

        assertTrue(actualLikes.contains(expectedLike));
    }
}