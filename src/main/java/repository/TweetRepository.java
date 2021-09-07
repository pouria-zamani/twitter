package repository;

import base.repository.BaseRepository;
import domain.Tweet;

import java.util.List;

public interface TweetRepository extends BaseRepository<Tweet,Long> {
    public List<Tweet> findByUserID(Long userID);
}
