package com.tismenetski.forums.domain.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {  //Represents an authority granted to an Authentication object.A GrantedAuthority must either represent itself as a String or be specifically supported by an AccessDecisionManager.


    private final String authority;

    public Authority(String authority)
    {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }




}
