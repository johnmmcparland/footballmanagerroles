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
 * Package for the roles a player could have
 */
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * A players position
 * <p>
 * (c) John McParland
 * </p>
 * <p>
 * You may enhance this code and re-submit to the depot. But you may not sell it
 * or use it for profit!
 * </p>
 * 
 * @author John McParland (john.mcparland@gmail.com)
 * 
 */
public class PlayerPosition implements Position {

    /**
     * The side
     */
    private Side side = null;

    /**
     * The pitch area
     */
    private PitchArea pitchArea = null;

    /**
     * Create a players position
     */
    public PlayerPosition() {

    }

    /**
     * Create a players position
     * 
     * @param line
     *            The line the player plays on
     */
    public PlayerPosition(PitchArea line) {
        this.pitchArea = line;
    }

    /**
     * Create a players position
     * 
     * @param line
     *            The line the player plays on
     * @param side
     *            The side the player plays on
     */
    public PlayerPosition(PitchArea line, Side side) {
        this.pitchArea = line;
        this.side = side;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Position#getLine()
     */
    @Override
    public PitchArea getLine() {
        return pitchArea;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Position#setLine(com.mcparland
     * .john.footballmanagerroles.data.PitchArea)
     */
    @Override
    public void setLine(PitchArea line) {
        this.pitchArea = line;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Position#getSide()
     */
    @Override
    public Side getSide() {
        return side;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Position#setSide(com.mcparland
     * .john.footballmanagerroles.data.Side)
     */
    @Override
    public void setSide(Side side) {
        this.side = side;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = pitchArea.getLongName();
        if (null != side) {
            str += "(" + side.toString() + ")";
        }
        return str;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Position o) {
        if (null == pitchArea && null == o.getLine()) {
            return 0;
        } else if (null == pitchArea) {
            return -1;
        } else if (null == o.getLine()) {
            return 1;
        } else {
            int diff = pitchArea.compareTo(o.getLine());
            if (0 != diff) {
                return diff;
            } else {
                if (null == side && null == o.getSide()) {
                    return 0;
                } else if (null == side) {
                    return -1;
                } else if (null == o.getSide()) {
                    return 1;
                } else {
                    return side.compareTo(o.getSide());
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o instanceof PlayerPosition) {
            return 0 == this.compareTo((PlayerPosition) o);
        } else {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return getLine().hashCode() ^ getSide().hashCode();
    }

}
