package edu.fhsu.csci466.clubhouse.crm.service;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ss047890
 *
 *         A Spring Data JPA member repository. An implementation of this interface gets
 *         auto-generated--no need to implement it by hand.
 */
public interface MemberRepository extends JpaRepository<Member, Long>
{
    /**
     * @param name the name of a member
     * @return member the member corresponding to the name parameter
     *
     *         Looks up member by name. This naive version assumes uniqueness of names.
     */
    public Member findByName( String name );

    /**
     * @param accountNumber the account number of an individual member
     * @return member the member matching the account number
     *
     *         Looks up a member by their account number
     */
    public Member findByAccountNumber( Long accountNumber );
}
