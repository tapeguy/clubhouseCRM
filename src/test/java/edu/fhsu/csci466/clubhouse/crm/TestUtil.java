package edu.fhsu.csci466.clubhouse.crm;

import java.util.ArrayList;
import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Account;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Credential;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.PaymentPlan;

/**
 * @author scottKC
 *
 */
public class TestUtil
{
    /**
     * the number of members generated by the getMembers method
     */
    public static int MEMBER_COUNT = 20;

    /**
     * @return a list of members
     */
    public static List<Member> getMembers()
    {
        List<Member> members = new ArrayList<>();

        for ( long i = 1; i <= MEMBER_COUNT; ++i )
        {
            members.add( getMember( i ) );
        }

        return members;
    }

    /**
     * @param i
     * @return an initialized test member
     */
    public static Member getMember( final long i )
    {
        Member m = new Member();
        m.setMemberId( i );
        m.setName( "name" + i );
        m.setEmail( "m" + i + "@email.com" );
        m.setCredential( getCredential( i ) );
        m.setAccount( getAccount( m ) );
        m.setPaymentPlan( getPaymentPlan( i ) );

        return m;
    }

    /**
     * @param i
     * @return member w/out credential
     */
    public static Member getMemberNoCredential( final long i )
    {
        Member m = getMember( i );
        m.setCredential( null );
        return m;
    }

    /**
     * @param i
     * @return credential
     */
    public static Credential getCredential( long i )
    {
        Credential c = new Credential();
        c.setCredentialId( i * 100 );
        c.setPassword( "secret" );
        c.setUserName( "user" + i );
        return c;
    }

    /**
     * @param m
     * @return account
     */
    public static Account getAccount( final Member m )
    {
        Account a = new Account();
        a.setAccountId( m.getMemberId() );
        a.setAnnualClubDues( 19.95 );
        a.setBalance( m.getMemberId() * 1.8 );
        a.setMember( m );
        return a;
    }

    /**
     * @param i
     * @return account
     */
    public static PaymentPlan getPaymentPlan( final long i )
    {
        PaymentPlan p = new PaymentPlan();
        p.setBillingCycleInWeeks( 2 );
        p.setDisplay( "PaymentPlan" );
        p.setFee( 19.95 );
        p.setPaymentPlanId( i );
        return p;
    }
}
