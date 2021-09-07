package util;

import domain.User;
import repository.CommentRepository;
import repository.LikeRepository;
import repository.TweetRepository;
import repository.UserRepository;
import repository.impl.CommentRepositoryImpl;
import repository.impl.LikeRepositoryImpl;
import repository.impl.TweetRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.CommentService;
import service.LikeService;
import service.TweetService;
import service.UserService;
import service.impl.CommentServiceImpl;
import service.impl.LikeServiceImpl;
import service.impl.TweetServiceImpl;
import service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

public class ApplicationContext {
    private static final EntityManager entityManger;
    private static final Scanner numberScanner;
    private static final Scanner stringScanner;
    private static final Menu menu;
    private static final ApplicationRun applicationRun;

    private static final UserRepository userRepository;
    private static final LikeRepository likeRepository;
    private static final CommentRepository commentRepository;
    private static final TweetRepository tweetRepository;

    private static final UserService userService;
    private static final LikeService likeService;
    private static final CommentService commentService;
    private static final TweetService tweetService;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        ApplicationContext.currentUser = currentUser;
    }

    private static User currentUser;

    static {
        entityManger = HibernateUtil.getEntityMangerFactory().createEntityManager();
        numberScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
        menu = new Menu();
        applicationRun = new ApplicationRun();

        userRepository = new UserRepositoryImpl(entityManger);
        likeRepository = new LikeRepositoryImpl(entityManger);
        commentRepository = new CommentRepositoryImpl(entityManger);
        tweetRepository = new TweetRepositoryImpl(entityManger);

        userService = (UserService) new UserServiceImpl(userRepository);
        likeService = (LikeService) new LikeServiceImpl((LikeRepositoryImpl) likeRepository);
        commentService = (CommentService) new CommentServiceImpl(commentRepository);
        tweetService = (TweetService) new TweetServiceImpl((TweetRepositoryImpl) tweetRepository);
    }

    public static EntityManager getEntityManger() {
        return entityManger;
    }

    public static Scanner getNumberScanner() {
        return numberScanner;
    }

    public static Scanner getStringScanner() {
        return stringScanner;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static ApplicationRun getApplicationRun() {
        return applicationRun;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static LikeRepository getLikeRepository() {
        return likeRepository;
    }

    public static CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public static TweetRepository getTweetRepository() {
        return tweetRepository;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static LikeService getLikeService() {
        return likeService;
    }

    public static CommentService getCommentService() {
        return commentService;
    }

    public static TweetService getTweetService() {
        return tweetService;
    }
}
