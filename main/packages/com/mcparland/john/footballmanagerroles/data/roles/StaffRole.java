/*
 * A program to determine the best role for footballer in the Football Manager game
 * Copyright (C) 2011-12  John McParland (johnmmcparland@gmail.com)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
