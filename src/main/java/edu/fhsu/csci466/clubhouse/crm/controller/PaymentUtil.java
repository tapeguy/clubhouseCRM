package edu.fhsu.csci466.clubhouse.crm.controller;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Account;

/**
 * @author ss047890
 *
 */
public class PaymentUtil {
	/**
	 * @param member
	 * @param payment
	 * @return a new member object w/ payment set
	 */
	public static Member makePayment(final Member member, final Double payment) {
		if (member == null)
			throw new IllegalArgumentException("member cannot be null");
		Member m = member;
		Account a = m.getAccount();
		a.setBalance(a.getBalance() - payment);
		m.setAccount(a);
		return m;
	}

	/**
	 * @param payment
	 * @return whether payment is valid
	 */
	public static boolean isValidPayment(final Double payment) {
		return payment > 0;
	}
}
