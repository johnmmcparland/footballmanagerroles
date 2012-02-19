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
package com.mcparland.john.footballmanagerroles.recommend;

import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;

/**
 * A recommendation for a Player Instruction
 * <p>
 * This takes the form of a Player Instruction plus a % value (whole numbers
 * only) as the rating
 * </p>
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
public class PlayerInstructionRecommendation implements Recommendation<Integer> {

    /**
     * The Player Instruction this recommendation is made upon
     */
    private PlayerInstruction instruction = null;

    /**
     * The rating of this recommendation
     * <p>
     * This is to be a percentage, and whole numbers only
     * </p>
     */
    private int rating = 0;

    /**
     * Create PlayerInstructionRecommendation
     */
    public PlayerInstructionRecommendation() {

    }

    /**
     * Checks the rating given is a valid one and sets it if so
     * <p>
     * It is not the most cohesive but better than re-implementing time and time
     * again
     * </p>
     * 
     * @param rating
     *            The rating, which should be a number between 0 and 100
     *            inclusive
     */
    protected void checkAndSetRating(Integer rating) throws IllegalArgumentException {
        if (0 <= rating && 100 >= rating) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating is not between 0 and 100: " + rating);
        }
    }

    /**
     * Create PlayerInstructionRecommendation
     * 
     * @param instruction
     *            The instruction the recommendation is based upon
     * @param rating
     *            The rating of the recommendation. Must be between 0 and 100 as
     *            it is treated as a percentage
     */
    public PlayerInstructionRecommendation(PlayerInstruction instruction, Integer rating) {
        this.instruction = instruction;
        checkAndSetRating(rating);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.recommend.Recommendation#
     * setPlayerInstruction
     * (com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction)
     */
    @Override
    public void setPlayerInstruction(PlayerInstruction instruction) {
        this.instruction = instruction;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.recommend.Recommendation#
     * getPlayerInstruction()
     */
    @Override
    public PlayerInstruction getPlayerInstruction() {
        return instruction;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.Recommendation#setRating
     * (java.lang.Comparable)
     */
    @Override
    public void setRating(Integer rating) {
        checkAndSetRating(rating);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.Recommendation#getRating
     * ()
     */
    @Override
    public Integer getRating() {
        return rating;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Recommendation<Integer> o) {
        int diff = rating - o.getRating().intValue();
        if (0 != diff) {
            return diff;
        } else {
            return instruction.compareTo(o.getPlayerInstruction());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o instanceof Recommendation<?>) {
            return 0 == compareTo((Recommendation<Integer>) o);
        } else {
            throw new IllegalArgumentException("o is not a Recommendation: " + o.getClass());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return rating ^ instruction.hashCode();
    }

}
