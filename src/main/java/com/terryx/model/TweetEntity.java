package com.terryx.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by xueta on 2016/3/26 17:07.
 */
@Entity
@Table(name = "Tweet", schema = "firends_recommend", catalog = "")
public class TweetEntity {
    private int tweetId;
    private String twTweetId;
    private String text;
    private Timestamp createdAt;
    private String lang;
    private String coordinatesX;
    private String coordinatesY;
    private UserEntity userById;

    @Id
    @Column(name = "tweet_id", nullable = false)
    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    @Basic
    @Column(name = "tw_tweet_id", nullable = false, length = 45)
    public String getTwTweetId() {
        return twTweetId;
    }

    public void setTwTweetId(String twTweetId) {
        this.twTweetId = twTweetId;
    }

    @Basic
    @Column(name = "text", nullable = true, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "lang", nullable = true, length = 45)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Basic
    @Column(name = "coordinates_x", nullable = true, length = 45)
    public String getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(String coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    @Basic
    @Column(name = "coordinates_y", nullable = true, length = 45)
    public String getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(String coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TweetEntity that = (TweetEntity) o;

        if (tweetId != that.tweetId) return false;
        if (twTweetId != null ? !twTweetId.equals(that.twTweetId) : that.twTweetId != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (lang != null ? !lang.equals(that.lang) : that.lang != null) return false;
        if (coordinatesX != null ? !coordinatesX.equals(that.coordinatesX) : that.coordinatesX != null) return false;
        if (coordinatesY != null ? !coordinatesY.equals(that.coordinatesY) : that.coordinatesY != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tweetId;
        result = 31 * result + (twTweetId != null ? twTweetId.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        result = 31 * result + (coordinatesX != null ? coordinatesX.hashCode() : 0);
        result = 31 * result + (coordinatesY != null ? coordinatesY.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUserById() {
        return userById;
    }

    public void setUserById(UserEntity userById) {
        this.userById = userById;
    }
}
