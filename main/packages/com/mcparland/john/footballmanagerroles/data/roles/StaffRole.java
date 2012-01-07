/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * Staff roles
 * 
 * @author John McParland
 * 
 */
public enum StaffRole {

    AssistantManager("Assistant Manager"), FirstTeamCoach("First Team Coach"), Coach(
	    "Coach"), YouthCoach("Youth Coach"), Scout("Scout"), Physio(
	    "Physio");

    /**
     * The full name of the role
     */
    private String fullRoleName = "";

    /**
     * Create a Staff Role with a more descriptive name of the role
     * 
     * @param fullRoleName
     */
    StaffRole(String fullRoleName) {
	this.fullRoleName = fullRoleName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    public String toString() {
	return fullRoleName;
    }
}
