package com.simpleapi.mysimpleapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "user_simple_api")
public class User {
    @Id
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_last_name")
    private String userLastName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_active")
    private Boolean isActive;

    public User(){

    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPassword) {
        this.userPhone = userPassword;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean userState) {
        this.isActive = userState;
    }
}
