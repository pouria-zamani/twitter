package service;

import base.service.BaseService;
import domain.User;

import java.util.List;

public interface UserService extends BaseService<User,Long> {
    boolean login();

    void signUp();

    void edit();

    void changePassword();

    void deleteAccount();

    void showMyAccountInformation();

    User searchByUsername();
}
