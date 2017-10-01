package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.Event;

/**
 * @author ss047890
 *
 */
public interface EventService
{
    /**
     * @param event
     */
    public void addEvent( final Event event );

    /**
     * @return event
     */
    public List<Event> getEvents();

    /**
     * @param id
     * @return event
     */
    public Event getEvent( final Long id );
}
