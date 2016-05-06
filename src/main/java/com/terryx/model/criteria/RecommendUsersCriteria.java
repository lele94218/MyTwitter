package com.terryx.model.criteria;

/**
 * 推荐用户
 * Created by xueta on 2016/4/19 16:18.
 */
public class RecommendUsersCriteria {
    //用户 id
    private int userId;
    //查询深度
    private int number;
    //前多少名相似用户
    private int top;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
