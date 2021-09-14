package repository;

import base.repository.BaseRepository;
import domain.Comment;
import domain.Tweet;
import domain.User;

import java.util.List;


public interface CommentRepository extends BaseRepository<Comment,Long> {

    Comment findByUser(User user);

    List findByTweet(Tweet tweet);
}
