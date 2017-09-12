package edu.fhsu.csci466.clubhouse.crm.service;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ss047890
 * 
 *         A Spring Data JPA user repository. An implementation of this interface gets
 *         auto-generated--no need to implement it by hand.
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    /**
     * @param name the name of a user
     * @return user the user corresponding to the name parameter
     * 
     *         Looks up user by name. This naive version assumes uniqueness of names.
     */
    public User findByName( String name );

    /**
     * @param accountNumber the account number of an individual user
     * @return user the user matching the account number
     * 
     *         Looks up a user by their account number
     */
    public User findByAccountNumber( Long accountNumber );
}
