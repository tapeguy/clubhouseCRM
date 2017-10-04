package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Team;
import edu.fhsu.csci466.clubhouse.crm.service.repo.TeamRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPATeamService implements TeamService
{
    @Autowired
    TeamRepository teamRepo;

    @Override
    public void addTeam( final Team team )
    {
        teamRepo.save( team );
    }

    @Override
    public List<Team> getTeams()
    {
        List<Team> teams = teamRepo.findAll();
        return teams;
    }

    @Override
    public Team getTeam( final Long id )
    {
        return teamRepo.findOne( id );
    }
}
