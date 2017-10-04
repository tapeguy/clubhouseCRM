package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.FamilyService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Family;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class FamilyRestController
{
    @Autowired
    FamilyService service;

    /**
     * @param lastName
     * @return list of all Family
     */
    @GetMapping( value = "/family", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Family>> getFamilies()
    {
        EntityList<Family> list = new EntityList<> ( service.getFamilies() );
        for ( Family family : list.getEntities() )
        {
            family.add( linkTo(methodOn(FamilyRestController.class).getFamily(family.getFamilyId())).withSelfRel() );
        }
        list.add( linkTo(methodOn(FamilyRestController.class).getFamilies()).withRel("list") );
        list.add( linkTo(methodOn(FamilyRestController.class).addFamily(null)).withRel("add") );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param Family
     * @return response entity the status to return
     */
    @PostMapping( value = "/family/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Family> addFamily( @RequestBody Family family )
    {
        service.addFamily( family );
        return new ResponseEntity<>( family, HttpStatus.OK );
    }

    /**
     * @param id
     * @return Family
     */
    @GetMapping( value = "/family/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Family> getFamily( @PathVariable Long id )
    {
        Family family = service.getFamily( id );
        family.add( linkTo(methodOn(FamilyRestController.class).getFamily(id)).withSelfRel() );
        return new ResponseEntity<>( family, HttpStatus.OK );
    }
}
