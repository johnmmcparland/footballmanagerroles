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

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.access.DAO;
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
     * Data access objects
     */
    private Collection<DAO<?>> daos = null;

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
        // 1) Get the required attributes
        // 2) Retain the number of required attributes (noAttrs)
        // 3) Sum the Players values for those attributes (playersSum)
        // 4) Rating = playersSum / (noAttrs * MAX_ATTR_VALUE) * 100

        PlayerInstructionRecommendations recommendations = new PlayerInstructionRecommendations();

        for (PlayerInstruction instruction : instructions.getPlayerInstructions()) {
            LOGGER.debug("Calculating the rating for instruction: " + instruction);

        }

        return recommendations;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.Recommender#setDaos
     * (java.util.Collection)
     */
    @Override
    public void setDaos(Collection<DAO<?>> daos) {
        this.daos = daos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.Recommender#getDaos()
     */
    @Override
    public Collection<DAO<?>> getDaos() {
        return daos;
    }
}
