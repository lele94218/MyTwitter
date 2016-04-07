package com.terryx.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by xueta on 2016/3/26 17:07.
 */
@Entity
@Table(name = "Corpus", schema = "firends_recommend", catalog = "")
public class CorpusEntity {
    private int corpusId;
    private String word;
    private Integer count;
    private UserEntity userById;
    private Timestamp latestTime;

    @Id
    @Column(name = "corpus_id", nullable = false)
    public int getCorpusId() {
        return corpusId;
    }

    public void setCorpusId(int corpusId) {
        this.corpusId = corpusId;
    }

    @Basic
    @Column(name = "word", nullable = true, length = 45)
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "count", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "latest_time", nullable = true)
    public Timestamp getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Timestamp latestTime) {
        this.latestTime = latestTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CorpusEntity that = (CorpusEntity) o;

        if (corpusId != that.corpusId) return false;
        if (word != null ? !word.equals(that.word) : that.word != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (latestTime != null ? !latestTime.equals(that.count) : that.latestTime != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = corpusId;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (latestTime != null ? latestTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public UserEntity getUserById() {
        return userById;
    }

    public void setUserById(UserEntity userById) {
        this.userById = userById;
    }
}
