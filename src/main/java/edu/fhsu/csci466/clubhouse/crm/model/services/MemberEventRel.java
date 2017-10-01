package edu.fhsu.csci466.clubhouse.crm.model.services;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.model.Member;

/**
 * @author ss047890
 *
 */
public class MemberEventRel implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 5249249392642353020L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "member_id" )
    private Member            member;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinColumn( name = "event_id" )
    private Event             event;

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
     * @return the member
     */
    public Member getMember()
    {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember( Member member )
    {
        this.member = member;
    }

    /**
     * @return the event
     */
    public Event getEvent()
    {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent( Event event )
    {
        this.event = event;
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
        result = prime * result + ((event == null) ? 0 : event.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((member == null) ? 0 : member.hashCode());
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
        MemberEventRel other = (MemberEventRel) obj;
        if ( event == null )
        {
            if ( other.event != null )
                return false;
        }
        else if ( !event.equals( other.event ) )
            return false;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        if ( member == null )
        {
            if ( other.member != null )
                return false;
        }
        else if ( !member.equals( other.member ) )
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
        return "EventMemberRel [id=" + id + ", member=" + member + ", event=" + event + "]";
    }
}
