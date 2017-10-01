package edu.fhsu.csci466.clubhouse.crm.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.Credential;

/**
 * @author ss047890
 *
 *         A Spring Data JPA Credential repository. An implementation of this interface gets
 *         auto-generated--no need to implement it by hand.
 */
public interface CredentialRepository extends JpaRepository<Credential, Long>
{
}
