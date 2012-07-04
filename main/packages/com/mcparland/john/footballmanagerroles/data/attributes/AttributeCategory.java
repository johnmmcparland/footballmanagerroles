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
package com.mcparland.john.footballmanagerroles.data.attributes;

/**
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
public enum AttributeCategory {

    Aerobic("Aerobic"), Attacking("Attacking"), BallControl("Ball Control"), Defending("Defending"), NoCategory(
            "No Category"), Shooting("Shooting"), Strength("Strength"), Tactics("Tactics"), GKHandling("GK - Handling"), GKShotStopping(
            "GK - Shot Stopping");

    /**
     * Name of this category
     */
    private String name = null;

    /**
     * Create an Attribute Category with the given display name
     * 
     * @param name
     *            The display name
     */
    private AttributeCategory(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return name;
    }

    /**
     * Set the name of this category
     * 
     * @param name
     *            The name of this category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of this category
     * 
     * @return The name of this category
     */
    public String getName() {
        return this.name;
    }

}
