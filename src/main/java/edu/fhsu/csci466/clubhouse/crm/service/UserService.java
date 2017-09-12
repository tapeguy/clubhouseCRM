package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

/**
 * @author ss047890
 *
 */
public interface UserService
{
    /**
     * @param user
     */
    public void addUser( final User user );

    /**
     * @return users
     */
    public List<User> getUsers();

    /**
     * @param id
     * @return user
     */
    public User getUser( Long id );

    /**
     * @param id
     */
    public void delete( Long id );

    /**
     * @param name
     * @return user
     */
    public User getUsersByName( final String name );

    /**
     * @param accountNumber
     * @return user
     */
    public User getUsersByAccountNumber( final Long accountNumber );
}
