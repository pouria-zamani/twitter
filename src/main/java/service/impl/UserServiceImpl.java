package service.impl;

import base.service.impl.BaseServiceImpl;
import com.github.javafaker.App;
import domain.User;
import repository.UserRepository;
import service.UserService;
import util.ApplicationContext;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    private User user;

    @Override
    public void signUp() {
        User user = new User();

        System.out.println("Enter firstname:");
        user.setFirstName(new Scanner(System.in).next());

        System.out.println("Enter lastname:");
        user.setLastName(new Scanner(System.in).next());

        System.out.println("Enter username:");
        String userName = ApplicationContext.getStringScanner().next();

        while (repository.findByUsername(userName) != null) {
            System.out.println("\nUsername not available!");
            System.out.println("Enter username:");
            userName = ApplicationContext.getStringScanner().next();
        }
        user.setUserName(userName);

        System.out.println("Enter Password:");
        String password = ApplicationContext.getStringScanner().next();
        user.setPassword(password);
        repository.save(user);
        System.out.println("Signed up Successfully!");
    }

    @Override
    public void edit() {
        System.out.println("Enter firstname:");
        user.setFirstName(new Scanner(System.in).next());

        System.out.println("Enter lastname:");
        user.setLastName(new Scanner(System.in).next());

        System.out.println("Enter username:");
        String userName = ApplicationContext.getStringScanner().next();

        while (repository.findByUsername(userName) != null && user.getUserName() == userName) {
            System.out.println("\nUsername not available!");
            System.out.println("Enter username:");
            userName = ApplicationContext.getStringScanner().next();
        }
        user.setUserName(userName);

        System.out.println("Enter Password:");
        String password = ApplicationContext.getStringScanner().next();
        user.setPassword(password);
        repository.update(user);
    }

    @Override
    public void changePassword() {
        System.out.println("Enter new Password:");
        String password = ApplicationContext.getStringScanner().next();
        user.setPassword(password);
        repository.update(user);
    }

    @Override
    public void deleteAccount() {
        System.out.println("Are you sure to delete your account?(if yes enter 1)");
        int n = ApplicationContext.getNumberScanner().nextInt();
        if (n == 1) {
            repository.deleteById(user.getId());
            System.out.println("Your account deleted Successfully!");
        } else
            System.out.println("Account not deleted!");
    }

    @Override
    public void showMyAccountInformation() {
        System.out.println("Your Account:");
        System.out.println(user);
    }

    @Override
    public User searchByUsername() {
        System.out.println("Enter the User's username:");
        String username = ApplicationContext.getStringScanner().next();
        User user = repository.findByUsername(username);
        return user;
    }

    @Override
    public boolean login() {
        System.out.println("Enter Username:");
        String userName = ApplicationContext.getStringScanner().next();

        System.out.println("Enter Password:");
        String passWord = ApplicationContext.getStringScanner().next();

        if (repository.findByUsername(userName) != null &&
                repository.findByUsername(userName).getPassword().equals(passWord)) {
            if (repository.findByUsername(userName).getDeleted() != null) {
                System.out.println("Your Account has been deleted!create another account!");
                return false;
            }
            this.user = repository.findByUsername(userName);
            ApplicationContext.setCurrentUser(this.user);

            System.out.println("\nSuccessfully Logged In!");
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
