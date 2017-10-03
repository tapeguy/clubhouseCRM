package edu.fhsu.csci466.clubhouse.crm.service.model;

import edu.fhsu.csci466.clubhouse.crm.service.model.display.ClubDisplay;

public enum MemberType {


    MEMBER,
    LEADER,
    PRESIDENT;

    @Override
    public String toString()
    {
        switch ( this )
        {
        case MEMBER:
            return ClubDisplay.MEMBER;

        case LEADER:
            return ClubDisplay.LEADER;

        case PRESIDENT:
            return ClubDisplay.PRESIDENT;

        default:
            throw new IllegalArgumentException("Invalid MemberType.");
        }
    }
}
