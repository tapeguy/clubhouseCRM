package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author ss047890
 *
 */
public interface MemberService
{
    /**
     * @param member
     */
    public void addMember( final Member member );

    /**
     * @return member
     */
    public List<Member> getMembers();

    /**
     * @param id
     * @return member
     */
    public Member getMember( final Long id );
}
