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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.EventService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Event;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class EventRestController
{
    private final EventService service;

    /**
     * @param service
     */
    @Autowired
    public EventRestController ( EventService service )
    {
        this.service = service;
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
     * @param event
     * @return response entity the status to return
     */
    @PostMapping( value = "/event/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Event> addEvent( @RequestBody Event event )
    {
        service.addEvent( event );
        return new ResponseEntity<>( event, HttpStatus.OK );
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
}
