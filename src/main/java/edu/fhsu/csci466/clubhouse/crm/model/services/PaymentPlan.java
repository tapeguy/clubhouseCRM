package edu.fhsu.csci466.clubhouse.crm.model.services;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class PaymentPlan implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            display;

    private Integer           billingCycleInWeeks;

    private Double            fee;

    @OneToMany( fetch = FetchType.LAZY )
    @JoinColumn( name = "member_id" )
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

    /**
     * @return the billingCycleInWeeks
     */
    public Integer getBillingCycleInWeeks()
    {
        return billingCycleInWeeks;
    }

    /**
     * @param billingCycleInWeeks the billingCycleInWeeks to set
     */
    public void setBillingCycleInWeeks( Integer billingCycleInWeeks )
    {
        this.billingCycleInWeeks = billingCycleInWeeks;
    }

    /**
     * @return the fee
     */
    public Double getFee()
    {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee( Double fee )
    {
        this.fee = fee;
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
