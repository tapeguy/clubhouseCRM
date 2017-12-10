package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Event;
import edu.fhsu.csci466.clubhouse.crm.service.repo.EventRepository;
import edu.fhsu.csci466.clubhouse.crm.service.repo.MemberRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPAEventService implements EventService {
	private final EventRepository eventRepo;
	private final MemberRepository memberRepo;

	/**
	 * @param eventRepo
	 */
	@Autowired
	public JPAEventService(EventRepository eventRepo, MemberRepository memberRepo) {
		this.eventRepo = eventRepo;
		this.memberRepo = memberRepo;
	}

	@Override
	public boolean addEvent(Event event) {
		if (event != null) {
			eventRepo.save(event);
			return true;
		}
		return false;
	}

	@Override
	public List<Event> getEvents() {
		List<Event> events = eventRepo.findAll();
		return events;
	}

	@Override
	public Event getEvent(final Long id) {
		return eventRepo.findOne(id);
	}

	@Override
	public boolean updateEvent(Event event) {
		// ensure event already exists before trying to update
		if (event != null && eventRepo.exists(event.getEventId())) {
			eventRepo.save(event);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEvent(final Long id) {
		if (id != null && eventRepo.exists(id)) {
			eventRepo.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean addMemberToEvent(Long memberId, Long id) {
		if (memberId != null && id != null) {
			Event e = eventRepo.getOne(id);
			Member m = memberRepo.getOne(memberId);
			if (m != null && e != null) {
				memberRepo.save(addEventToMember(m, e));
				eventRepo.save(addMemberToEvent(m, e));
				return true;
			}
		}
		return false;
	}

	private static Event addMemberToEvent(final Member m, final Event e) {
		Event event = e;
		List<Member> members = event.getMembers();
		if (members == null)
			members = new ArrayList<>();
		members.add(m);
		event.setMembers(members);
		return event;
	}

	private static Member addEventToMember(final Member m, final Event e) {
		Member member = m;
		List<Event> events = m.getMemberEvents();
		if (events == null)
			events = new ArrayList<>();
		events.add(e);
		m.setMemberEvents(events);
		return member;
	}
}
