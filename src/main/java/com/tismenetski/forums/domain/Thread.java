package com.tismenetski.forums.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String threadText;
    private Boolean threadIsOpened;
    private Long threadCommentsNum;
    private Long threadWatchedNum;
    private Date threadDate;

    @OneToMany(mappedBy = "thread",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<Comment> threadComments;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="forum_id")
    private Forum forum;

    public Thread()
    {

    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThreadText() {
        return threadText;
    }

    public void setThreadText(String threadText) {
        this.threadText = threadText;
    }
/*
    public Long getThreadCreatedById() {
        return threadCreatedById;
    }

    public void setThreadCreatedById(Long threadCreatedById) {
        this.threadCreatedById = threadCreatedById;
    }


*/

    public Boolean getThreadIsOpened() {
        return threadIsOpened;
    }

    public void setThreadIsOpened(Boolean threadIsOpened) {
        this.threadIsOpened = threadIsOpened;
    }

    public Long getThreadCommentsNum() {
        return threadCommentsNum;
    }

    public void setThreadCommentsNum(Long threadCommentsNum) {
        this.threadCommentsNum = threadCommentsNum;
    }

    public Long getThreadWatchedNum() {
        return threadWatchedNum;
    }

    public void setThreadWatchedNum(Long threadWatchedNum) {
        this.threadWatchedNum = threadWatchedNum;
    }

    public List<Comment> getThreadComments() {
        return threadComments;
    }

    public void setThreadComments(List<Comment> threadComments) {
        this.threadComments = threadComments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getThreadDate() {
        return threadDate;
    }

    public void setThreadDate(Date threadDate) {
        this.threadDate = threadDate;
    }
}
