package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Credential;
import edu.fhsu.csci466.clubhouse.crm.service.repo.CredentialRepository;
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

    private final MemberRepository     memberRepo;
    private final CredentialRepository credentialRepo;

    /**
     * @param memberRepo
     * @param credentialRepo
     */
    @Autowired
    public JPAMemberService ( MemberRepository memberRepo, CredentialRepository credentialRepo )
    {
        this.memberRepo = memberRepo;
        this.credentialRepo = credentialRepo;
    }

    @Override
    public boolean addMember( Member member )
    {
        if ( member != null )
        {
            memberRepo.save( member );
            return true;
        }
        return false;
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
    public Member getMemberByName( final String userName )
    {
        Member member = memberRepo.findByCredentialUserName( userName );
        return member;
    }

    @Override
    public boolean updateMember( Member member )
    {
        if ( member != null )
        {
            memberRepo.save( member );
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMemberPassword( Long id, String password )
    {
        Member member = memberRepo.findOne( id );
        if ( member != null )
        {
            Credential credential = member.getCredential();
            credential.setPassword( password );
            member.setCredential( credential );

            credentialRepo.save( credential );
            memberRepo.save( member );
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMember( Member member )
    {
        if ( member != null )
        {
            memberRepo.delete( member );
            return true;
        }
        return false;
    }
}
