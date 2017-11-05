package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentPlan;
import edu.fhsu.csci466.clubhouse.crm.service.repo.PaymentPlanRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPAPaymentPlanService implements PaymentPlanService
{
    private final PaymentPlanRepository paymentPlanRepo;

    /**
     * @param eventRepo
     */
    @Autowired
    public JPAPaymentPlanService ( PaymentPlanRepository paymentPlanRepo )
    {
        this.paymentPlanRepo = paymentPlanRepo;
    }

    @Override
    public boolean addPaymentPlan ( PaymentPlan paymentPlan )
    {
        if ( paymentPlan != null )
        {
            paymentPlanRepo.save( paymentPlan );
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePaymentPlan ( final Long id )
    {
        if ( id != null && paymentPlanRepo.exists( id ) )
        {
            paymentPlanRepo.delete( id );
            return true;
        }
        return false;
    }

    @Override
    public List<PaymentPlan> getPaymentPlans()
    {
        List<PaymentPlan> plans = paymentPlanRepo.findAll();
        return plans;
    }

    @Override
    public PaymentPlan getPaymentPlan ( Long id )
    {
        return paymentPlanRepo.findOne( id );
    }
}
