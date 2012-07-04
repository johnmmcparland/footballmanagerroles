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
 * Main package for the application
 */
package com.mcparland.john.footballmanagerroles;

import java.io.File;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.access.AttributesService;
import com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionService;
import com.mcparland.john.footballmanagerroles.data.people.Person;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;
import com.mcparland.john.footballmanagerroles.parser.Parser;
import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;
import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendationsImpl;
import com.mcparland.john.footballmanagerroles.recommend.Recommendations;
import com.mcparland.john.footballmanagerroles.recommend.Recommender;

/**
 * Main program for this application which, via dependency injection, gathers
 * the services and uses them.
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
public class FootballManagerRoles {

    /**
     * Service for obtaining attributes
     */
    private AttributesService attributesService = null;

    /**
     * Parser for the input file
     */
    private Parser<Person> parser = null;

    /**
     * Service for obtaining player instructions
     */
    private PlayerInstructionService playerInstructionsService = null;

    /**
     * Recommending object
     */
    private Recommender<?> recommender = null;

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(FootballManagerRoles.class);

    /**
     * Get the attributes service
     * 
     * @return The attributes service
     */
    public AttributesService getAttributesService() {
        return attributesService;
    }

    /**
     * Set the attributes service
     * 
     * @param attributesService
     *            The attributes service
     */
    public void setAttributesService(AttributesService attributesService) {
        this.attributesService = attributesService;
    }

    /**
     * Get the parser
     * 
     * @return The parser
     */
    public Parser<Person> getParser() {
        return parser;
    }

    /**
     * Set the parser
     * 
     * @param parser
     *            The parser
     */
    public void setParser(Parser<Person> parser) {
        this.parser = parser;
    }

    /**
     * Get the service for player instructions
     * 
     * @return The service for player instructions
     */
    public PlayerInstructionService getPlayerInstructionsService() {
        return playerInstructionsService;
    }

    /**
     * Set the service for player instructions
     * 
     * @param playerInstructionsService
     *            The service for player instructions
     */
    public void setPlayerInstructionsService(PlayerInstructionService playerInstructionsService) {
        this.playerInstructionsService = playerInstructionsService;
    }

    /**
     * Get the recommending object
     * 
     * @return The recommending object
     */
    public Recommender<?> getRecommender() {
        return recommender;
    }

    /**
     * Set the recommending object
     * 
     * @param recommender
     *            The recommending object
     */
    public void setRecommender(Recommender<?> recommender) {
        this.recommender = recommender;
    }

    /**
     * Process the input
     * 
     * @param inputFile
     *            The input file
     * @return The player recommendations
     * @throws Exception
     *             Any possible exception encountered
     */
    public PlayerRecommendations process(File inputFile) throws Exception {
        // Parse
        parser.setAttributes(attributesService.getAttributes());
        Player player = (Player) parser.parse(inputFile);
        LOGGER.info("Got Player\n" + player.toString());

        // Determine player instructions
        PlayerInstructions playerInstructions = playerInstructionsService.determinePossiblePlayerInstructions(player
                .getPositions());
        LOGGER.info("Available player instructions\n" + playerInstructions.getPlayerInstructions());

        // Recommend
        Recommendations<?> recommendations = recommender.recommend(playerInstructions, player);

        // Return
        return new PlayerRecommendationsImpl(player, recommendations);
    }

}
