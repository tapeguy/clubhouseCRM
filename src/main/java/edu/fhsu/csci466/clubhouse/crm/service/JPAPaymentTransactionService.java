package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentTransaction;
import edu.fhsu.csci466.clubhouse.crm.service.repo.PaymentTransactionRepository;

/**
 * @author amcatalano@mail.fhsu.edu
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPAPaymentTransactionService implements PaymentTransactionService
{
    private final PaymentTransactionRepository paymentTransactionRepo;

    /**
     * @param paymentTransactionRepo
     */
    @Autowired
    public JPAPaymentTransactionService ( PaymentTransactionRepository paymentTransactionRepo )
    {
        this.paymentTransactionRepo = paymentTransactionRepo;
    }

    @Override
    public void addPaymentTransaction( final PaymentTransaction paymentTransaction )
    {
        paymentTransactionRepo.save( paymentTransaction );
    }

    @Override
    public List<PaymentTransaction> getPaymentTransactions()
    {
        List<PaymentTransaction> paymentTransactions = paymentTransactionRepo.findAll();
        return paymentTransactions;
    }

    @Override
    public PaymentTransaction getPaymentTransaction( final Long id )
    {
        return paymentTransactionRepo.findOne( id );
    }
}
