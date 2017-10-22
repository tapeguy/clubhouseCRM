package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.Leader;
import edu.fhsu.csci466.clubhouse.crm.service.repo.LeaderRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPALeaderService implements LeaderService
{
    private final LeaderRepository leaderRepo;

    /**
     * @param leaderRepo
     */
    @Autowired
    public JPALeaderService ( LeaderRepository leaderRepo )
    {
        this.leaderRepo = leaderRepo;
    }

    @Override
    public List<Leader> getLeaders()
    {
        return leaderRepo.findAll();
    }

    @Override
    public boolean addLeader( final Leader leader )
    {
        if ( leader != null )
        {
            leaderRepo.save( leader );
            return true;
        }
        return false;
    }

    @Override
    public Leader getLeader( Long id )
    {
        return leaderRepo.findOne( id );
    }

    @Override
    public Leader getLeaderByName( String name )
    {
        return (Leader) leaderRepo.findByCredentialUserName( name );
    }

    @Override
    public boolean updateLeader( Leader leader )
    {
        if ( leader != null )
        {
            leaderRepo.save( leader );
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLeader( Leader leader )
    {
        if ( leader != null )
        {
            leaderRepo.delete( leader );
            return true;
        }
        return false;
    }
}
