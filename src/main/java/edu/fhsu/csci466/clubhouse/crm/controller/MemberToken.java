package edu.fhsu.csci466.clubhouse.crm.controller;

import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

public class MemberToken extends UsernamePasswordAuthenticationToken
{
    /**
     *
     */
    private static final long serialVersionUID = 3808873373907833074L;


    private final Member member;

    public MemberToken( Object principal, Object credentials, Member member )
    {
        super( principal, credentials, new ArrayList<>() );
        this.member = member;
    }

    /**
     * @return the member
     */
    public Member getMember() {
        return member;
    }
}
