package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

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

import edu.fhsu.csci466.clubhouse.crm.service.PaymentTransactionService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentTransaction;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class PaymentTransactionRestController
{
    @Autowired
    PaymentTransactionService service;

    /**
     * @param lastName
     * @return list of all Event
     */
    @GetMapping( value = "/paymentTransaction", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<PaymentTransaction>> getPaymentTransactions()
    {
        EntityList<PaymentTransaction> list = new EntityList<> ( service.getPaymentTransactions() );
        for ( PaymentTransaction paymentTransaction : list.getEntities() )
        {
        	paymentTransaction.add( linkTo(methodOn(PaymentTransactionRestController.class).getPaymentTransaction(paymentTransaction.getPaymentTransactionId())).withSelfRel() );
        }
        list.add( linkTo(methodOn(PaymentTransactionRestController.class).getPaymentTransactions()).withRel("list") );
        list.add( linkTo(methodOn(PaymentTransactionRestController.class).addPaymentTransaction(null)).withRel("add") );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param Event
     * @return response entity the status to return
     */
    @PostMapping( value = "/paymentTransaction/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<PaymentTransaction> addPaymentTransaction( @RequestBody PaymentTransaction paymentTransaction )
    {
        service.addPaymentTransaction( paymentTransaction );
        return new ResponseEntity<>( paymentTransaction, HttpStatus.OK );
    }

    /**
     * @param id
     * @return Event
     */
    @GetMapping( value = "/paymentTransaction/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<PaymentTransaction> getPaymentTransaction( @PathVariable Long id )
    {
    	PaymentTransaction PaymentTransaction = service.getPaymentTransaction( id );
    	PaymentTransaction.add( linkTo(methodOn(EventRestController.class).getEvent(id)).withSelfRel() );
        return new ResponseEntity<>( PaymentTransaction, HttpStatus.OK );
    }
}
