package com.tismenetski.forums.domain;


import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String commentText;

    @ManyToOne
    @JoinColumn(name="thread_id")
    private Thread thread;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


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

}
