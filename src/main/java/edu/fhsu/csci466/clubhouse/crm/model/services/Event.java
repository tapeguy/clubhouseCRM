package edu.fhsu.csci466.clubhouse.crm.model.services;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.fhsu.csci466.clubhouse.crm.model.Leader;

/**
 * @author ss047890
 *
 */
public class Event implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1640027737818053147L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private LocalDateTime     eventDate;

    private String            eventDisplay;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "account_id" )
    private Leader            leader;

    private String            eventLocation;

    private Integer           maxEventSeats;

    private Integer           reservedSeats;

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
     * @return the eventDate
     */
    public LocalDateTime getEventDate()
    {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate( LocalDateTime eventDate )
    {
        this.eventDate = eventDate;
    }

    /**
     * @return the eventDisplay
     */
    public String getEventDisplay()
    {
        return eventDisplay;
    }

    /**
     * @param eventDisplay the eventDisplay to set
     */
    public void setEventDisplay( String eventDisplay )
    {
        this.eventDisplay = eventDisplay;
    }

    /**
     * @return the eventLocation
     */
    public String getEventLocation()
    {
        return eventLocation;
    }

    /**
     * @param eventLocation the eventLocation to set
     */
    public void setEventLocation( String eventLocation )
    {
        this.eventLocation = eventLocation;
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
     * @return the maxEventSeats
     */
    public Integer getMaxEventSeats()
    {
        return maxEventSeats;
    }

    /**
     * @param maxEventSeats the maxEventSeats to set
     */
    public void setMaxEventSeats( Integer maxEventSeats )
    {
        this.maxEventSeats = maxEventSeats;
    }

    /**
     * @return the reservedSeats
     */
    public Integer getReservedSeats()
    {
        return reservedSeats;
    }

    /**
     * @return whether reservedSeats could be incremented
     */
    public boolean incrementReservedSeats()
    {
        if ( !isFull() )
        {
            ++reservedSeats;
            return true;
        }
        else
            return false;
    }

    /**
     * @param reservedSeats the reservedSeats to set
     */
    public void setReservedSeats( Integer reservedSeats )
    {
        this.reservedSeats = reservedSeats;
    }

    /**
     * @return the isFull
     */
    public boolean isFull()
    {
        return reservedSeats >= maxEventSeats;
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
        result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
        result = prime * result + ((eventDisplay == null) ? 0 : eventDisplay.hashCode());
        result = prime * result + ((eventLocation == null) ? 0 : eventLocation.hashCode());
        result = prime * result + ((leader == null) ? 0 : leader.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (isFull() ? 1231 : 1237);
        result = prime * result + ((maxEventSeats == null) ? 0 : maxEventSeats.hashCode());
        result = prime * result + ((reservedSeats == null) ? 0 : reservedSeats.hashCode());
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
        Event other = (Event) obj;
        if ( eventDate == null )
        {
            if ( other.eventDate != null )
                return false;
        }
        else if ( !eventDate.equals( other.eventDate ) )
            return false;
        if ( eventDisplay == null )
        {
            if ( other.eventDisplay != null )
                return false;
        }
        else if ( !eventDisplay.equals( other.eventDisplay ) )
            return false;
        if ( eventLocation == null )
        {
            if ( other.eventLocation != null )
                return false;
        }
        else if ( !eventLocation.equals( other.eventLocation ) )
            return false;
        if ( leader == null )
        {
            if ( other.leader != null )
                return false;
        }
        else if ( !leader.equals( other.leader ) )
            return false;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        if ( isFull() != other.isFull() )
            return false;
        if ( maxEventSeats == null )
        {
            if ( other.maxEventSeats != null )
                return false;
        }
        else if ( !maxEventSeats.equals( other.maxEventSeats ) )
            return false;
        if ( reservedSeats == null )
        {
            if ( other.reservedSeats != null )
                return false;
        }
        else if ( !reservedSeats.equals( other.reservedSeats ) )
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
        return "Event [id=" + id + ", eventDate=" + eventDate + ", eventDisplay=" + eventDisplay + ", eventLocation="
                        + eventLocation + ", leader=" + leader + ", maxEventSeats=" + maxEventSeats + ", reservedSeats="
                        + reservedSeats + ", isFull=" + isFull() + "]";
    }
}
