package repository.impl;

import domain.Tweet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TweetRepositoryImplTest {

    @Test
    @DisplayName("Find Tweet By User method")
    void findByUserID() {
        Tweet expectedTweet = ApplicationContext.getTweetRepository().findById(4L);

        List<Tweet> actualTweets = ApplicationContext.getTweetRepository().findByUserID(5L);

        assertTrue(actualTweets.contains(expectedTweet));
    }
}