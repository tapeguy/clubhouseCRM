package edu.fhsu.csci466.clubhouse.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import edu.fhsu.csci466.clubhouse.crm.service.MemberService;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;


@Component
public class CrmAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    MemberService memberService;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException
    {
        try {
            String name = authentication.getName();
            String password = authentication.getCredentials().toString();

            Member member = memberService.getMemberByUserName( name );
            if ( member != null &&
                 member.getCredential() != null &&
                 member.getCredential().getPassword() != null &&
                 member.getCredential().getPassword().equals( password ) )
            {
                return new MemberToken( name, password, member );
            }
        }
        catch ( Exception e )
        {
            // Ignore and throw below
        }

        throw new BadCredentialsException ( "User not found or password incorrect." );
    }

    @Override
    public boolean supports( Class<?> authentication ) {
        return authentication.equals( UsernamePasswordAuthenticationToken.class );
    }
}
