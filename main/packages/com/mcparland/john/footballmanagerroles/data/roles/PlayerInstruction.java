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
 * A players instruction on the ptich
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
public interface PlayerInstruction extends Comparable<PlayerInstruction> {

    /**
     * Set the players role
     * 
     * @param role
     *            The role
     */
    public void setRole(Role role);

    /**
     * Set the players role
     * 
     * @return The role
     */
    public Role getRole();

    /**
     * Set the players duty
     * 
     * @param duty
     *            The duty
     */
    public void setDuty(Duty duty);

    /**
     * Get the players duty
     * 
     * @return The duty
     */
    public Duty getDuty();

    /**
     * Set the view name for this player instruction
     * 
     * @param viewName
     *            The view name for this player instruction
     */
    public void setViewName(String viewName);

    /**
     * Get the view name for this player instruction
     * 
     * @return the view name for this player instruction
     */
    public String getViewName();

}
