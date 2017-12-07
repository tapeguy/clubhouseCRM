package edu.fhsu.csci466.clubhouse.crm;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.fhsu.csci466.clubhouse.crm.controller.MemberRestController;
import edu.fhsu.csci466.clubhouse.crm.service.MemberService;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author scottKc
 *
 */
@RunWith( SpringRunner.class )
@WebMvcTest( MemberRestController.class )
public class MemberControllerTest
{
    @Autowired
    private MockMvc       mvc;

    @MockBean
    private MemberService service;

    /**
     * @throws Exception
     */
    @Test
    public void testGetMembers() throws Exception
    {
        String expected = new String( Files.readAllBytes( Paths.get( "src/main/resources/member.json" ) ) );
        Mockito.when( this.service.getMembers() ).thenReturn( TestUtil.getMembers() );

        this.mvc.perform( get( "/crm/member" ).accept( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() )
                        .andExpect( content().json( expected ) );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testAddMember() throws Exception
    {
        Member m = TestUtil.getMember( 111L );
        Mockito.when( this.service.addMember( any() ) ).thenReturn( true );

        this.mvc.perform( post( "/crm/member" ).contentType( MediaType.APPLICATION_JSON )
                        .content( new ObjectMapper().writeValueAsString( m ) ) ).andExpect( status().isOk() );
    }

    /**
     * @throws Exception
     * 
     *             POST /crm/member/add
     * 
     *             Ensure I'm a teapot
     */
    @Test
    public void testAddMemberServiceFailure() throws Exception
    {
        Member m = TestUtil.getMember( 111L );
        Mockito.when( this.service.addMember( any() ) ).thenReturn( false );

        this.mvc.perform( post( "/crm/member" ).contentType( MediaType.APPLICATION_JSON )
                        .content( new ObjectMapper().writeValueAsString( m ) ) )
                        .andExpect( status().isInternalServerError() );
    }

    /**
     * GET /member/{id}
     * 
     * @throws Exception
     */
    @Test
    public void testGetMember() throws Exception
    {
        Long id = 112L;
        Member m = TestUtil.getMember( id );
        Mockito.when( this.service.getMember( id ) ).thenReturn( m );

        this.mvc.perform( get( "/crm/member/" + id ).accept( MediaType.APPLICATION_JSON ) )
                        .andExpect( status().isOk() );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testMakePayment() throws Exception
    {
        Mockito.when( this.service.makePayment( anyLong(), anyDouble() ) ).thenReturn( true );
        this.mvc.perform( put( "/crm/member/1/pay/10" ).accept( MediaType.APPLICATION_JSON ) )
                        .andExpect( status().isOk() );
    }
}
