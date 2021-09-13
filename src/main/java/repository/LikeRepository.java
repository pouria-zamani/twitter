package repository;

import base.repository.BaseRepository;
import domain.Like;
import domain.Tweet;

import java.util.List;

public interface LikeRepository extends BaseRepository<Like,Long> {
    Like findByUserID(Long userID);

    List findByTweet(Tweet tweet);
}
