package edu.fhsu.csci466.clubhouse.crm.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.fhsu.csci466.clubhouse.crm.model.groups.Family;
import edu.fhsu.csci466.clubhouse.crm.model.groups.Team;
import edu.fhsu.csci466.clubhouse.crm.model.services.Event;

public class Club
{

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long        id;

    private String      clubName;

    private Leader      president;

    private Set<Event>  events;

    private Set<Team>   teams;

    private Set<Family> families;

    private Set<Leader> leaders;

    private Set<Member> members;
}
