package com.dangxy.androidpractice.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/14
 */

public class RebaseUserEntity {

    /**
     * username : drakeet
     * name : drakeet
     * email : drakeet.me@gmail.com
     * description : an Android developer.
     * authorization : {"access_token":"431240f28f0637a640a051fce3632a88463dcc0o","updated_at":"2017-02-02T20:40:42+0800"}
     * created_at : 2017-02-02T20:40:42+0800
     */

    @SerializedName("username")
    private String username;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("description")
    private String description;
    @SerializedName("authorization")
    private AuthorizationBean authorization;
    @SerializedName("created_at")
    private String createdAt;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthorization(AuthorizationBean authorization) {
        this.authorization = authorization;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public AuthorizationBean getAuthorization() {
        return authorization;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public static class AuthorizationBean {
        /**
         * access_token : 431240f28f0637a640a051fce3632a88463dcc0o
         * updated_at : 2017-02-02T20:40:42+0800
         */

        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("updated_at")
        private String updatedAt;

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
    }
}
