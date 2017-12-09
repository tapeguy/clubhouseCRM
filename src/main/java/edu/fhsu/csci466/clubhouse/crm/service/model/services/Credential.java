package edu.fhsu.csci466.clubhouse.crm.service.model.services;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author ss047890
 *
 */
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "credentialId" )
@Entity
public class Credential implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -3138934565369842486L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              credentialId;

    private String            userName;

    private String            password;

    /**
     * no args
     */
    public Credential ()
    {
    }

    /**
     * @param id
     * @param userName
     * @param password
     */
    public Credential ( Long id, String userName, String password )
    {
        this.credentialId = id;
        this.userName = userName;
        this.password = password;
    }

    /**
     * @return the id
     */
    public Long getCredentialId()
    {
        return credentialId;
    }

    /**
     * @param id the id to set
     */
    public void setCredentialId( Long id )
    {
        this.credentialId = id;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    @JsonIgnore     // For security
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword( String password )
    {
        this.password = password;
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
        result = prime * result + ((credentialId == null) ? 0 : credentialId.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        Credential other = (Credential) obj;
        if ( credentialId == null )
        {
            if ( other.credentialId != null )
                return false;
        }
        else if ( !credentialId.equals( other.credentialId ) )
            return false;
        if ( password == null )
        {
            if ( other.password != null )
                return false;
        }
        else if ( !password.equals( other.password ) )
            return false;
        if ( userName == null )
        {
            if ( other.userName != null )
                return false;
        }
        else if ( !userName.equals( other.userName ) )
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
        return "Credential [id=" + credentialId + ", userName=" + userName /* + ", password=" + password */ + "]";
    }
}
