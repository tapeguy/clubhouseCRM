package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.repo.MemberRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPAMemberService implements MemberService
{
    @Autowired
    MemberRepository memberRepo;

    @Override
    public void addMember( final Member member ) {
        memberRepo.save( member );
    }

    @Override
    public List<Member> getMembers()
    {
        List<Member> members = memberRepo.findAll();
        return members;
    }

    @Override
    public Member getMember( final Long id )
    {
        return memberRepo.findOne( id );
    }

    @Override
    public Member getMemberByUserName( final String userName )
    {
        Member member = memberRepo.findByCredentialUserName ( userName );
        return member;
    }
}
