package repository;

import base.repository.BaseRepository;
import domain.Comment;
import domain.Tweet;
import domain.User;


public interface CommentRepository extends BaseRepository<Comment,Long> {

    Comment findByUserID(Long userID);

    Comment findByTweetID(Long tweetID);
}
