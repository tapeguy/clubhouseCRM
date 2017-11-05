package edu.fhsu.csci466.clubhouse.crm.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder      passwordEncoder;

    private static final String NEW_PASSWORD_CHARSET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int NEW_PASSWORD_LENGTH = 32;
    private static final SecureRandom rand = new SecureRandom();

    /**
     * @param memberRepo
     * @param credentialRepo
     * @param passwordEncoder
     */
    @Autowired
    public JPAMemberService ( MemberRepository memberRepo, CredentialRepository credentialRepo,
                    PasswordEncoder passwordEncoder )
    {
        this.memberRepo = memberRepo;
        this.credentialRepo = credentialRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * member password is encrypted by default
     */
    @Override
    public boolean addMember( Member member )
    {
        if ( member != null )
        {
            if ( member.getCredential() != null )
            {
                Credential credential = member.getCredential();
                credential.setPassword( passwordEncoder.encode( this.randomPassword() ) );
                credentialRepo.save( credential );
                member.setCredential( credential );
            }

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
        if ( member != null && memberRepo.exists( member.getMemberId() ) )
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
            if ( credential != null )
            {
                credential.setPassword( passwordEncoder.encode( password ) );
                credentialRepo.save( credential );

                member.setCredential( credential );
                memberRepo.save( member );
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMember( Member member )
    {
        if ( member != null && memberRepo.exists( member.getMemberId() ) )
        {
            memberRepo.delete( member );
            return true;
        }
        return false;
    }

    @Override
    public boolean authenticate ( Member member, String password )
    {
        return ( member != null &&
                 member.getCredential() != null &&
                 member.getCredential().getPassword() != null &&
                 passwordEncoder.matches ( password, member.getCredential().getPassword() ) );
    }

    private String randomPassword()
    {
        StringBuilder sb = new StringBuilder( NEW_PASSWORD_LENGTH );
        for ( int i = 0; i < NEW_PASSWORD_LENGTH; i++ )
           sb.append( NEW_PASSWORD_CHARSET.charAt( rand.nextInt ( NEW_PASSWORD_CHARSET.length() ) ) );
        return sb.toString();
    }
}
