package domain;

import base.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tweet_table")
public class Tweet extends BaseEntity<Long> {
    @Column(length = 280,name = "tweet_content")
    private String content;

    @Column(name = "tweet_date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "like_id")
    private List<Like> likes;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;

    public Tweet(String content, LocalDateTime date, User user, List<Like> likes, List<Comment> comments) {
        this.content = content;
        this.date = date;
        this.user = user;
        this.likes = likes;
        this.comments = comments;
    }

    public Tweet() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "content='" + content +
                ", likes=" + likes.size() +
                ", comments=" + comments +
                '}';
    }
}
