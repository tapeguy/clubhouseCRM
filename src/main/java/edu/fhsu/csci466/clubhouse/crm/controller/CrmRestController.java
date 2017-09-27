package edu.fhsu.csci466.clubhouse.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.User;
import edu.fhsu.csci466.clubhouse.crm.service.UserService;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class CrmRestController
{
    @Autowired
    UserService service;

    /**
     * @param lastName
     * @return list of all users
     */
    @GetMapping( value = "/user", produces = MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody List<User> getUsers()
    {
        return service.getUsers();
    }

    /**
     * @param user
     * @return response entity the status to return
     */
    @PostMapping( value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<User> addUser( @RequestBody User user )
    {
        service.addUser( user );
        return new ResponseEntity<>( user, HttpStatus.OK );
    }

    /**
     * @param id
     * @return user
     */
    @GetMapping( value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody User getUser( @PathVariable Long id )
    {
        return service.getUser( id );
    }

    /**
     * @param id
     */
    @DeleteMapping( value = "/user/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus( HttpStatus.OK )
    public void deleteUser( @PathVariable Long id )
    {
        service.delete( id );
    }
}
