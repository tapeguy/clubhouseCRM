package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentPlan;

/**
 * @author ss047890
 *
 */
public interface PaymentPlanService
{
    /**
     * @param paymentPlan
     */
    public boolean addPaymentPlan( final PaymentPlan paymentPlan );

    /**
     * @param paymentPlan
     */
    public boolean deletePaymentPlan( final Long id );

    /**
     * @return List of paymentPlan
     */
    public List<PaymentPlan> getPaymentPlans();

    /**
     * @param id
     * @return paymentPlan
     */
    public PaymentPlan getPaymentPlan( final Long id );
}
