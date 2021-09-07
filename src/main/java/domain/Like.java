package domain;

import base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "like_table")
public class Like extends BaseEntity<Long> {
    @Column(name = "is_like",nullable = false,columnDefinition = "TINYINT(1)")
    private boolean isLike;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    public Like(boolean isLike, User user, Tweet tweet) {
        this.isLike = isLike;
        this.user = user;
        this.tweet = tweet;
    }

    public Like() {
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    @Override
    public String toString() {
        return "Like{" +
                "isLike=" + isLike +
                ", user=" + user +
                ", tweet=" + tweet +
                '}';
    }
}
