package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author scottKC
 *
 */
public interface MemberService
{
    /**
     * @return member
     */
    public List<Member> getMembers();

    /**
     * @param member
     * @return whether the create member was successful
     */
    public boolean addMember( Member member );

    /**
     * @param id
     * @return member
     */
    public Member getMember( final Long id );

    /**
     * @param name
     * @return member
     */
    public Member getMemberByName( final String name );

    /**
     * @param member
     * @return whether the update was successful
     */
    public boolean updateMember( Member member );

    /**
     * @param id
     * @param password
     * @return whether the update of the member password was successful
     */
    public boolean updateMemberPassword( final Long id, final String password );

    /**
     * @param member
     * @return whether the delete was successful
     */
    public boolean deleteMember( Member member );

    /**
     * @param member
     * @param password
     * @return true if authentication was successful.
     */
    public boolean authenticate( Member member, String password );

    /**
     * @param id
     * @param payment
     * @return whether payment was successfully made
     */
    public boolean makePayment( final Long id, final Double payment );
}
