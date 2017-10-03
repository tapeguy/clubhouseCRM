package edu.fhsu.csci466.clubhouse.crm.controller;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;


// Wrapper for a member list that supports HATEOAS links
//
public class MemberList extends ResourceSupport {

    private List<? extends Member> members;

    public MemberList( List<? extends Member> members )
    {
        this.members = members;
    }

    /**
     * @return the members
     */
    public List<? extends Member> getMembers()
    {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers( List<? extends Member> members )
    {
        this.members = members;
    }
}
