package edu.fhsu.csci466.clubhouse.crm.service.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Family;
import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Team;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Account;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Credential;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Event;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentPlan;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
@DiscriminatorColumn( name = "member_type" )
@DiscriminatorValue( "MEMBER" )
public class Member extends ResourceSupport implements Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = 4926978862891959688L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              memberId;

    private String            name;

    private String            email;

    @Column( name = "member_type" )
    @Enumerated( EnumType.STRING )
    private MemberType        memberType;

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

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "member_team_rel", joinColumns = @JoinColumn( name = "member_id" ), inverseJoinColumns = @JoinColumn( name = "team_id" ) )
    private List<Team>        memberTeams;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "member_event_rel", joinColumns = @JoinColumn( name = "member_id" ), inverseJoinColumns = @JoinColumn( name = "event_id" ) )
    private List<Event>       memberEvents;

    /**
     * @return whether member is an admin, i.e. a leader
     */
    public boolean isLeaderAdmin()
    {
        if ( this instanceof Leader )
        {
            Leader leader = (Leader) this;
            return leader.isAdmin();
        }
        return false;
    }

    /**
     * @return the id
     */
    public Long getMemberId()
    {
        return memberId;
    }

    /**
     * @param id the id to set
     */
    public void setMemberId( Long id )
    {
        this.memberId = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name )
    {
        this.name = name;
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
     * @return the type
     */
    public MemberType getMemberType()
    {
        return memberType;
    }

    /**
     * @param type the type to set
     */
    public void setMemberType( MemberType type )
    {
        this.memberType = type;
    }

    /**
     * @return the type
     */
    public MemberType getType()
    {
        return getMemberType();
    }

    /**
     * @param type the type to set
     */
    public void setType( MemberType type )
    {
        setMemberType( type );
    }

    /**
     * @return the type
     */
    @Transient // Not persisted in the database
    public String getTypeString()
    {
        return this.getType().toString();
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
    @JsonIgnore // Ignore for now to avoid circular links
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
     * @return the memberTeams
     */
    public List<Team> getMemberTeams()
    {
        return memberTeams;
    }

    /**
     * @param memberTeams the memberTeams to set
     */
    public void setMemberTeams( List<Team> memberTeams )
    {
        this.memberTeams = memberTeams;
    }

    /**
     * @return the memberEvents
     */
    public List<Event> getMemberEvents()
    {
        return memberEvents;
    }

    /**
     * @param memberEvents the memberEvents to set
     */
    public void setMemberEvents( List<Event> memberEvents )
    {
        this.memberEvents = memberEvents;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 19890919;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result + ((credential == null) ? 0 : credential.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
        result = prime * result + ((family == null) ? 0 : family.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((paymentPlan == null) ? 0 : paymentPlan.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Member other = (Member) obj;
        if ( account == null )
        {
            if ( other.account != null )
                return false;
        }
        else if ( !account.equals( other.account ) )
            return false;
        if ( credential == null )
        {
            if ( other.credential != null )
                return false;
        }
        else if ( !credential.equals( other.credential ) )
            return false;
        if ( email == null )
        {
            if ( other.email != null )
                return false;
        }
        else if ( !email.equals( other.email ) )
            return false;
        if ( memberId == null )
        {
            if ( other.memberId != null )
                return false;
        }
        else if ( !memberId.equals( other.memberId ) )
            return false;
        if ( memberEvents == null )
        {
            if ( other.memberEvents != null )
                return false;
        }
        else if ( !memberEvents.equals( other.memberEvents ) )
            return false;
        if ( family == null )
        {
            if ( other.family != null )
                return false;
        }
        else if ( !family.equals( other.family ) )
            return false;
        if ( memberTeams == null )
        {
            if ( other.memberTeams != null )
                return false;
        }
        else if ( !memberTeams.equals( other.memberTeams ) )
            return false;
        if ( name == null )
        {
            if ( other.name != null )
                return false;
        }
        else if ( !name.equals( other.name ) )
            return false;
        if ( paymentPlan == null )
        {
            if ( other.paymentPlan != null )
                return false;
        }
        else if ( !paymentPlan.equals( other.paymentPlan ) )
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Member [id=" + memberId + ", name=" + name + ", email=" + email + ", credential=" + credential
                        + ", account=" + account + ", paymentPlan=" + paymentPlan + ", family=" + family
                        + ", memberTeams=" + memberTeams + ", memberEvents=" + memberEvents + "]";
    }
}
