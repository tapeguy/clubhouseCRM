package edu.fhsu.csci466.clubhouse.crm.model;

import java.io.Serializable;

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
public class Member implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 8636031629593349291L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            name;

    private Long              accountNumber;

    private PaymentPlan       paymentPlan;

    private String            membershipPlan;

    private Boolean           isAdmin;

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
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /**
     * @return the accountNumber
     */
    public Long getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber( Long accountNumber )
    {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the membershipPlan
     */
    public String getMembershipPlan()
    {
        return membershipPlan;
    }

    /**
     * @param membershipPlan the membershipPlan to set
     */
    public void setMembershipPlan( String membershipPlan )
    {
        this.membershipPlan = membershipPlan;
    }

    /**
     * @return the isAdmin
     */
    public Boolean getIsAdmin()
    {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin( Boolean isAdmin )
    {
        this.isAdmin = isAdmin;
    }
}
