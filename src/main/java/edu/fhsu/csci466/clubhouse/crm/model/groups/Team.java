package edu.fhsu.csci466.clubhouse.crm.model.groups;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.model.Leader;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@Entity
public class Team implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6649415180672374125L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            teamName;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "leader_id" )
    private Leader            leader;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( Long id )
    {
        this.id = id;
    }

    /**
     * @return the teamName
     */
    public String getTeamName()
    {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName( String teamName )
    {
        this.teamName = teamName;
    }

    /**
     * @return the leader
     */
    public Leader getLeader()
    {
        return leader;
    }

    /**
     * @param leader the leader to set
     */
    public void setLeader( Leader leader )
    {
        this.leader = leader;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 19890919;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((leader == null) ? 0 : leader.hashCode());
        result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Team other = (Team) obj;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        if ( leader == null )
        {
            if ( other.leader != null )
                return false;
        }
        else if ( !leader.equals( other.leader ) )
            return false;
        if ( teamName == null )
        {
            if ( other.teamName != null )
                return false;
        }
        else if ( !teamName.equals( other.teamName ) )
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Team [id=" + id + ", teamName=" + teamName + ", leader=" + leader + "]";
    }
}
