package com.tismenetski.forums.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tismenetski.forums.domain.security.Authority;
import com.tismenetski.forums.domain.security.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id",nullable = false,updatable = false) //@Column add attributes to a column
    private Long id;


    @Column(name="username",nullable = false,unique = true) //@Column add attributes to a column
    private String username;

    @Column(name="email",nullable = false ,unique = true)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    private Date userRegistrationDate;
    private Long userThreadsNum;
    private Long userCommentsNum;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> userComments;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Thread> userThreads;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles=new HashSet<>();











    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
        return authorities;
    }





    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
