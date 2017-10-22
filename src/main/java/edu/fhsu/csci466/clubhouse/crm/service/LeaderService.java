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
     * @return member
     */
    public List<Leader> getLeaders();

    /**
     * @param leader
     * @return whether leader creation was successful
     */
    public boolean addLeader( Leader leader );

    /**
     * @param id
     * @return leader the leader corresponding to the id arg
     */
    public Leader getLeader( final Long id );

    /**
     * @param name
     * @return leader the leader corresponding to name arg
     */
    public Leader getLeaderByName( final String name );

    /**
     * @param leader
     * @return whether the delete was successful
     */
    public boolean updateLeader( Leader leader );

    /**
     * @param id
     * @return whether the delete was successful
     */
    public boolean deleteLeader( Long id );
}
