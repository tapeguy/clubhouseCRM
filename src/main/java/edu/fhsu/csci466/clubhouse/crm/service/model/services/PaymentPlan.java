package edu.fhsu.csci466.clubhouse.crm.service.model.services;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author ss047890
 *
 */
@Entity
public class PaymentPlan extends ResourceSupport implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 8682725344697726728L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              paymentPlanId;

    private String            display;

    private Integer           billingCycleInWeeks;

    private Double            fee;

    /**
     * @return the id
     */
    public Long getPaymentPlanId()
    {
        return paymentPlanId;
    }

    /**
     * @param id the id to set
     */
    public void setPaymentPlanId( Long id )
    {
        this.paymentPlanId = id;
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
        result = prime * result + ((billingCycleInWeeks == null) ? 0 : billingCycleInWeeks.hashCode());
        result = prime * result + ((display == null) ? 0 : display.hashCode());
        result = prime * result + ((fee == null) ? 0 : fee.hashCode());
        result = prime * result + ((paymentPlanId == null) ? 0 : paymentPlanId.hashCode());
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
        PaymentPlan other = (PaymentPlan) obj;
        if ( billingCycleInWeeks == null )
        {
            if ( other.billingCycleInWeeks != null )
                return false;
        }
        else if ( !billingCycleInWeeks.equals( other.billingCycleInWeeks ) )
            return false;
        if ( display == null )
        {
            if ( other.display != null )
                return false;
        }
        else if ( !display.equals( other.display ) )
            return false;
        if ( fee == null )
        {
            if ( other.fee != null )
                return false;
        }
        else if ( !fee.equals( other.fee ) )
            return false;
        if ( paymentPlanId == null )
        {
            if ( other.paymentPlanId != null )
                return false;
        }
        else if ( !paymentPlanId.equals( other.paymentPlanId ) )
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
        return "PaymentPlan [id=" + paymentPlanId + ", display=" + display + ", billingCycleInWeeks=" + billingCycleInWeeks
                        + ", fee=" + fee + "]";
    }
}
