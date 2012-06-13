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
 * A line on the pitch
 * 
 * @author John McParland
 * 
 */
public enum PitchArea {

    /**
     * A goalkeeper
     */
    Goalkeeper("Goalkeeper", "GK", false),

    /**
     * A sweeper
     */
    Sweeper("Sweeper", "SW", false),

    /**
     * A defender
     */
    Defender("Defender", "D", true),

    /**
     * A wing back
     */
    WingBack("Wing Back", "WB", true),

    /**
     * A defensive midfielder
     */
    DefensiveMidfielder("Defensive Midfielder", "DM", false),

    /**
     * A midfielder
     */
    Midfielder("Midfielder", "M", true),

    /**
     * An attacking midfielder
     */
    AttackingMidfielder("Attacking Midfielder", "AM", true),

    /**
     * A striker
     */
    Striker("Striker", "ST", false);

    /**
     * The long name for the position
     */
    private String longName = null;

    /**
     * The short name for the position
     */
    private String shortName = null;

    /**
     * Is there a side associated with this pitch area or not e.g. false for
     * Goalkeeper, Sweeper, Defensive Midfielder, Striker true for Wing Back,
     * Attacking Midfielder
     */
    private boolean isSided = true;

    /**
     * Create a pitch area
     * 
     * @param longName
     *            The long name for the position
     * @param shortName
     *            The short name for the position
     * @param isSided
     *            If there is a side associated with this position or not
     */
    PitchArea(String longName, String shortName, boolean isSided) {
        this.longName = longName;
        this.shortName = shortName;
        this.isSided = isSided;
    }

    /**
     * @return The long name for the position
     */
    public String getLongName() {
        return longName;
    }

    /**
     * @param longName
     *            The long name for the position
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * @return The short name for the position
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     *            The short name for the position
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Is there a side associated with this pitch area or not e.g. false for
     * Goalkeeper, Sweeper, Defensive Midfielder, Striker true for Wing Back,
     * Attacking Midfielder
     * 
     * @return Is this position sided?
     */
    public boolean isSided() {
        return isSided;
    }

    /**
     * Is there a side associated with this pitch area or not e.g. false for
     * Goalkeeper, Sweeper, Defensive Midfielder, Striker true for Wing Back,
     * Attacking Midfielder
     * 
     * @param sided
     *            True if there is a side, false if not
     */
    public void setSided(boolean sided) {
        this.isSided = sided;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return getLongName();
    }

    static {

    }

}
