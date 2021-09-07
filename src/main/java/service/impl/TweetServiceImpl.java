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

public class TweetServiceImpl extends BaseServiceImpl<Tweet, Long, TweetRepository> implements TweetService {
    public TweetServiceImpl(TweetRepositoryImpl repository) {
        super(repository);
    }

    private User currentUser;

    @Override
    public void addTweet() {
        setCurrentUser();
        Tweet tweet = new Tweet();
        System.out.println("Enter Tweet's Content:");
        tweet.setContent(ApplicationContext.getStringScanner().nextLine());

        tweet.setUser(currentUser);
        tweet.setDate(LocalDateTime.now());

        repository.save(tweet);

        System.out.println("Tweet added Successfully");
    }

    @Override
    public void deleteTweet() {
        setCurrentUser();
        System.out.println("PLease enter the id of tweet that you want to delete:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        if (repository.findById(id).getUser().getId() != currentUser.getId()) {
            System.out.println("This tweet doesnt belong to you!");
        } else {
            System.out.println("Are you sure to delete this tweet?(if yes enter 1)");
            int n = ApplicationContext.getNumberScanner().nextInt();
            if (n == 1) {
                repository.deleteById(id);
                System.out.println("Your tweet deleted Successfully!");
            } else
                System.out.println("Tweet not deleted!");
        }
    }

    @Override
    public void editTweet() {
        setCurrentUser();
        Tweet tweet;
        System.out.println("PLease enter the id of tweet that you want to edit:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        if (repository.findById(id).getUser().getId() != currentUser.getId()) {
            System.out.println("This tweet doesnt belong to you!");
        } else {
            tweet = repository.findById(id);
            System.out.println("Enter Tweet's Content:");
            tweet.setContent(ApplicationContext.getStringScanner().nextLine());
            tweet.setDate(LocalDateTime.now());

            repository.update(tweet);
            System.out.println("Tweet edited successfully!");
        }
    }

    @Override
    public void showTweet() {
        setCurrentUser();
        Tweet tweet;
        System.out.println("PLease enter the id of tweet that you want to edit:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        tweet = repository.findById(id);
        if(tweet != null)
            System.out.println(tweet);
        else
            System.out.println("This tweet id doesn't exist!");
    }

    @Override
    public void showAllTweets() {
        setCurrentUser();
        System.out.println("All tweets:");
        System.out.println(repository.findAll());
    }

    @Override
    public void showUserTweets() {
        setCurrentUser();
        System.out.println("Your Tweets:");
        System.out.println(repository.findByUserID(this.currentUser.getId()));
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser() {
        this.currentUser = ApplicationContext.getCurrentUser();
    }
}
