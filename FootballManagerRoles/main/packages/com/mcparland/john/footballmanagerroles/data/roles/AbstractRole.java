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
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * An abstract Role which a player can have
 * <p>
 * (c) John McParland
 * </p>
 * <p>
 * You may enhance this code and re-submit to the depot. But you may not sell it
 * or use it for profit!
 * </p>
 * 
 * @author John McParland (john.mcparland@gmail.com)
 */
abstract class AbstractRole implements Role {

    /**
     * The Position
     */
    private Position position = null;

    /**
     * The name of the database view
     */
    private String viewName = null;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.Role#getPosition()
     */
    @Override
    public Position getPosition() {
        return position;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.Role#setPosition(com
     * .mcparland.john.footballmanagerroles.data.roles.Position)
     */
    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.Role#getViewName()
     */
    @Override
    public String getViewName() {
        return viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.Role#setViewName(java
     * .lang.String)
     */
    @Override
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Position: " + position.toString() + "View name: " + viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Role role) {
        // Position then ViewName
        int val = position.compareTo(role.getPosition());
        return (0 != val) ? val : viewName.compareTo(role.getViewName());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if (other instanceof Role) {
            return 0 == this.compareTo((Role) other);
        } else {
            throw new IllegalArgumentException("The other Object is not a Role, it is a " + other.getClass());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        // Position then ViewName
        return position.hashCode() ^ viewName.hashCode();
    }

}
