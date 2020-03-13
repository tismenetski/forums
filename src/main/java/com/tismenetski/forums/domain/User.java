package com.tismenetski.forums.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private Date userRegistrationDate;
    private boolean userIsBanned;
    private Long userThreadsNum;
    private Long userCommentsNum;
    private Byte[] userImage;
    private Set<Comment> userComments;
    private Set<Thread> userThreads;

    public User()
    {

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

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public boolean isUserIsBanned() {
        return userIsBanned;
    }

    public void setUserIsBanned(boolean userIsBanned) {
        this.userIsBanned = userIsBanned;
    }

    public Long getUserThreadsNum() {
        return userThreadsNum;
    }

    public void setUserThreadsNum(Long userThreadsNum) {
        this.userThreadsNum = userThreadsNum;
    }

    public Long getUserCommentsNum() {
        return userCommentsNum;
    }

    public void setUserCommentsNum(Long userCommentsNum) {
        this.userCommentsNum = userCommentsNum;
    }

    public Byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(Byte[] userImage) {
        this.userImage = userImage;
    }

    public Set<Comment> getUserComments() {
        return userComments;
    }

    public void setUserComments(Set<Comment> userComments) {
        this.userComments = userComments;
    }

    public Set<Thread> getUserThreads() {
        return userThreads;
    }

    public void setUserThreads(Set<Thread> userThreads) {
        this.userThreads = userThreads;
    }
}
