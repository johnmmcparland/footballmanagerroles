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
 * Package for people in the game
 */
package com.mcparland.john.footballmanagerroles.data.people;

import java.util.List;

import com.mcparland.john.footballmanagerroles.data.roles.Position;

/**
 * A Football Player
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
public interface Player extends Person {

    /**
     * @return The positions this player can play
     */
    public List<Position> getPositions();

    /**
     * Add a position that this player can play
     * 
     * @param pos
     *            The position to add
     */
    public void addPosition(Position pos);

    /**
     * Remove the position this player can play
     * 
     * @param pos
     *            The position
     */
    public void removePosition(Position pos);

    /**
     * Clear their positions
     */
    public void clearPositions();

    /**
     * @return Their height
     */
    public String getHeight();

    /**
     * @param height
     *            Their height
     */
    public void setHeight(String height);

    /**
     * @return Preferred foot
     */
    public String getPreferredFoot();

    /**
     * @param preferredFoot
     *            Their preferred foot
     */
    public void setPreferredFoot(String preferredFoot);

    /**
     * @return Their mass
     */
    public String getMass();

    /**
     * @param mass
     *            Their mass
     */
    public void setMass(String mass);

    /**
     * @return Their wage
     */
    public String getWage();

    /**
     * @param wage
     *            Their wage
     */
    public void setWage(String wage);

    /**
     * @return Their value
     */
    public String getValue();

    /**
     * @param value
     *            Their value
     */
    public void setValue(String value);

}
