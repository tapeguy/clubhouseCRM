package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import edu.fhsu.csci466.clubhouse.crm.service.model.Leader;

/**
 * @author ss047890
 *
 */
public interface LeaderService
{
    /**
     * @param leader
     */
    public void addLeader( final Leader leader );

    /**
     * @return leader
     */
    public List<Leader> getLeaders();

    /**
     * @param id
     * @return leader
     */
    public Leader getLeader( final Long id );
}
