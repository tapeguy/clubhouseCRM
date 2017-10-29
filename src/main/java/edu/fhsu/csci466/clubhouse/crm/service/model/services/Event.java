package edu.fhsu.csci466.clubhouse.crm.service.model.services;

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.ManyToOne;

import org.springframework.hateoas.ResourceSupport;

import edu.fhsu.csci466.clubhouse.crm.service.model.Leader;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author ss047890
 *
 */
@Entity
public class Event extends ResourceSupport implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1640027737818053147L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              eventId;

    private Timestamp         eventDateTime;

    private String            display;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "leader_id" )
    private Leader            leader;

    private String            eventLocation;

    private Integer           maxEventSeats;

    private Integer           reservedSeats;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "member_event_rel", joinColumns = @JoinColumn( name = "event_id" ), inverseJoinColumns = @JoinColumn( name = "member_id" ) )
    private List<Member>      members;

    /**
     * @return the id
     */
    public Long getEventId()
    {
        return eventId;
    }

    /**
     * @param id the id to set
     */
    public void setEventId( Long id )
    {
        this.eventId = id;
    }

    /**
     * @return the eventDateTime
     */
    public Timestamp getEventDateTime()
    {
        return eventDateTime;
    }

    /**
     * @param eventDateTime the eventDate to set
     */
    public void setEventDateTIme( Timestamp eventDateTime )
    {
        this.eventDateTime = eventDateTime;
    }

    /**
     * @return the display
     */
    public String getDisplay()
    {
        return display;
    }

    /**
     * @param display the eventDisplay to set
     */
    public void setDisplay( String display )
    {
        this.display = display;
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

    /**
     * @return the members
     */
    public List<Member> getMembers()
    {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers( List<Member> members )
    {
        this.members = members;
    }

    /**
     * @param eventDateTime the eventDateTime to set
     */
    public void setEventDateTime( Timestamp eventDateTime )
    {
        this.eventDateTime = eventDateTime;
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
        int result = super.hashCode();
        result = prime * result + ((display == null) ? 0 : display.hashCode());
        result = prime * result + ((eventDateTime == null) ? 0 : eventDateTime.hashCode());
        result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
        result = prime * result + ((eventLocation == null) ? 0 : eventLocation.hashCode());
        result = prime * result + ((leader == null) ? 0 : leader.hashCode());
        result = prime * result + ((maxEventSeats == null) ? 0 : maxEventSeats.hashCode());
        result = prime * result + ((members == null) ? 0 : members.hashCode());
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
        if ( !super.equals( obj ) )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Event other = (Event) obj;
        if ( display == null )
        {
            if ( other.display != null )
                return false;
        }
        else if ( !display.equals( other.display ) )
            return false;
        if ( eventDateTime == null )
        {
            if ( other.eventDateTime != null )
                return false;
        }
        else if ( !eventDateTime.equals( other.eventDateTime ) )
            return false;
        if ( eventId == null )
        {
            if ( other.eventId != null )
                return false;
        }
        else if ( !eventId.equals( other.eventId ) )
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
        if ( maxEventSeats == null )
        {
            if ( other.maxEventSeats != null )
                return false;
        }
        else if ( !maxEventSeats.equals( other.maxEventSeats ) )
            return false;
        if ( members == null )
        {
            if ( other.members != null )
                return false;
        }
        else if ( !members.equals( other.members ) )
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
        return "Event [id=" + eventId + ", eventDate=" + eventDateTime + ", eventDisplay=" + display
                        + ", eventLocation=" + eventLocation + ", leader=" + leader + ", maxEventSeats=" + maxEventSeats
                        + ", reservedSeats=" + reservedSeats + ", isFull=" + isFull() + "]";
    }
}
