package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

import edu.fhsu.csci466.clubhouse.crm.service.EventService;
import edu.fhsu.csci466.clubhouse.crm.service.MemberService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Event;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class EventRestController
{
    private final EventService            service;

    private final MemberService           memberService;

    private static final Predicate<Event> isNotFull   = e -> e.getReservedSeats() < e.getMaxEventSeats();

    private static final Consumer<Event>  addSelfLink = e -> e
                    .add( linkTo( methodOn( EventRestController.class ).getEvent( e.getEventId() ) ).withSelfRel() );

    /**
     * @param service
     * @param memberService
     */
    @Autowired
    public EventRestController ( EventService service, MemberService memberService )
    {
        this.service = service;
        this.memberService = memberService;
    }

    /**
     * @param lastName
     * @return list of all Event
     */
    @GetMapping( value = "/event", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Event>> getEvents()
    {
        EntityList<Event> list = new EntityList<>( service.getEvents() );
        for ( Event event : list.getEntities() )
        {
            event.add( linkTo( methodOn( EventRestController.class ).getEvent( event.getEventId() ) ).withSelfRel() );
        }
        list.add( linkTo( methodOn( EventRestController.class ).getEvents() ).withRel( "list" ) );
        list.add( linkTo( methodOn( EventRestController.class ).addEvent( null ) ).withRel( "add" ) );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param memberId
     * @return List of Event
     */
    @GetMapping( value = "/event/available/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Event>> getAvailableEventsForMember( @PathVariable Long memberId )
    {
        // Assumes an event is available for a member IFF the event is not already full.

     // @formatter:off

        List<Event> events = service.getEvents()
                                    .stream()
                                    .filter( isNotFull )
                                    .peek( addSelfLink )
                                    .collect( Collectors.toList());
        
     // @formatter:on

        EntityList<Event> list = new EntityList<>( events );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param memberId
     * @return List of Event
     */
    @GetMapping( value = "/event/enrolled/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Event>> getEnrolledEventsForMember( @PathVariable Long memberId )
    {
        Member member = memberService.getMember( memberId );

     // @formatter:off
        
        List<Event> events = service.getEvents()
                                    .stream()
                                    .filter( e -> e.getMembers().contains( member ) )
                                    .peek( addSelfLink )
                                    .collect( Collectors.toList());
                        
     // @formatter:on
        EntityList<Event> list = new EntityList<>( events );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param id
     * @return Event
     */
    @GetMapping( value = "/event/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Event> getEvent( @PathVariable Long id )
    {
        Event Event = service.getEvent( id );
        Event.add( linkTo( methodOn( EventRestController.class ).getEvent( id ) ).withSelfRel() );
        return new ResponseEntity<>( Event, HttpStatus.OK );
    }

    /**
     * @param event
     * @return response entity the status to return
     */
    @PostMapping( value = "/event/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Event> addEvent( @RequestBody Event event )
    {
        HttpStatus status = service.addEvent( event ) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        event.add( linkTo( methodOn( EventRestController.class ).getEvent( event.getEventId() ) ).withSelfRel() );
        return new ResponseEntity<>( event, status );
    }

    /**
     * @param event
     * @return response entity the status to return
     */
    @PutMapping( value = "/event/update", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Event> updateEvent( @RequestBody Event event )
    {
        HttpStatus status = service.updateEvent( event ) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        event.add( linkTo( methodOn( EventRestController.class ).getEvent( event.getEventId() ) ).withSelfRel() );
        return new ResponseEntity<>( event, status );
    }

    /**
     * @param id
     * @return response entity the status to return
     */
    @DeleteMapping( value = "/event/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Event> deleteEvent( @RequestBody Long id )
    {
        HttpStatus status = service.deleteEvent( id ) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>( status );
    }
}
