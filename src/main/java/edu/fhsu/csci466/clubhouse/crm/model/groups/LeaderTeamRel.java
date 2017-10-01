package edu.fhsu.csci466.clubhouse.crm.model.groups;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.model.Leader;

/**
 * @author ss047890
 *
 */
@Entity
public class LeaderTeamRel implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long   id;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "leader_id" )
    private Leader leader;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinColumn( name = "team_id" )
    private Team   team;
}
