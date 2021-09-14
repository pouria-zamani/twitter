package base.repository.impl;

import com.github.javafaker.App;
import domain.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseRepositoryImplTest {

    @BeforeAll
    static void printStart() {
        System.out.println("Starting Test...");
    }

    @AfterAll
    static void printEnd() {
        System.out.println("Test Ended!");
    }

    @Test
    @DisplayName("Find By ID method")
    void findById() {
        User expectedUser = ApplicationContext.getUserRepository().findByUsername("test_username");

        User actualUser = ApplicationContext.getUserRepository().findById(5L);

        assertEquals(expectedUser,actualUser);
    }

    @Test
    @DisplayName("Save method")
    void save() {
        User actualUser = new User();
        actualUser.setFirstName("ABCD");
        actualUser.setLastName("EFGH");
        actualUser.setUserName("UserNameTest");
        actualUser.setPassword("1234");

        ApplicationContext.getUserRepository().save(actualUser);
        User expectedUser = ApplicationContext.getUserRepository().findByUsername(actualUser.getUserName());

        assertEquals(expectedUser,actualUser);
    }

    @Test
    @DisplayName("Update method")
    void update() {
        User expectedUser = ApplicationContext.getUserRepository().findById(5L);
        expectedUser.setPassword("test_pass");
        ApplicationContext.getUserRepository().update(expectedUser);

        User actualUser = ApplicationContext.getUserRepository().findById(5L);

        assertEquals(expectedUser,actualUser);
    }

    @Test
    @DisplayName("Delete By ID method")
    void deleteById() {
        User expectedUser = ApplicationContext.getUserRepository().findById(5L);
        expectedUser.setDeleted(true);

        ApplicationContext.getUserRepository().deleteById(5L);
        User actualUser = ApplicationContext.getUserRepository().findById(5L);

        assertEquals(expectedUser,actualUser);
    }

    @Test
    @DisplayName("FindAll method")
    void findAll() {
        List<User> actualUsers = ApplicationContext.getUserRepository().findAll();

        User expectedUser = ApplicationContext.getUserRepository().findById(5L);

        assertTrue(actualUsers.contains(expectedUser));
    }
}