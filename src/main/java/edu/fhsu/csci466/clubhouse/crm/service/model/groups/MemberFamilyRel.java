package edu.fhsu.csci466.clubhouse.crm.service.model.groups;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author ss047890
 *
 */
@Entity
public class MemberFamilyRel implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -3998713292318738500L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "member_id" )
    private Member            member;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "family_id" )
    private Family            family;

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
     * @return the family
     */
    public Family getFamily()
    {
        return family;
    }

    /**
     * @param family the family to set
     */
    public void setFamily( Family family )
    {
        this.family = family;
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
        result = prime * result + ((family == null) ? 0 : family.hashCode());
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
        MemberFamilyRel other = (MemberFamilyRel) obj;
        if ( family == null )
        {
            if ( other.family != null )
                return false;
        }
        else if ( !family.equals( other.family ) )
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
        return "MemberFamilyRel [id=" + id + ", member=" + member + ", family=" + family + "]";
    }
}
