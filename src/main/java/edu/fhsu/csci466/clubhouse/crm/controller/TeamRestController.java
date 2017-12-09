package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.TeamService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Team;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class TeamRestController
{
    private final TeamService service;

    /**
     * @param service
     */
    @Autowired
    public TeamRestController ( TeamService service )
    {
        this.service = service;
    }

    /**
     * @param lastName
     * @return list of all Team
     */
    @GetMapping( value = "/team", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Team>> getTeams()
    {
        EntityList<Team> list = new EntityList<>( service.getTeams() );
        for ( Team team : list.getEntities() )
        {
            team.add( linkTo( methodOn( TeamRestController.class ).getTeam( team.getTeamId() ) ).withSelfRel() );
        }
        list.add( linkTo( methodOn( TeamRestController.class ).getTeams() ).withRel( "list" ) );
        list.add( linkTo( methodOn( TeamRestController.class ).addTeam( null ) ).withRel( "add" ) );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param lastName
     * @return list of Teams
     */
    @GetMapping( value = "/team/member/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Team>> getTeamsByMember(Long memberId)
    {
        // TODO
        return null;
//        EntityList<Team> list = new EntityList<>( service.getTeamsMatchingMember( memberId ) );
//        for ( Team team : list.getEntities() )
//        {
//            team.add( linkTo( methodOn( TeamRestController.class ).getTeamsByLeader( team.getLeader().getMemberId() ) ).withSelfRel() );
//        }
//        list.add( linkTo( methodOn( TeamRestController.class ).getTeams() ).withRel( "list" ) );
//        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param lastName
     * @return list of Teams
     */
    @GetMapping( value = "/team/leader/{leaderId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Team>> getTeamsByLeader(Long leaderId)
    {

        EntityList<Team> list = new EntityList<>( service.getTeamsMatchingLeader( leaderId ) );
        for ( Team team : list.getEntities() )
        {
            team.add( linkTo( methodOn( TeamRestController.class ).getTeamsByLeader( team.getLeader().getMemberId() ) ).withSelfRel() );
        }
        list.add( linkTo( methodOn( TeamRestController.class ).getTeams() ).withRel( "list" ) );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param team
     * @return response entity the status to return
     */
    @PostMapping( value = "/team/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Team> addTeam( @RequestBody Team team )
    {
        service.addTeam( team );
        return new ResponseEntity<>( team, HttpStatus.OK );
    }

    /**
     * @param id
     * @return Team
     */
    @GetMapping( value = "/team/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Team> getTeam( @PathVariable Long id )
    {
        Team team = service.getTeam( id );
        team.add( linkTo( methodOn( TeamRestController.class ).getTeam( id ) ).withSelfRel() );
        return new ResponseEntity<>( team, HttpStatus.OK );
    }

    /**
     * @param addMemberToTeam
     * @return status
     */
    @PutMapping( value = "/team/{id}/addMember/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Team> addMemberToTeam( @PathVariable Long teamId, @PathVariable Long memberId )
    {
        HttpStatus status = service.addMemberToTeam( memberId, teamId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        Team team = service.getTeam( teamId );
        return new ResponseEntity<>( team, status );
    }
}
