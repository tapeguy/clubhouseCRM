package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.PaymentPlanService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentPlan;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class PaymentPlanRestController
{
    private final PaymentPlanService service;

    /**
     * @param service
     */
    @Autowired
    public PaymentPlanRestController ( PaymentPlanService service )
    {
        this.service = service;
    }

    /**
     * @return list of all payment plans
     */
    @GetMapping( value = "/paymentPlan", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<PaymentPlan>> getPaymentPlans()
    {
        EntityList<PaymentPlan> list = new EntityList<>( service.getPaymentPlans() );
        for ( PaymentPlan plan : list.getEntities() )
        {
            plan.add( linkTo( methodOn( PaymentPlanRestController.class ).getPaymentPlan( plan.getPaymentPlanId() ) )
                            .withSelfRel() );
        }
        list.add( linkTo( methodOn( PaymentPlanRestController.class ).getPaymentPlans() ).withRel( "list" ) );
        list.add( linkTo( methodOn( PaymentPlanRestController.class ).addPaymentPlan( null ) ).withRel( "add" ) );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param plan
     * @return response entity the status to return
     */
    @PostMapping( value = "/paymentPlan/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<PaymentPlan> addPaymentPlan( @RequestBody PaymentPlan plan )
    {
        service.addPaymentPlan( plan );
        return new ResponseEntity<>( plan, HttpStatus.OK );
    }

    /**
     * @param id
     * @return PaymentPlan
     */
    @GetMapping( value = "/paymentPlan/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<PaymentPlan> getPaymentPlan( @PathVariable Long id )
    {
        PaymentPlan plan = service.getPaymentPlan( id );
        plan.add( linkTo( methodOn( PaymentPlanRestController.class ).getPaymentPlan( id ) ).withSelfRel() );
        return new ResponseEntity<>( plan, HttpStatus.OK );
    }
}
