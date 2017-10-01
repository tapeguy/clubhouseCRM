package edu.fhsu.csci466.clubhouse.crm.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.service.model.services.Credential;

/**
 * @author ss047890
 *
 * 
 */
@Entity
public class Leader implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -1853417858470664394L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "leader_type_id" )
    private LeaderType        leaderType;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "credential_id" )
    private Credential        credential;

    private String            email;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( Long id )
    {
        this.id = id;
    }

    /**
     * @return the leaderType
     */
    public LeaderType getLeaderType()
    {
        return leaderType;
    }

    /**
     * @param leaderType the leaderType to set
     */
    public void setLeaderType( LeaderType leaderType )
    {
        this.leaderType = leaderType;
    }

    /**
     * @return the credential
     */
    public Credential getCredential()
    {
        return credential;
    }

    /**
     * @param credential the credential to set
     */
    public void setCredential( Credential credential )
    {
        this.credential = credential;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail( String email )
    {
        this.email = email;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 19890919;
        int result = 1;
        result = prime * result + ((credential == null) ? 0 : credential.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((leaderType == null) ? 0 : leaderType.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Leader other = (Leader) obj;
        if ( credential == null )
        {
            if ( other.credential != null )
                return false;
        }
        else if ( !credential.equals( other.credential ) )
            return false;
        if ( email == null )
        {
            if ( other.email != null )
                return false;
        }
        else if ( !email.equals( other.email ) )
            return false;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        if ( leaderType == null )
        {
            if ( other.leaderType != null )
                return false;
        }
        else if ( !leaderType.equals( other.leaderType ) )
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Leader [id=" + id + ", leaderType=" + leaderType + ", credential=" + credential + ", email=" + email
                        + "]";
    }
}
