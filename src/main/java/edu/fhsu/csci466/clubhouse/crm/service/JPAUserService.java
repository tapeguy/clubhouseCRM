package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPAUserService implements UserService
{
    @Autowired
    UserRepository userRepo;

    @Override
    public void addUser( final User user )
    {
        userRepo.save( user );

    }

    @Override
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }

    @Override
    public User getUser( final Long id )
    {
        return userRepo.findOne( id );
    }

    @Override
    public void delete( final Long id )
    {
        userRepo.delete( id );
    }

    @Override
    public User getUsersByName( final String name )
    {
        return userRepo.findByName( name );
    }

    @Override
    public User getUsersByAccountNumber( final Long accountNumber )
    {
        return userRepo.findByAccountNumber( accountNumber );
    }

}
