package com.terryx.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.terryx.jsonview.Views;

/**
 * Created by xueta on 2016/4/19 16:23.
 */
public class SimilarEntity {

    @JsonView(Views.Public.class)
    private UserEntity userEntity;

    @JsonView(Views.Public.class)
    private Double similarity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }
}
