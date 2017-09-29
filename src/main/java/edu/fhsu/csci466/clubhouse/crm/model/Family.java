package edu.fhsu.csci466.clubhouse.crm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Family implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2186733647978029262L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            familyName;

    private Set<Member>       members;

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
     * @return the name
     */
    public String getTeamName()
    {
        return familyName;
    }

    /**
     * @param name the name to set
     */
    public void setTeamName( String name )
    {
        this.familyName = name;
    }

    /**
     * @return the members
     */
    public Set<Member> getMembers()
    {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers( Set<Member> members )
    {
        this.members = members;
    }
}
