package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Team;

/**
 * @author ss047890
 *
 */
public interface TeamService
{
    /**
     * @param team
     */
    public void addTeam( final Team team );

    /**
     * @return team
     */
    public List<Team> getTeams();

    /**
     * @param id
     * @return team
     */
    public Team getTeam( final Long id );
}
