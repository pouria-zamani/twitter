package service;

import base.service.BaseService;
import domain.Comment;
import domain.Tweet;
import domain.User;

public interface CommentService extends BaseService<Comment,Long> {

    void add();

    void edit();

    void delete();

    void show();

}
