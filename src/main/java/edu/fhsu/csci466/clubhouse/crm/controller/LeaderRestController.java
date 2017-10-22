package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.LeaderService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
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
     * @param lastName
     * @return list of all leaders
     */
    @GetMapping( value = "/leader", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Leader>> getLeaders()
    {
        EntityList<Leader> list = new EntityList<>( service.getLeaders() );
        for ( Leader leader : list.getEntities() )
        {
            leader.add( linkTo( methodOn( LeaderRestController.class ).getLeader( leader.getMemberId() ) )
                            .withSelfRel() );
        }
        list.add( linkTo( methodOn( LeaderRestController.class ).getLeaders() ).withRel( "list" ) );
        list.add( linkTo( methodOn( LeaderRestController.class ).addLeader( null ) ).withRel( "add" ) );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param leader
     * @return response entity the status to return
     */
    @PostMapping( value = "/leader/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Leader> addLeader( @RequestBody Leader leader )
    {
        HttpStatus status = service.addLeader( leader ) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>( leader, status );
    }

    /**
     * @param id
     * @return leader
     */
    @GetMapping( value = "/leader/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Leader> getLeader( @PathVariable Long id )
    {
        Leader leader = service.getLeader( id );
        HttpStatus status = (leader != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        leader.add( linkTo( methodOn( LeaderRestController.class ).getLeader( id ) ).withSelfRel() );
        return new ResponseEntity<>( leader, status );
    }

    /**
     * @param leader the leader to update
     * @return response entity the status to return
     */
    @PutMapping( value = "/leader/update", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Leader> updateLeader( @RequestBody Leader leader )
    {
        HttpStatus status = service.updateLeader( leader ) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        leader.add( linkTo( methodOn( LeaderRestController.class ).getLeader( leader.getMemberId() ) ).withSelfRel() );
        return new ResponseEntity<>( leader, status );
    }

    /**
     * @param id
     * @return response entity the status to return
     */
    @DeleteMapping( value = "leader/delete/{id}" )
    public HttpEntity<Leader> deleteLeader( @PathVariable Long id )
    {
        Leader leader = service.getLeader( id );
        HttpStatus status = service.deleteLeader( id ) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>( leader, status );
    }
}
