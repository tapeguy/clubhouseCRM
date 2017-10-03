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

    @RequestMapping("/")
    public String index( @AuthenticationPrincipal MemberToken token, Map<String, Object> model )
    {
        model.put("name", token.getMember().getName());
        return "index";
    }

    @RequestMapping("/about")
    public String about( Map<String, Object> model )
    {
        model.put("version", "1.0");
        return "about";
    }

    @RequestMapping("/admin")
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
