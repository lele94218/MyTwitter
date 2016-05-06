package com.terryx.model.criteria;

/**
 * 有关用户的查询
 * Created by xueta on 2016/4/19 17:56.
 */
public class UserCriteria extends PageCriteria {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
