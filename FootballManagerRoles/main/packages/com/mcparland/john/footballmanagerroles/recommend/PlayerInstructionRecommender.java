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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.access.KeyAttributesService;
import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.exceptions.RecommendationAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;

/**
 * Recommends players instructions
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
public class PlayerInstructionRecommender implements Recommender<PlayerInstructionRecommendations> {

    /**
     * The Key Attributes Service from which to obtain the key attributes
     */
    private KeyAttributesService keyAttributesService = null;

    /**
     * The maximum value an attribute can have
     */
    private static final double MAX_ATTR_VALUE = 20.0;

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(PlayerInstructionRecommender.class);

    /**
     * Create a recommender of PlayerInstructions
     */
    public PlayerInstructionRecommender() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.Recommender#recommend
     * (com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions,
     * com.mcparland.john.footballmanagerroles.data.people.Player)
     */
    @Override
    public PlayerInstructionRecommendations recommend(PlayerInstructions instructions, Player player) {
        // Ok this is the meat of the whole application

        // Algorithm: for each instruction
        // 1) Get the key attributes
        // 2) Retain the number of required attributes (noAttrs)
        // 3) Sum the Players values for those attributes (playersSum)
        // 4) Rating = playersSum / (noAttrs * MAX_ATTR_VALUE) * 100

        PlayerInstructionRecommendations recommendations = new PlayerInstructionRecommendations();

        for (PlayerInstruction instruction : instructions.getPlayerInstructions()) {
            LOGGER.debug("Calculating the rating for instruction: " + instruction);
            Collection<Attribute> keyAttrs = getKeyAttributesService().getKeyAttributes(instruction.getViewName());
            PlayerInstructionRecommendation recommendation = new PlayerInstructionRecommendation();
            recommendation.setPlayerInstruction(instruction);
            recommendation.setRating(calculateRating(keyAttrs, player));
            try {
                recommendations.addRecommendation(recommendation);
                LOGGER.debug("Rating for " + recommendation.getPlayerInstruction() + " is "
                        + recommendation.getRating());
            } catch (RecommendationAlreadyAddedException e) {
                // We really shouldn't get this, so lets just log it
                e.printStackTrace();
                LOGGER.error("RecommendationAlreadyAddedException occurred during recommend: " + e.getMessage());
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                e.printStackTrace(printWriter);
                LOGGER.error(printWriter);
            }
        }
        return recommendations;
    }

    /**
     * Calculate the rating for a given player and set of key attributes
     * 
     * @param keyAttributes
     *            The key attributes
     * @param player
     *            The player
     * @return The rating for the given set of attributes
     */
    public int calculateRating(Collection<Attribute> keyAttributes, Player player) {
        // Remember this from recommend
        // 2) Retain the number of required attributes (noAttrs)
        // 3) Sum the Players values for those attributes (playersSum)
        // 4) Rating = playersSum / (noAttrs * MAX_ATTR_VALUE) * 100
        int playersSum = 0;
        for (Attribute attr : keyAttributes) {
            playersSum += player.getAttributes().get(attr);
        }
        double rating = (playersSum / (keyAttributes.size() * MAX_ATTR_VALUE)) * 100.0;
        LOGGER.debug("Rating == " + rating);
        return (int)Math.round(rating);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.recommend.Recommender#
     * setKeyAttributesService
     * (com.mcparland.john.footballmanagerroles.data.access
     * .KeyAttributesService)
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.recommend.Recommender#
     * setKeyAttributesService
     * (com.mcparland.john.footballmanagerroles.data.access
     * .KeyAttributesService)
     */
    @Override
    public void setKeyAttributesService(KeyAttributesService keyAttributesService) {
        this.keyAttributesService = keyAttributesService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.recommend.Recommender#
     * getKeyAttributesService()
     */
    @Override
    public KeyAttributesService getKeyAttributesService() {
        return keyAttributesService;
    }
}
