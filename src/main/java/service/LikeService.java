package service;

import base.service.BaseService;
import domain.Like;
import domain.Tweet;
import domain.User;

public interface LikeService extends BaseService<Like,Long> {
    void edit();

    void add();

    void delete();
}
