package edu.fhsu.csci466.clubhouse.crm.model;

import java.util.Set;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@Entity
@ToString
@EqualsAndHashCode( callSuper = true )
public class Leader extends Member
{
    /**
     * 
     */
    private static final long serialVersionUID = 3951515115717003589L;

    private String            leaderType;
    private Set<Team>         teams;

    /**
     * @return the leaderType
     */
    public String getLeaderType()
    {
        return leaderType;
    }

    /**
     * @param leaderType the leaderType to set
     */
    public void setLeaderType( final String leaderType )
    {
        this.leaderType = leaderType;
    }

    /**
     * @return the teams
     */
    public Set<Team> getTeams()
    {
        return teams;
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams( final Set<Team> teams )
    {
        this.teams = teams;
    }
}
