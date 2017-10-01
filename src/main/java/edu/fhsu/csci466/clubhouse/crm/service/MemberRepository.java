package edu.fhsu.csci466.clubhouse.crm.service;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fhsu.csci466.clubhouse.crm.model.Member;

/**
 * @author ss047890
 *
 *         A Spring Data JPA member repository. An implementation of this interface gets
 *         auto-generated--no need to implement it by hand.
 */
public interface MemberRepository extends JpaRepository<Member, Long>
{
}
