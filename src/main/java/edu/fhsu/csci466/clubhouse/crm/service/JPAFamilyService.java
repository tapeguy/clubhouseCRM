package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import edu.fhsu.csci466.clubhouse.crm.service.model.groups.Family;
import edu.fhsu.csci466.clubhouse.crm.service.repo.FamilyRepository;

/**
 * @author ss047890
 *
 */
@Service
@EnableJpaRepositories
@EntityScan
public class JPAFamilyService implements FamilyService
{
    @Autowired
    FamilyRepository familyRepo;

    @Override
    public void addFamily( final Family family )
    {
        familyRepo.save( family );
    }

    @Override
    public List<Family> getFamilies()
    {
        List<Family> families = familyRepo.findAll();
        return families;
    }

    @Override
    public Family getFamily( final Long id )
    {
        return familyRepo.findOne( id );
    }

}
