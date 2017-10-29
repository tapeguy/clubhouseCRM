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
     * @return whether event creation was successful
     */
    public boolean addEvent( Event event );

    /**
     * @return event
     */
    public List<Event> getEvents();

    /**
     * @param id the id of the event to get
     * @return event
     */
    public Event getEvent( final Long id );

    /**
     * @param event
     * @return whether event update was successful
     */
    public boolean updateEvent( Event event );

    /**
     * @param id the id of the event to delete
     * @return whether event deletion was successful
     */
    public boolean deleteEvent( final Long id );
}
