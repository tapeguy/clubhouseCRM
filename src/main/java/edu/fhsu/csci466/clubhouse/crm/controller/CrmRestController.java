package edu.fhsu.csci466.clubhouse.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.MemberService;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class CrmRestController
{
    @Autowired
    MemberService service;

    /**
     * @param lastName
     * @return list of all member
     */
    @GetMapping( value = "/member", produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Member> getMembers()
    {
        List<Member> members = service.getMembers();
        return members;
    }

    /**
     * @param member
     * @return response entity the status to return
     */
    @PostMapping( value = "/member/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Member> addMember( @RequestBody Member member )
    {
        service.addMember( member );
        return new ResponseEntity<>( member, HttpStatus.OK );
    }

    /**
     * @param id
     * @return member
     */
    @GetMapping( value = "/member/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public Member getMember( @PathVariable Long id )
    {
        return service.getMember( id );
    }

    /**
     * @param id
     */
    @DeleteMapping( value = "/member/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus( HttpStatus.OK )
    public void deleteMember( @PathVariable Long id )
    {
        service.delete( id );
    }
}
