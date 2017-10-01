package edu.fhsu.csci466.clubhouse.crm.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ss047890
 *
 */
@Entity
public class LeaderType implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1078978072074481968L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            display;

    /**
     * 
     */
    public LeaderType ()
    {
    }

    /**
     * @param id
     * @param display
     */
    public LeaderType ( Long id, String display )
    {
        this.id = id;
        this.display = display;
    }

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
     * @return the display
     */
    public String getDisplay()
    {
        return display;
    }

    /**
     * @param display the display to set
     */
    public void setDisplay( String display )
    {
        this.display = display;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((display == null) ? 0 : display.hashCode());
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
        LeaderType other = (LeaderType) obj;
        if ( display == null )
        {
            if ( other.display != null )
                return false;
        }
        else if ( !display.equals( other.display ) )
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
        return "LeaderType [id=" + id + ", display=" + display + "]";
    }
}
