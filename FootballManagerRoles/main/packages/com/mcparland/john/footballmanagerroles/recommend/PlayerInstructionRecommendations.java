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

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.mcparland.john.footballmanagerroles.data.exceptions.RecommendationAlreadyAddedException;

/**
 * A collection of {@link PlayerInstructionRecommendation}s
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
public class PlayerInstructionRecommendations implements Recommendations<PlayerInstructionRecommendation> {

    /**
     * The recommendations
     */
    private Set<PlayerInstructionRecommendation> recommendations = null;

    /**
     * Create a collection of PlayerInstructionRecommendations
     */
    public PlayerInstructionRecommendations() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.recommend.Recommendations#
     * addRecommendation
     * (com.mcparland.john.footballmanagerroles.recommend.Recommendation)
     */
    @Override
    public void addRecommendation(PlayerInstructionRecommendation recommendation)
            throws RecommendationAlreadyAddedException {
        if (!(recommendation instanceof PlayerInstructionRecommendation)) {
            throw new IllegalArgumentException("Expected a PlayerInstructionRecommendation, got a "
                    + recommendation.getClass());
        }
        if (null == recommendations) {
            recommendations = new TreeSet<PlayerInstructionRecommendation>(Collections.reverseOrder());
        }
        if (recommendations.contains(recommendation)) {
            throw new RecommendationAlreadyAddedException("This recommendation already exists: " + recommendation);
        } else {
            recommendations.add((PlayerInstructionRecommendation) recommendation);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.recommend.Recommendations#
     * getRecommendations()
     */
    @Override
    public Collection<PlayerInstructionRecommendation> getRecommendations() {
        return recommendations;
    }

}
