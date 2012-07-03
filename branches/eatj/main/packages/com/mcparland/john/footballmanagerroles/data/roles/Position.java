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
 * Position.java
 * John McParland
 * Created: 11 May 2011
 */
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * Positions, consisting of a {@link PitchArea} of the pitch and a {@link Side}
 * @author John McParland
 *
 */
public interface Position extends Comparable<Position> {

    /**
     * @return The line of the position (defence, attacking midfield, forward)
     */
    public PitchArea getLine();
    
    /**
     * @param line The line of the position (defence, attacking midfield, forward)
     */
    public void setLine(PitchArea line);
    
    /**
     * @return The side of the position (centre, left, right)
     */
    public Side getSide();
    
    /**
     * @param side The side of the position (centre, left, right)
     */
    public void setSide(Side side);
    
}
