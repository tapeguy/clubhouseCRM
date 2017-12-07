package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.Leader;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;
import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Team;
import edu.fhsu.csci466.clubhouse.crm.service.repo.MemberRepository;
import edu.fhsu.csci466.clubhouse.crm.service.repo.TeamRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPATeamService implements TeamService
{
    private final TeamRepository teamRepo;
    private final MemberRepository memberRepo;
    private Member memberId;
    private Team teamId;
    
    /**
     * @param teamRepo
     */
    @Autowired
    public JPATeamService ( TeamRepository teamRepo, MemberRepository memberRepo )
    {
        this.teamRepo = teamRepo;
        this.memberRepo = memberRepo;
    }
    


    @Override
    public void addTeam( final Team team )
    {
        teamRepo.save( team );
    }
    

    @Override
    public List<Team> getTeams()
    {
        List<Team> teams = teamRepo.findAll();
        return teams;
    }

    @Override
    public Team getTeam( final Long id )
    {
        return teamRepo.findOne( id );
    }
    
    @Override
    public boolean addMemberToTeam(Long memberId, Long teamId)
    {
    		if(memberRepo.exists(memberId) && teamRepo.exists(teamId)) {
    			Member member = memberRepo.findOne(memberId);
    			List<Team> team = (List<Team>) teamRepo.findOne(teamId);
    			member.setMemberTeams(team);
    			teamRepo.save(team);
    			return true;
    		}
    		return false;
    }
    
    @Override
    public List<Team> getTeamsMatchingLeader(Long leaderId)
    {
		List<Team> teams = getTeams();
		List<Team> teamsMatchingLeader = new ArrayList<>();
			for (Team team : teams) 
			{
				if (team.getLeader().getMemberId() == leaderId)
					teamsMatchingLeader.add(team);
			}
			return teamsMatchingLeader;
    }
}
