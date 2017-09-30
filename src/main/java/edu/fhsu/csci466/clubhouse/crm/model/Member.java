package edu.fhsu.csci466.clubhouse.crm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.model.groups.Family;
import edu.fhsu.csci466.clubhouse.crm.model.groups.Team;
import edu.fhsu.csci466.clubhouse.crm.model.services.Account;
import edu.fhsu.csci466.clubhouse.crm.model.services.Credential;
import edu.fhsu.csci466.clubhouse.crm.model.services.Event;
import edu.fhsu.csci466.clubhouse.crm.model.services.PaymentPlan;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Member implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 2475596850971781832L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            email;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "credential_id" )
    private Credential        credential;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "account_id" )
    private Account           account;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "payment_plan_id" )
    private PaymentPlan       paymentPlan;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "family_id" )
    private Family            family;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "team_id" )
    private Team              team;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinColumn( name = "family_id" )
    private Set<Event>        events;

    private Boolean           isAdmin;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( Long id )
    {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail( String email )
    {
        this.email = email;
    }

    /**
     * @return the credential
     */
    public Credential getCredential()
    {
        return credential;
    }

    /**
     * @param credential the credential to set
     */
    public void setCredential( Credential credential )
    {
        this.credential = credential;
    }

    /**
     * @return the account
     */
    public Account getAccount()
    {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount( Account account )
    {
        this.account = account;
    }

    /**
     * @return the paymentPlan
     */
    public PaymentPlan getPaymentPlan()
    {
        return paymentPlan;
    }

    /**
     * @param paymentPlan the paymentPlan to set
     */
    public void setPaymentPlan( PaymentPlan paymentPlan )
    {
        this.paymentPlan = paymentPlan;
    }

    /**
     * @return the family
     */
    public Family getFamily()
    {
        return family;
    }

    /**
     * @param family the family to set
     */
    public void setFamily( Family family )
    {
        this.family = family;
    }

    /**
     * @return the team
     */
    public Team getTeam()
    {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam( Team team )
    {
        this.team = team;
    }

    /**
     * @return the events
     */
    public Set<Event> getEvents()
    {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents( Set<Event> events )
    {
        this.events = events;
    }

    /**
     * @return the isAdmin
     */
    public Boolean getIsAdmin()
    {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin( Boolean isAdmin )
    {
        this.isAdmin = isAdmin;
    }
}
