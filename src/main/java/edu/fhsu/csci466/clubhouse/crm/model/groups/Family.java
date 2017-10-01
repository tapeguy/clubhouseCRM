package edu.fhsu.csci466.clubhouse.crm.model.groups;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@Entity
public class Family implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 9211437925695051298L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            familyName;

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
     * @return the familyName
     */
    public String getFamilyName()
    {
        return familyName;
    }

    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName( String familyName )
    {
        this.familyName = familyName;
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
        result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Family other = (Family) obj;
        if ( familyName == null )
        {
            if ( other.familyName != null )
                return false;
        }
        else if ( !familyName.equals( other.familyName ) )
            return false;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
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
        return "Family [id=" + id + ", familyName=" + familyName + "]";
    }
}
