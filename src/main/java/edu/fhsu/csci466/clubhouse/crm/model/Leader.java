package edu.fhsu.csci466.clubhouse.crm.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.model.groups.Team;
import edu.fhsu.csci466.clubhouse.crm.model.services.Credential;
import edu.fhsu.csci466.clubhouse.crm.model.services.Event;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( callSuper = true )
public class Leader extends Member
{
    /**
     * 
     */
    private static final long serialVersionUID = -693449250263673036L;

    private String            leaderType;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "credential_id" )
    private Credential        credential;

    private String            email;

    @OneToMany( fetch = FetchType.EAGER )
    @JoinColumn( name = "team_id" )
    private Set<Team>         teams;

    @ManyToMany( fetch = FetchType.LAZY )
    @JoinColumn( name = "event_id" )
    private Set<Event>        events;

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
    public void setLeaderType( String leaderType )
    {
        this.leaderType = leaderType;
    }

    /**
     * @return the credential
     */
    @Override
    public Credential getCredential()
    {
        return credential;
    }

    /**
     * @param credential the credential to set
     */
    @Override
    public void setCredential( Credential credential )
    {
        this.credential = credential;
    }

    /**
     * @return the email
     */
    @Override
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    @Override
    public void setEmail( String email )
    {
        this.email = email;
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
    public void setTeams( Set<Team> teams )
    {
        this.teams = teams;
    }

    /**
     * @return the events
     */
    @Override
    public Set<Event> getEvents()
    {
        return events;
    }

    /**
     * @param events the events to set
     */
    @Override
    public void setEvents( Set<Event> events )
    {
        this.events = events;
    }
}
