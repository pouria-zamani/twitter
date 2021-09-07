package service.impl;

import base.service.impl.BaseServiceImpl;
import com.github.javafaker.App;
import domain.Like;
import domain.Tweet;
import domain.User;
import repository.LikeRepository;
import repository.impl.LikeRepositoryImpl;
import service.LikeService;
import util.ApplicationContext;

public class LikeServiceImpl extends BaseServiceImpl<Like,Long, LikeRepository> implements LikeService {
    public LikeServiceImpl(LikeRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public void edit() {
        System.out.println("Enter tweet id:");
        Long tweetID = ApplicationContext.getNumberScanner().nextLong();
        Like like = repository.findByTweetID(tweetID);
        System.out.println("Enter user id");
        Long userID = ApplicationContext.getNumberScanner().nextLong();
        Like like2 = repository.findByUserID(userID);
        if(like2.getId() == like.getId())
        {
            System.out.println("Are you sure you want to change your opinion?(if yes enter 1)");
            int n = ApplicationContext.getNumberScanner().nextInt();
            if(n == 1) {
                like.setLike(!like.isLike());
                repository.update(like);
                System.out.println("You changed your opinion successfully!");
            }
            else
                System.out.println("Like not changed!");
        }
        else
            System.out.println("this like doesn't exist!");
    }

    @Override
    public void add() {
        Like like = new Like();
        System.out.println("Enter tweet id:");
        Long tweetID = ApplicationContext.getNumberScanner().nextLong();
        Tweet tweet = ApplicationContext.getTweetRepository().findById(tweetID);
        System.out.println("Enter user id");
        Long userID = ApplicationContext.getNumberScanner().nextLong();
        User user = ApplicationContext.getUserRepository().findById(userID);
        like.setUser(user);
        like.setTweet(tweet);

        System.out.println("You want to like or dislike?");
        System.out.println("1.Like");
        System.out.println("2.Disike");
        int n = ApplicationContext.getNumberScanner().nextInt();
        if(n==1)
            like.setLike(true);
        else
            like.setLike(false);

        repository.save(like);
        System.out.println("Your like added to tweet Successfully!");
    }

    @Override
    public void delete() {
        System.out.println("Enter tweet id:");
        Long tweetID = ApplicationContext.getNumberScanner().nextLong();
        Like like = repository.findByTweetID(tweetID);
        System.out.println("Enter user id");
        Long userID = ApplicationContext.getNumberScanner().nextLong();
        Like like2 = repository.findByUserID(userID);
        if(like.getId() == like2.getId())
        {
            System.out.println("Are you sure you want to delete your opinion?(if yes enter 1)");
            int n = ApplicationContext.getNumberScanner().nextInt();
            if(n == 1) {
                like.setDeleted(true);
                repository.update(like);
                System.out.println("You deleted your opinion successfully!");
            }
            else
                System.out.println("Like not deleted!");
        }
        else
            System.out.println("this like doesn't exist!");
    }
}
