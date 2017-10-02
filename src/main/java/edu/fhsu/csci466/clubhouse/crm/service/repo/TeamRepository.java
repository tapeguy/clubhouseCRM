package edu.fhsu.csci466.clubhouse.crm.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Team;

/**
 * @author ss047890
 *
 *         A Spring Data JPA team repository. An implementation of this interface gets
 *         auto-generated--no need to implement it by hand.
 */
public interface TeamRepository extends JpaRepository<Team, Long>
{
}
