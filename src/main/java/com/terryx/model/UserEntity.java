package com.terryx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.terryx.jsonview.Views;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xueta on 2016/3/26 17:07.
 */
@Entity
@Table(name = "User", schema = "firends_recommend")
public class UserEntity {

    @JsonView(Views.Public.class)
    private int userId;

    @JsonIgnore
    private String twUserId;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String screenName;

    @JsonIgnore
    private String location;

    @JsonIgnore
    private String language;

    @JsonView(Views.Public.class)
    private String description;

    @JsonView(Views.Public.class)
    private String profileImageUrl;

    @JsonIgnore
    private String rcmdUserIds;

    @JsonIgnore
    private String sinceId;

    @JsonIgnore
    private String maxId;

    private Set<CorpusEntity> CorpusesById;

    private Set<TweetEntity> TweetsById;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "tw_user_id", nullable = true, length = 45)
    public String getTwUserId() {
        return twUserId;
    }

    public void setTwUserId(String twUserId) {
        this.twUserId = twUserId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "screen_name", nullable = true, length = 45)
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 45)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "profile_image_url", nullable = true, length = -1)
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    @Basic
    @Column(name = "rcmd_user_ids", nullable = true, length = 100)
    public String getRcmdUserIds() {
        return rcmdUserIds;
    }

    public void setRcmdUserIds(String rcmdUserIds) {
        this.rcmdUserIds = rcmdUserIds;
    }

    @Basic
    @Column(name = "since_id", nullable = true, length = 45)
    public String getSinceId() {
        return sinceId;
    }

    public void setSinceId(String sinceId) {
        this.sinceId = sinceId;
    }

    @Basic
    @Column(name = "max_id", nullable = true, length = 45)
    public String getMaxId() {
        return maxId;
    }

    public void setMaxId(String maxId) {
        this.maxId = maxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (twUserId != null ? twUserId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "userById")
    //@Fetch(value = FetchMode.SUBSELECT)
    public Set<CorpusEntity> getCorpusesById() {
        return CorpusesById;
    }

    public void setCorpusesById(Set<CorpusEntity> corpusesById) {
        CorpusesById = corpusesById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userById", fetch = FetchType.EAGER)
    //@Fetch(value = FetchMode.SUBSELECT)
    public Set<TweetEntity> getTweetsById() {
        return TweetsById;
    }

    public void setTweetsById(Set<TweetEntity> tweetsById) {
        TweetsById = tweetsById;
    }
}
