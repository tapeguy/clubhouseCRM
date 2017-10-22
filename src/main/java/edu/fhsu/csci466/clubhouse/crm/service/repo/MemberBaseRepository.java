package edu.fhsu.csci466.clubhouse.crm.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author ss047890
 *
 *         A Spring Data JPA member repository. An implementation of this interface gets
 *         auto-generated--no need to implement it by hand.
 * 
 * @param <T> a type of Member or its subclasses
 */
public interface MemberBaseRepository<T extends Member> extends JpaRepository<T, Long>
{
    /**
     * Derived query from method name
     * 
     * @param userName
     * @return member a member corresponding to the userName arg
     */
    Member findByCredentialUserName( String userName );
}
