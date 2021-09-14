package repository.impl;

import com.github.javafaker.App;
import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    @Test
    @DisplayName("Find User By Username method")
    void findByUsername() {
        User expectedUser = ApplicationContext.getUserRepository().findById(5L);
        User actualUser = ApplicationContext.getUserRepository().findByUsername("test_username");

        User actualUser2 = ApplicationContext.getUserRepository().findByUsername("asdadsadasd");

        assertEquals(expectedUser,actualUser);
        assertEquals(null,actualUser2);
    }
}