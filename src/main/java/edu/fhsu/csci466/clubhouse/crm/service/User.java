package edu.fhsu.csci466.clubhouse.crm.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM user.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements Serializable
{
    /**
     * serialVersionUID for this version of the entity.
     */
    private static final long serialVersionUID = -8412818735088807102L;

    @Id
    @Getter
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long              id;

    @Setter
    @Getter
    private String            name;

    @Setter
    @Getter
    private Long              accountNumber;

    @Setter
    @Getter
    private String            membershipPlan;
}
