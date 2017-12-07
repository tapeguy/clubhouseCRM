package edu.fhsu.csci466.clubhouse.crm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import edu.fhsu.csci466.clubhouse.crm.service.JPAMemberService;
import edu.fhsu.csci466.clubhouse.crm.service.MemberService;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Account;
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Credential;
import edu.fhsu.csci466.clubhouse.crm.service.repo.AccountRepository;
import edu.fhsu.csci466.clubhouse.crm.service.repo.CredentialRepository;
import edu.fhsu.csci466.clubhouse.crm.service.repo.MemberRepository;

/**
 * @author scottkc
 *
 */
@RunWith( SpringRunner.class )
public class MemberServiceTest
{
    @MockBean
    private MemberRepository     memberRepo;

    @MockBean
    private CredentialRepository credRepo;

    @MockBean
    private AccountRepository    accountRepo;

    @MockBean
    private PasswordEncoder      encoder;

    private MemberService        service;

    /**
     * 
     */
    @Before
    public void before()
    {
        service = new JPAMemberService( memberRepo, credRepo, accountRepo, encoder );
    }

    /**
     * Tests service interaction w/ repo
     */
    @Test
    public void testGetMembers()
    {
        Mockito.when( memberRepo.findAll() ).thenReturn( TestUtil.getMembers() );
        assertEquals( TestUtil.MEMBER_COUNT, service.getMembers().size() );
    }

    /**
     * Test adding member. Member has credential, so cred should have interaction.
     */
    @Test
    public void testAddMember()
    {
        assertTrue( service.addMember( TestUtil.getMember( 1001L ) ) );
        verify( credRepo ).save( any( Credential.class ) );
    }

    /**
     * Test adding member. Member has no credential, so cred should not have interaction.
     */
    @Test
    public void testAddMemberNullCredential()
    {
        Member m = TestUtil.getMemberNoCredential( 1L );
        assertTrue( service.addMember( m ) );
        verify( credRepo, never() ).save( any( Credential.class ) );
    }

    /**
     * Tests service returns false on adding a null member
     */
    @Test
    public void testAddMemberNullMember()
    {
        assertFalse( service.addMember( null ) );
    }

    /**
     * Tests service returns returns member by id
     */
    @Test
    public void testGetMember()
    {
        Long id = 1001L;
        Mockito.when( memberRepo.findOne( id ) ).thenReturn( TestUtil.getMember( id ) );
        Member m = service.getMember( id );
        assertEquals( id, m.getMemberId() );
    }

    /**
     * Tests service returns false on adding a null member
     */
    @Test
    public void testGetMemberByNameExists()
    {
        String userName = "user1";
        Long id = 1L;
        Mockito.when( memberRepo.findByCredentialUserName( userName ) ).thenReturn( TestUtil.getMember( id ) );
        Member m = service.getMemberByName( userName );
        assertEquals( id, m.getMemberId() );
        assertEquals( userName, m.getCredential().getUserName() );
    }

    /**
     * Tests service returns false on adding a null member
     */
    @Test
    public void testGetMemberByNameDoesNOTExist()
    {
        String userName = "/dev/null";
        Mockito.when( memberRepo.findByCredentialUserName( userName ) ).thenReturn( null );
        assertNull( service.getMemberByName( userName ) );
    }

    /**
     * Tests member update
     */
    @Test
    public void testUpdateMember()
    {
        Member m = new Member();
        m.setMemberId( 1001L );
        Mockito.when( memberRepo.exists( 1001L ) ).thenReturn( true );
        assertTrue( service.updateMember( m ) );
        verify( memberRepo ).save( m );
    }

    /**
     * Tests update on member that does not exist
     */
    @Test
    public void testUpdateMemberDoesNOTExist()
    {
        Member m = new Member();
        m.setMemberId( 1001L );
        Mockito.when( memberRepo.exists( 1001L ) ).thenReturn( false );
        assertFalse( service.updateMember( m ) );
        verify( memberRepo, never() ).save( any( Member.class ) );
        verify( credRepo, never() ).save( any( Credential.class ) );
    }

    /**
     * Tests update on null member
     */
    @Test
    public void testUpdateMemberIsNull()
    {
        assertFalse( service.updateMember( null ) );
        verify( memberRepo, never() ).save( any( Member.class ) );
        verify( credRepo, never() ).save( any( Credential.class ) );
    }

    /**
     * Tests updating member password
     */
    @Test
    public void testUpdateMemberPassword()
    {
        Long id = 1L;
        Member m = TestUtil.getMember( id );
        Mockito.when( memberRepo.findOne( id ) ).thenReturn( m );
        assertTrue( service.updateMemberPassword( id, "neue" ) );
        verify( memberRepo ).save( m );
        verify( credRepo ).save( any( Credential.class ) );
    }

    /**
     * Tests update on member that does not exist
     */
    @Test
    public void testUpdateMemberPasswordMemberNotFound()
    {
        Long id = 1L;
        Mockito.when( memberRepo.findOne( id ) ).thenReturn( null );
        assertFalse( service.updateMemberPassword( id, "neue" ) );
        verify( memberRepo, never() ).save( any( Member.class ) );
        verify( credRepo, never() ).save( any( Credential.class ) );
    }

    /**
     * Tests update against member with no credential
     */
    @Test
    public void testUpdateMemberPasswordNoCredential()
    {
        Long id = 1L;
        Mockito.when( memberRepo.findOne( id ) ).thenReturn( null );
        assertFalse( service.updateMemberPassword( id, "neue" ) );
        verify( memberRepo, never() ).save( any( Member.class ) );
        verify( credRepo, never() ).save( any( Credential.class ) );
    }

    /**
     * Tests member deletion
     */
    @Test
    public void testDeleteMember()
    {
        Long id = 1001L;
        Member m = TestUtil.getMember( id );
        Mockito.when( memberRepo.exists( id ) ).thenReturn( true );
        assertTrue( service.deleteMember( m ) );
        verify( memberRepo ).delete( m );
    }

    /**
     * Tests member deletion
     */
    @Test
    public void testDeleteMemberDoesNOTExist()
    {
        Long id = 1001L;
        Member m = TestUtil.getMember( id );
        Mockito.when( memberRepo.exists( id ) ).thenReturn( false );
        assertFalse( service.deleteMember( m ) );
        verify( memberRepo, never() ).delete( m );
    }

    /**
     * Takes making payment
     */
    @Test
    public void testMakePayment()
    {
        Long id = 1L;
        Member m = TestUtil.getMember( id );
        Mockito.when( memberRepo.findOne( id ) ).thenReturn( m );
        assertTrue( service.makePayment( id, 10.0 ) );
        verify( memberRepo ).save( m );
        verify( accountRepo ).save( any( Account.class ) );
    }

    /**
     * Takes making payment
     */
    @Test
    public void testMakePaymentInvalidPayment()
    {
        Long id = 1L;
        Member m = TestUtil.getMember( id );
        Mockito.when( memberRepo.findOne( id ) ).thenReturn( m );
        assertFalse( service.makePayment( id, -5.1 ) );
        verify( memberRepo, never() ).save( any( Member.class ) );
        verify( accountRepo, never() ).save( any( Account.class ) );
    }

    /**
     * Takes making payment
     */
    @Test
    public void testMakePaymentMemberNotFound()
    {
        Long id = 1L;
        Mockito.when( memberRepo.findOne( id ) ).thenReturn( null );
        assertFalse( service.makePayment( id, 10.0 ) );
        verify( memberRepo, never() ).save( any( Member.class ) );
        verify( accountRepo, never() ).save( any( Account.class ) );
    }
}
