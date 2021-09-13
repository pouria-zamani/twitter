package service.impl;

import base.service.impl.BaseServiceImpl;
import com.github.javafaker.App;
import domain.Comment;
import domain.Tweet;
import domain.User;
import repository.CommentRepository;
import service.CommentService;
import util.ApplicationContext;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CommentServiceImpl extends BaseServiceImpl<Comment, Long, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }


    @Override
    public void add() {
        Comment comment = new Comment();
        System.out.println("Enter tweet id:");
        Long tweetID = ApplicationContext.getNumberScanner().nextLong();
        Tweet tweet = ApplicationContext.getTweetRepository().findById(tweetID);
        User user = ApplicationContext.getCurrentUser();
        comment.setUser(user);
        comment.setTweet(tweet);
        comment.setDate(LocalDateTime.now());

        System.out.println("Enter your comment:");
        String content = new Scanner(System.in).nextLine();
        comment.setContent(content);

        repository.save(comment);
        System.out.println("your comment added successfully!");
    }

    @Override
    public void edit() {
        System.out.println("Enter Comment id:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        Comment comment = repository.findById(id);

        if (comment != null && comment.getDeleted() == null) {
            System.out.println("Are you sure you want to change your comment?(if yes enter 1)");
            int n = ApplicationContext.getNumberScanner().nextInt();
            if (n == 1) {
                System.out.println("Please enter your comment's content:");
                String content = new Scanner(System.in).nextLine();
                comment.setContent(content);
                repository.update(comment);
                System.out.println("You changed your comment successfully!");
            } else
                System.out.println("Ok,Comment not changed!");
        } else
            System.out.println("this Comment ID doesn't exist!");
    }

    @Override
    public void delete() {
        System.out.println("Enter Comment id:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        Comment comment = repository.findById(id);

        if (comment != null && comment.getDeleted() == null) {
            System.out.println("Are you sure you want to delete your comment?(if yes enter 1)");
            int n = ApplicationContext.getNumberScanner().nextInt();
            if (n == 1) {
                comment.setDeleted(true);
                repository.update(comment);
                System.out.println("You deleted your opinion successfully!");
            } else
                System.out.println("Comment not deleted!");
        } else
            System.out.println("this Comment ID doesn't exist!");
    }

    @Override
    public void show() {
        System.out.println("Enter Comment id:");
        Long id = ApplicationContext.getNumberScanner().nextLong();
        Comment comment = repository.findById(id);

        if (comment != null && comment.getDeleted() == null) {
            System.out.println(comment);
        } else
            System.out.println("this Comment doesn't exist!");
    }
}
