package service.impl;

import base.service.impl.BaseServiceImpl;
import com.github.javafaker.App;
import domain.Tweet;
import domain.User;
import repository.TweetRepository;
import repository.impl.TweetRepositoryImpl;
import service.TweetService;
import util.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class TweetServiceImpl extends BaseServiceImpl<Tweet, Long, TweetRepository> implements TweetService {
    public TweetServiceImpl(TweetRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public void addTweet() {
        Tweet tweet = new Tweet();
        System.out.println("Enter Tweet's Content:");

        String content = new Scanner(System.in).nextLine();
        tweet.setContent(content);

        tweet.setUser(ApplicationContext.getCurrentUser());
        tweet.setDate(LocalDateTime.now());

        repository.save(tweet);

        System.out.println("Tweet added Successfully");
    }

    @Override
    public void deleteTweet() {
        System.out.println("PLease enter the id of tweet that you want to delete:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        if (repository.findById(id).getUser().getId() != ApplicationContext.getCurrentUser().getId()) {
            System.out.println("This tweet doesnt belong to you!");
        } else {
            if (repository.findById(id).getDeleted() != null)
                System.out.println("This Tweet ID doesn't Exist!");
            else {
                System.out.println("Are you sure to delete this tweet?(if yes enter 1)");
                int n = ApplicationContext.getNumberScanner().nextInt();
                if (n == 1) {
                    repository.deleteById(id);
                    System.out.println("Your tweet deleted Successfully!");
                } else
                    System.out.println("Tweet not deleted!");
            }
        }
    }

    @Override
    public void editTweet() {
        Tweet tweet;
        System.out.println("PLease enter the id of tweet that you want to edit:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        if (repository.findById(id).getUser().getId() != ApplicationContext.getCurrentUser().getId()) {
            System.out.println("This tweet doesnt belong to you!");
        } else {
            if (repository.findById(id).getDeleted() != null)
                System.out.println("This Tweet ID doesn't Exist!");
            else {
                tweet = repository.findById(id);
                System.out.println("Enter Tweet's Content:");
                String content = new Scanner(System.in).nextLine();

                tweet.setContent(content);
                tweet.setDate(LocalDateTime.now());
                repository.update(tweet);

                System.out.println("Tweet edited successfully!");
            }
        }
    }

    @Override
    public void showTweet() {
        Tweet tweet;
        System.out.println("PLease enter the id of Tweet:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        tweet = repository.findById(id);
        tweet.setLikes(ApplicationContext.getLikeRepository().findByTweet(tweet));
        tweet.setComments(ApplicationContext.getCommentRepository().findByTweet(tweet));
        if (tweet != null && tweet.getDeleted() == null)
            System.out.println(tweet);
        else
            System.out.println("This tweet id doesn't exist!");
    }

    @Override
    public void showAllTweets() {
        System.out.println("All tweets:");
        List<Tweet> tweets = repository.findAll();
        for (Tweet tweet : tweets)
            if (tweet.getDeleted() == null)
                showByTweet(tweet);
    }

    @Override
    public void showUserTweets() {
        System.out.println("Your Tweets:");
        List<Tweet> tweets = repository.findByUserID(ApplicationContext.getCurrentUser().getId());
        for (Tweet tweet : tweets)
            if (tweet.getDeleted() == null)
                showByTweet(tweet);

    }

    public void showByTweet(Tweet tweet)
    {
        tweet.setLikes(ApplicationContext.getLikeRepository().findByTweet(tweet));
        tweet.setComments(ApplicationContext.getCommentRepository().findByTweet(tweet));
        System.out.println(tweet);
    }

}
