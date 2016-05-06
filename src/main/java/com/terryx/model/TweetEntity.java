package com.terryx.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by xueta on 2016/3/26 17:07.
 */
@Entity
@Table(name = "Tweet", schema = "firends_recommend")
public class TweetEntity {
    private int tweetId;
    private String twTweetId;
    private String text;
    private String rawText;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+08:00")
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
    @Column(name = "raw_text", nullable = true, length = -1)
    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
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
        return true;
    }

    @Override
    public int hashCode() {
        int result = tweetId;
        result = 31 * result + (twTweetId != null ? twTweetId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
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
