package edu.fhsu.csci466.clubhouse.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.LeaderService;
import edu.fhsu.csci466.clubhouse.crm.service.model.Leader;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class LeaderRestController
{
    private final LeaderService service;

    /**
     * @param service
     */
    @Autowired
    public LeaderRestController ( LeaderService service )
    {
        this.service = service;
    }

    /**
     * @param leader
     * @return response entity the status to return
     */
    @PostMapping( value = "/leader/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Leader> addLeader( @RequestBody Leader leader )
    {
        service.addLeader( leader );
        return new ResponseEntity<>( leader, HttpStatus.OK );
    }
}
