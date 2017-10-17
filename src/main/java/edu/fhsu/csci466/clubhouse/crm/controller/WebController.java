package edu.fhsu.csci466.clubhouse.crm.controller;

import java.util.Map;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.fhsu.csci466.clubhouse.crm.service.model.Leader;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

@Controller
public class WebController {

    @RequestMapping( value= { "/", "/member_info" } )
    public String memberInfo( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("member_id", token.getMember().getMemberId());
        return "member_info";
    }

    @RequestMapping( value= "/member_events" )
    public String memberEvents( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("member_id", token.getMember().getMemberId());
        return "member_events";
    }

    @RequestMapping( value= "/member_teams" )
    public String memberTeams( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("member_id", token.getMember().getMemberId());
        return "member_teams";
    }

    @RequestMapping( value= "/member_payments" )
    public String memberPayments( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("member_id", token.getMember().getMemberId());
        return "member_payments";
    }

    @RequestMapping( value = "/about" )
    public String about( Map<String, Object> model )
    {
        model.put("version", "1.0");
        return "about";
    }

    @RequestMapping( value = "/admin" )
    public String admin( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        Member member = token.getMember();

        if ( token.getMember() instanceof Leader )
        {
            Leader leader = (Leader) member;
            if ( leader.isAdmin() )
            {
                model.put("name", token.getMember().getName());
                return "admin";
            }
        }
        throw new AccessDeniedException( "Access denied.");
    }
}
