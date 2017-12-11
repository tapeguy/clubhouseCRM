package edu.fhsu.csci466.clubhouse.crm.service.model.groups;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import edu.fhsu.csci466.clubhouse.crm.service.model.Leader;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "teamId" )
@Entity
public class Team extends ResourceSupport implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 6649415180672374125L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              teamId;

    private String            teamName;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "leader_id" )
    private Leader            leader;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "member_id" )
    private Member            member;
    
    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "team", joinColumns = @JoinColumn( name = "id" ), inverseJoinColumns = @JoinColumn( name = "leader_id" ) )
    private List<Leader>      leaders;
    
    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "member_team_rel", joinColumns = @JoinColumn( name = "team_id" ), inverseJoinColumns = @JoinColumn( name = "member_id" ) )
    private List<Member>      members;
    
    /**
     * @return the id
     */
    public Long getTeamId()
    {
        return teamId;
    }

    /**
     * @param id the id to set
     */
    public void setTeamId( Long id )
    {
        this.teamId = id;
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
    
    /**
     * @return the member
     */
    public Member getMember()
    {
        return member;
    }
    
    /**
     * @return the members
     */
    public List<Member> getMembers()
    {
        return members;
    }
    
    /**
     * @return the teams
     */
    public List<Leader> getLeaders()
    {
        return leaders;
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
        result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
        if ( teamId == null )
        {
            if ( other.teamId != null )
                return false;
        }
        else if ( !teamId.equals( other.teamId ) )
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
        return "Team [id=" + teamId + ", teamName=" + teamName + ", leader=" + leader + "]";
    }
}
