package domain;

import base.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "comment_table")
public class Comment extends BaseEntity<Long> {
    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(String content, LocalDateTime date, Tweet tweet, User user) {
        this.content = content;
        this.date = date;
        this.tweet = tweet;
        this.user = user;
    }

    public Comment() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content +
                ", user=" + user.getUserName() +
                '}';
    }
}
