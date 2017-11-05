package edu.fhsu.csci466.clubhouse.crm.service.model.services;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author ss047890
 *
 */
@Entity
public class Account extends ResourceSupport implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 4145295082558370786L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              accountId;

    @JsonIgnore
    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "member_id" )
    private Member            member;

    private Double            balance;

    private Double            annualClubDues;

    /**
     * no args
     */
    public Account ()
    {
    }

    /**
     * @param id
     * @param member
     * @param balance
     * @param annualClubDues
     */
    public Account ( Long id, Member member, Double balance, Double annualClubDues )
    {
        this.accountId = id;
        this.member = member;
        this.balance = balance;
        this.annualClubDues = annualClubDues;
    }

    /**
     * @return the id
     */
    public Long getAccountId()
    {
        return accountId;
    }

    /**
     * @param id the id to set
     */
    public void setAccountId( Long id )
    {
        this.accountId = id;
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
     * @return the balance
     */
    public Double getBalance()
    {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance( Double balance )
    {
        this.balance = balance;
    }

    /**
     * @return the annualClubDues
     */
    public Double getAnnualClubDues()
    {
        return annualClubDues;
    }

    /**
     * @param annualClubDues the annualClubDues to set
     */
    public void setAnnualClubDues( Double annualClubDues )
    {
        this.annualClubDues = annualClubDues;
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
        result = prime * result + ((annualClubDues == null) ? 0 : annualClubDues.hashCode());
        result = prime * result + ((balance == null) ? 0 : balance.hashCode());
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
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
        Account other = (Account) obj;
        if ( annualClubDues == null )
        {
            if ( other.annualClubDues != null )
                return false;
        }
        else if ( !annualClubDues.equals( other.annualClubDues ) )
            return false;
        if ( balance == null )
        {
            if ( other.balance != null )
                return false;
        }
        else if ( !balance.equals( other.balance ) )
            return false;
        if ( accountId == null )
        {
            if ( other.accountId != null )
                return false;
        }
        else if ( !accountId.equals( other.accountId ) )
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
        return "Account [id=" + accountId + ", member=" + member + ", balance=" + balance + ", annualClubDues="
                        + annualClubDues + "]";
    }
}
