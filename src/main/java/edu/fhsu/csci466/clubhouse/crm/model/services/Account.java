package edu.fhsu.csci466.clubhouse.crm.model.services;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.model.Member;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ss047890
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Account implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 4145295082558370786L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "member_id" )
    private Member            member;

    private Double            balance;

    private Double            annualClubDues;

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
}
