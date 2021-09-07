package service;

import base.service.BaseService;
import domain.Tweet;

public interface TweetService extends BaseService<Tweet,Long> {
    void addTweet();

    void deleteTweet();

    void editTweet();

    void showTweet();

    void showAllTweets();

    void showUserTweets();

}
