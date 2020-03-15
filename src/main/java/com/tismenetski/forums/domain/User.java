package com.tismenetski.forums.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id",nullable = false,updatable = false) //@Column add attributes to a column
    private Long id;
    @Column(name="userName",nullable = false,unique = true) //@Column add attributes to a column
    private String userName;

    @Column(name="email",nullable = false ,unique = true)
    private String userEmail;

    private Date userRegistrationDate;
    private boolean userIsBanned;
    private Long userThreadsNum;
    private Long userCommentsNum;
    //private Byte[] userImage;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> userComments;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Thread> userThreads;


    public User(String userName, String userEmail, Date userRegistrationDate, boolean userIsBanned, Long userThreadsNum, Long userCommentsNum, List<Comment> userComments, List<Thread> userThreads) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRegistrationDate = userRegistrationDate;
        this.userIsBanned = userIsBanned;
        this.userThreadsNum = userThreadsNum;
        this.userCommentsNum = userCommentsNum;
        this.userComments = userComments;
        this.userThreads = userThreads;
    }

    public User()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Comment> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<Comment> userComments) {
        this.userComments = userComments;
    }

    public List<Thread> getUserThreads() {
        return userThreads;
    }

    public void setUserThreads(List<Thread> userThreads) {
        this.userThreads = userThreads;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
