package edu.fhsu.csci466.clubhouse.crm.service.model.services;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.hateoas.ResourceSupport;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author amcatalano@mail.fhsu.edu
 *
 */
@Entity
public class PaymentTransaction extends ResourceSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8299245387259322370L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private Long paymentTransactionId;

	private Timestamp paymentTransactionDateTime;

	private String display;

	private Double paymentAmount;

	private String paymentType;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member;

	/**
	 * @return the paymentTransactionId
	 */
	public Long getPaymentTransactionId() {
		return paymentTransactionId;
	}

	/**
	 * @param paymentTransactionId
	 *            the paymentTransactionId to set
	 */
	public void setPaymentTransactionId(Long paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}

	/**
	 * @return the paymentTransactionDateTime
	 */
	public Timestamp getPaymentTransactionDateTime() {
		return paymentTransactionDateTime;
	}

	/**
	 * @param paymentTransactionDateTime
	 *            the paymentTransactionDateTime to set
	 */
	public void setPaymentTransactionDateTime(Timestamp paymentTransactionDateTime) {
		this.paymentTransactionDateTime = paymentTransactionDateTime;
	}

	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display
	 *            the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * @return the paymentAmount
	 */
	public Double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount
	 *            the paymentAmount to set
	 */
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType
	 *            the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member
	 *            the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((paymentAmount == null) ? 0 : paymentAmount.hashCode());
		result = prime * result + ((paymentTransactionDateTime == null) ? 0 : paymentTransactionDateTime.hashCode());
		result = prime * result + ((paymentTransactionId == null) ? 0 : paymentTransactionId.hashCode());
		result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentTransaction other = (PaymentTransaction) obj;
		if (display == null) {
			if (other.display != null)
				return false;
		} else if (!display.equals(other.display))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (paymentAmount == null) {
			if (other.paymentAmount != null)
				return false;
		} else if (!paymentAmount.equals(other.paymentAmount))
			return false;
		if (paymentTransactionDateTime == null) {
			if (other.paymentTransactionDateTime != null)
				return false;
		} else if (!paymentTransactionDateTime.equals(other.paymentTransactionDateTime))
			return false;
		if (paymentTransactionId == null) {
			if (other.paymentTransactionId != null)
				return false;
		} else if (!paymentTransactionId.equals(other.paymentTransactionId))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentTransaction [paymentTransactionId=" + paymentTransactionId + ", paymentTransactionDateTime="
				+ paymentTransactionDateTime + ", display=" + display + ", paymentAmount=" + paymentAmount
				+ ", paymentType=" + paymentType + ", member=" + member + "]";
	}

}
