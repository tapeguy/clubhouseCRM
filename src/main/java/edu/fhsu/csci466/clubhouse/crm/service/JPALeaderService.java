package edu.fhsu.csci466.clubhouse.crm.service;

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
    public void addLeader( final Leader event )
    {
        leaderRepo.save( event );
    }

}
