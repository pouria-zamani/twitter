package repository;

import base.repository.BaseRepository;
import domain.Like;
import domain.Tweet;
import domain.User;

public interface LikeRepository extends BaseRepository<Like,Long> {
    Like findByUserID(Long userID);

    Like findByTweetID(Long tweetID);
}
