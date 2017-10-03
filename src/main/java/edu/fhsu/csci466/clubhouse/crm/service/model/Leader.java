package edu.fhsu.csci466.clubhouse.crm.service.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ss047890
 *
 *
 */
@Entity
@DiscriminatorValue("LEADER")
public class Leader extends Member
{
    /**
     *
     */
    private static final long serialVersionUID = -1853417858470664394L;


    @Column( name = "admin" )
    private boolean admin;


    /**
     * @return the admin
     */
    public boolean isAdmin()
    {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin( boolean admin )
    {
        this.admin = admin;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Leader [" + super.toString() + "]";
    }
}
