package edu.fhsu.csci466.clubhouse.crm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.repo.MemberRepository;

/**
 * @author scottKC
 *
 */
@RunWith( SpringRunner.class )
@DataJpaTest
public class MemberRepoTest
{
    private static final Long   BART_ID     = 4L;
    private static final String BART        = "Bart Simpson";
    private static final String BART_USER   = "user2";
    private static final Long   SIMPSONS_ID = 1L;

    @Autowired
    private MemberRepository    repo;

    /**
     * 8 members are seeded to the db at startup. Expect repo should return 8.
     */
    @Test
    public void testFindAll()
    {
        List<Member> members = repo.findAll();
        assertEquals( 8, members.size() );
        assertEquals( repo.count(), members.size() );
    }

    /**
     * should find member by id, Bart Simpson
     */
    @Test
    public void testFindOneById()
    {
        Member m = repo.findOne( BART_ID );
        assertEquals( BART_ID, m.getMemberId() );
        assertEquals( BART, m.getName() );
        assertEquals( BART_USER, m.getCredential().getUserName() );
        assertEquals( SIMPSONS_ID, m.getFamily().getFamilyId() );
    }

    /**
     * should not find member
     */
    @Test
    public void testFindOneByIdNotFound()
    {
        Member m = repo.findOne( 42L );
        assertNull( m );
    }

    /**
     * should find bart simpson by his credential username, user2
     */
    @Test
    public void testFindByCredentialUserName()
    {
        Member m = repo.findByCredentialUserName( BART_USER );
        assertEquals( BART_ID, m.getMemberId() );
        assertEquals( BART, m.getName() );
        assertEquals( BART_USER, m.getCredential().getUserName() );
        assertEquals( SIMPSONS_ID, m.getFamily().getFamilyId() );
    }

    /**
     * should not find member
     */
    @Test
    public void testFindByCredentialUserNameNotFound()
    {
        String userName = "Devin Nuhl";
        Member m = repo.findByCredentialUserName( userName );
        assertNull( m );
    }

    /**
     * bart should exist
     */
    @Test
    public void testExists()
    {
        assertTrue( repo.exists( BART_ID ) );
    }

    /**
     * user id 1001L is having an existential crisis
     */
    @Test
    public void testExistsNotFound()
    {
        assertFalse( repo.exists( 1001L ) );
    }

    /**
     * Check that homer exists, delete him, then check that he does not exist
     */
    @Test
    public void testDelete()
    {
        Long homerId = 7L;

        assertTrue( repo.exists( homerId ) );
        repo.delete( homerId );
    }

    /**
     * Ensure expected exception is thrown if delete is misused
     */
    @Test( expected = InvalidDataAccessApiUsageException.class )
    public void testDeleteNullId()
    {
        Long id = null;
        repo.delete( id );
    }

    /**
     * save new member to db
     */
    public void testSaveInsert()
    {
        Member memberToSave = TestUtil.getMember( 999L );
        repo.save( memberToSave );
        Member memberToFind = repo.findOne( 999L );
        assertEquals( memberToSave, memberToFind );
    }

    /**
     * Save a record, update the email field, check if db record received update
     */
    public void testSaveUpdate()
    {
        Member memberToSave = TestUtil.getMember( 999L );
        repo.save( memberToSave );
        Member memberToFind = repo.findOne( 999L );
        assertEquals( memberToSave, memberToFind );

        memberToSave.setEmail( "neue@email.com" );
        repo.save( memberToSave );
        memberToFind = repo.findOne( 999L );
        assertEquals( memberToSave, memberToFind );
    }
}
