package edu.fhsu.csci466.clubhouse.crm.model.services;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ss047890
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Credential implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -3138934565369842486L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long              id;

    private String            userName;

    private String            password;

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
}
