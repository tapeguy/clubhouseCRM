package edu.fhsu.csci466.clubhouse.crm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import edu.fhsu.csci466.clubhouse.crm.service.model.services.Credential;
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
    private PasswordEncoder      encoder;

    private MemberService        service;

    /**
     * 
     */
    @Before
    public void before()
    {
        service = new JPAMemberService( memberRepo, credRepo, encoder );
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
        assertTrue( service.addMember( TestUtil.buildMember( 1001L ) ) );
        verify( credRepo ).save( any( Credential.class ) );
    }

    /**
     * Test adding member. Member has no credential, so cred should not have interaction.
     */
    @Test
    public void testAddMemberNullCredential()
    {
        Member m = TestUtil.buildMember( 1001L );
        m.setCredential( null );
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
}
