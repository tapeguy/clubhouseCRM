package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentTransaction;

/**
 * @author amcatalano@mail.fhsu.edu
 *
 */
public interface PaymentTransactionService
{
    /**
     * @param event
     */
    public void addPaymentTransaction( final PaymentTransaction paymentTransaction );

    /**
     * @return event
     */
    public List<PaymentTransaction> getPaymentTransactions();

    /**
     * @param id
     * @return event
     */
    public PaymentTransaction getPaymentTransaction( final Long id );
}
