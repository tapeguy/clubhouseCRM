package edu.fhsu.csci466.clubhouse.crm.controller;

import java.util.Map;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping( value = { "/", "/member_info" } )
    public String memberInfo( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("member_id", token.getMember().getMemberId());
        return "member_info";
    }

    @RequestMapping( value = "/member_events" )
    public String memberEvents( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("member_id", token.getMember().getMemberId());
        return "member_events";
    }

    @RequestMapping( value = "/member_teams" )
    public String memberTeams( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("member_id", token.getMember().getMemberId());
        return "member_teams";
    }

    @RequestMapping( value = "/member_payments" )
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

    @RequestMapping( value = { "/admin", "/admin_members" } )
    public String adminMembers( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        if ( token.getMember().isLeaderAdmin() )
        {
        	model.put("leader_id", token.getMember().getMemberId());
        	return "admin_members";
        }
        throw new AccessDeniedException( "Access denied.");
    }

    @RequestMapping( value = "/admin_teams" )
    public String adminTeams( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        if ( token.getMember().isLeaderAdmin() )
        {
        	 model.put("leader_id", token.getMember().getMemberId());
        	return "admin_teams";
        }
        throw new AccessDeniedException( "Access denied.");
    }

    @RequestMapping( value = "/admin_events" )
    public String adminEvents( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        if ( token.getMember().isLeaderAdmin() )
        {
        	model.put("leader_id", token.getMember().getMemberId());
        	return "admin_events";
        }
        throw new AccessDeniedException( "Access denied.");
    }

    @RequestMapping( value = "/admin_financial" )
    public String adminFinancial( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        if ( token.getMember().isLeaderAdmin() )
        {
        	model.put("leader_id", token.getMember().getMemberId());
        	return "admin_financial";
        }
        throw new AccessDeniedException( "Access denied.");
    }
}
