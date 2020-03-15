package com.tismenetski.forums.domain;


import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String commentText;
    private Long  commentCreatedById;
    private Long commentThreadId;

    @ManyToOne
    @JoinColumn(name="thread_id")
    private Thread thread;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public Comment()
    {

    }

    public Comment(String commentText, Long commentCreatedById, Long commentThreadId) {
        this.commentText = commentText;
        this.commentCreatedById = commentCreatedById;
        this.commentThreadId = commentThreadId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getCommentCreatedById() {
        return commentCreatedById;
    }

    public void setCommentCreatedById(Long commentCreatedById) {
        this.commentCreatedById = commentCreatedById;
    }

    public Long getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(Long commentThreadId) {
        this.commentThreadId = commentThreadId;
    }
}
