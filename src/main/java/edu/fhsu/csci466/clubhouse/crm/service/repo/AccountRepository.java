package edu.fhsu.csci466.clubhouse.crm.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.Account;

/**
 * @author ss047890
 *
 *         A Spring Data JPA Account repository. An implementation of this interface gets
 *         auto-generated--no need to implement it by hand.
 */
public interface AccountRepository extends JpaRepository<Account, Long>
{
}
