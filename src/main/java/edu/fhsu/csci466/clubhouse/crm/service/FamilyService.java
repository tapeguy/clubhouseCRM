package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Family;

/**
 * @author ss047890
 *
 */
public interface FamilyService
{
    /**
     * @param family
     */
    public void addFamily( final Family family );

    /**
     * @return family
     */
    public List<Family> getFamilys();

    /**
     * @param id
     * @return family
     */
    public Family getFamily( final Long id );
}
