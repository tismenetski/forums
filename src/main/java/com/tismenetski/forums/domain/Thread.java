package com.tismenetski.forums.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String threadText;
    //private Long  threadCreatedById;
    private Boolean threadIsOpened;
    private Long threadCommentsNum;
    private Long threadWatchedNum;

    @OneToMany(mappedBy = "thread",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> threadComments;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public Thread(String threadText, /*Long threadCreatedById,*/ Boolean threadIsOpened, Long threadCommentsNum, Long threadWatchedNum, List<Comment> threadComments, User user) {
        this.threadText = threadText;
        //this.threadCreatedById = threadCreatedById;
        this.threadIsOpened = threadIsOpened;
        this.threadCommentsNum = threadCommentsNum;
        this.threadWatchedNum = threadWatchedNum;
        this.threadComments = threadComments;
        this.user = user;
    }

    public Thread()
    {

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
}
