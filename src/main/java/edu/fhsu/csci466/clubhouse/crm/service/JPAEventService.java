package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.Event;
import edu.fhsu.csci466.clubhouse.crm.service.repo.EventRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPAEventService implements EventService
{
    @Autowired
    EventRepository eventRepo;

    @Override
    public void addEvent( final Event event )
    {
        eventRepo.save( event );
    }

    @Override
    public List<Event> getEvents()
    {
        List<Event> events = eventRepo.findAll();
        return events;
    }

    @Override
    public Event getEvent( final Long id )
    {
        return eventRepo.findOne( id );
    }
}
