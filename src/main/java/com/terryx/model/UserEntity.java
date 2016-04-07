package com.terryx.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by xueta on 2016/3/26 17:07.
 */
@Entity
@Table(name = "User", schema = "firends_recommend")
public class UserEntity {
    private int userId;
    private String twUserId;
    private String name;
    private String screenName;
    private String location;
    private String language;
    private String description;
    private String profileImageUrl;
    private String rcmdUserIds;
    private String sinceId;
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
        if (twUserId != null ? !twUserId.equals(that.twUserId) : that.twUserId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (screenName != null ? !screenName.equals(that.screenName) : that.screenName != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (profileImageUrl != null ? !profileImageUrl.equals(that.profileImageUrl) : that.profileImageUrl != null)
            return false;
        if (rcmdUserIds != null ? !rcmdUserIds.equals(that.rcmdUserIds) : that.rcmdUserIds != null) return false;
        if (sinceId != null ? !sinceId.equals(that.sinceId) : that.sinceId != null) return false;
        if (maxId != null ? !maxId.equals(that.maxId) : that.maxId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (twUserId != null ? twUserId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (screenName != null ? screenName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (profileImageUrl != null ? profileImageUrl.hashCode() : 0);
        result = 31 * result + (rcmdUserIds != null ? rcmdUserIds.hashCode() : 0);
        result = 31 * result + (sinceId != null ? sinceId.hashCode() : 0);
        result = 31 * result + (maxId != null ? maxId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userById")
    //@Fetch(value = FetchMode.SUBSELECT)
    public Set<CorpusEntity> getCorpusesById() {
        return CorpusesById;
    }

    public void setCorpusesById(Set<CorpusEntity> corpusesById) {
        CorpusesById = corpusesById;
    }

    @OneToMany(mappedBy = "userById", fetch = FetchType.EAGER)
    //@Fetch(value = FetchMode.SUBSELECT)
    public Set<TweetEntity> getTweetsById() {
        return TweetsById;
    }

    public void setTweetsById(Set<TweetEntity> tweetsById) {
        TweetsById = tweetsById;
    }
}
