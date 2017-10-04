package edu.fhsu.csci466.clubhouse.crm.service.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;


// Wrapper for an list of things that supports HATEOAS links
//
public class EntityList<T> extends ResourceSupport
{
    private List<? extends T> entities;

    public EntityList( List<? extends T> entities )
    {
        this.entities = entities;
    }

    /**
     * @return the entities
     */
    public List<? extends T> getEntities()
    {
        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities( List<? extends T> entities )
    {
        this.entities = entities;
    }
}
