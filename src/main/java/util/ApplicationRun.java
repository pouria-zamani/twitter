package util;

import com.github.javafaker.App;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationRun {
    public void mainRun() {
        boolean run = true;
        while (run) {

            try {
                ApplicationContext.getMenu().printMainMenu();
                int mainMenuOption = new Scanner(System.in).nextInt();

                switch (mainMenuOption) {
                    case 1:
                        ApplicationContext.getUserService().signUp();
                        break;
                    case 2:
                        if (!ApplicationContext.getUserService().login())
                            System.out.println("\nUsername Or Password Is Wrong!");
                        else {

                            loginRun();
                            run = false;
                        }
                        break;
                    case 3:
                        ApplicationContext.getUserService().searchByUsername();
                        break;
                    case 4:
                        run = false;
                        break;
                    default:
                        System.out.println("\nInvalid Input!");
                }

                if (mainMenuOption != 4) {
                    System.out.println("Close?[y/n]");
                    if (ApplicationContext.getStringScanner().next().toLowerCase().startsWith("y"))
                        run = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input!");
            }
        }
    }

    public void loginRun() {
        boolean run = true;
        while (run) {

            try {
                ApplicationContext.getMenu().printSecondMenu();
                int loginMenuOption = new Scanner(System.in).nextInt();

                switch (loginMenuOption) {
                    case 1:
                        tweetRun();
                        break;
                    case 2:
                        commentRun();
                        break;
                    case 3:
                        likeRun();
                        break;
                    case 4:
                        userRun();
                        break;
                    case 5:
                        ApplicationContext.getApplicationRun().mainRun();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid Input!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Input!");
            }
        }
    }

    public void userRun(){
        boolean run = true;
        while (run) {

            try {
                ApplicationContext.getMenu().printAccountMenu();
                int accMenuOption = new Scanner(System.in).nextInt();

                switch (accMenuOption) {
                    case 1:
                        ApplicationContext.getUserService().edit();
                        break;
                    case 2:
                        ApplicationContext.getUserService().deleteAccount();
                        break;
                    case 3:
                        ApplicationContext.getApplicationRun().mainRun();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid Input!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Input!");
            }
        }
    }

    public void likeRun(){
        boolean run = true;
        while (run) {

            try {
                ApplicationContext.getMenu().printSecondMenu();
                int likeMenuOption = new Scanner(System.in).nextInt();

                switch (likeMenuOption) {
                    case 1:
                        ApplicationContext.getLikeService().add();
                        break;
                    case 2:
                        ApplicationContext.getLikeService().edit();
                        break;
                    case 3:
                        ApplicationContext.getLikeService().delete();
                        break;
                    case 4:
                        ApplicationContext.getApplicationRun().mainRun();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid Input!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Input!");
            }
        }
    }

    public void tweetRun(){
        boolean run = true;
        while (run) {

            try {
                ApplicationContext.getMenu().printSecondMenu();
                int tweetMenuOption = new Scanner(System.in).nextInt();

                switch (tweetMenuOption) {

                    case 1:
                        ApplicationContext.getTweetService().showAllTweets();
                        break;
                    case 2:
                        ApplicationContext.getTweetService().showUserTweets();
                        break;
                    case 3:
                        ApplicationContext.getTweetService().showTweet();
                        break;
                    case 4:
                        ApplicationContext.getTweetService().addTweet();
                        break;
                    case 5:
                        ApplicationContext.getTweetService().editTweet();
                        break;
                    case 6:
                        ApplicationContext.getTweetService().deleteTweet();
                        break;
                    case 7:
                        ApplicationContext.getApplicationRun().mainRun();
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid Input!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Input!");
            }
        }
    }

    public void commentRun(){
        boolean run = true;
        while (run) {

            try {
                ApplicationContext.getMenu().printSecondMenu();
                int commentRunOption = new Scanner(System.in).nextInt();

                switch (commentRunOption) {
                    case 1:
                        ApplicationContext.getCommentService().add();
                        break;
                    case 2:
                        ApplicationContext.getCommentService().show();
                        break;
                    case 3:
                        ApplicationContext.getCommentService().edit();
                        break;
                    case 4:
                        ApplicationContext.getCommentService().delete();
                        break;
                    case 5:
                        ApplicationContext.getApplicationRun().mainRun();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid Input!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Input!");
            }
        }
    }
}