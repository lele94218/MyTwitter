package com.terryx.model;

import javax.persistence.*;

/**
 * Created by xueta on 2016/3/24.
 */
@Entity
@Table(name = "UserSim", schema = "firends_recommend")
public class UserSimEntity {
    private int usersimId;
    private String usersHashId;
    private int user1Id;
    private int user2Id;
    private Float sim1;

    @Id
    @Column(name = "usersim_id", nullable = false)
    public int getUsersimId() {
        return usersimId;
    }

    public void setUsersimId(int usersimId) {
        this.usersimId = usersimId;
    }

    @Basic
    @Column(name = "users_hash_id", nullable = false, length = 45)
    public String getUsersHashId() {
        return usersHashId;
    }

    public void setUsersHashId(String usersHashId) {
        this.usersHashId = usersHashId;
    }

    @Basic
    @Column(name = "user1_id", nullable = false)
    public int getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(int user1Id) {
        this.user1Id = user1Id;
    }

    @Basic
    @Column(name = "user2_id", nullable = false)
    public int getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
    }

    @Basic
    @Column(name = "sim_1", nullable = true, precision = 0)
    public Float getSim1() {
        return sim1;
    }

    public void setSim1(Float sim1) {
        this.sim1 = sim1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSimEntity that = (UserSimEntity) o;

        if (usersimId != that.usersimId) return false;
        if (user1Id != that.user1Id) return false;
        if (user2Id != that.user2Id) return false;
        if (usersHashId != null ? !usersHashId.equals(that.usersHashId) : that.usersHashId != null) return false;
        if (sim1 != null ? !sim1.equals(that.sim1) : that.sim1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usersimId;
        result = 31 * result + (usersHashId != null ? usersHashId.hashCode() : 0);
        result = 31 * result + user1Id;
        result = 31 * result + user2Id;
        result = 31 * result + (sim1 != null ? sim1.hashCode() : 0);
        return result;
    }
}
