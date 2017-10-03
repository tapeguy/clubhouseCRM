package edu.fhsu.csci466.clubhouse.crm.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
