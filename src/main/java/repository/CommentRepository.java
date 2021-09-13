package repository;

import base.repository.BaseRepository;
import domain.Comment;
import domain.Tweet;

import java.util.List;


public interface CommentRepository extends BaseRepository<Comment,Long> {

    Comment findByUserID(Long userID);

    List findByTweet(Tweet tweet);
}
