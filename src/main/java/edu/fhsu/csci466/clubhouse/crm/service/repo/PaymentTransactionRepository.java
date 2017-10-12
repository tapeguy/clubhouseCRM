package edu.fhsu.csci466.clubhouse.crm.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentTransaction;

/**
 * @author amcatalano@mail.fhsu.edu
 *
 *         A Spring Data JPA PaymentTransaction repository. An implementation of
 *         this interface gets auto-generated--no need to implement it by hand.
 */
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
}
