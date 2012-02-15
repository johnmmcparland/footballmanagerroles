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

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mcparland.john.footballmanagerroles.data.access.AttributesService;
import com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionService;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.exceptions.ParseException;
import com.mcparland.john.footballmanagerroles.data.exceptions.PlayerInstructionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.people.Person;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;
import com.mcparland.john.footballmanagerroles.input.Input;
import com.mcparland.john.footballmanagerroles.parser.Parser;
import com.mcparland.john.footballmanagerroles.support.ErrorReporter;

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
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(FootballManagerRoles.class);

    /**
     * Main method
     * 
     * @param args
     *            Program arguments
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml");
        context.registerShutdownHook();

        // Ensure we can report errors
        ErrorReporter errorReporter = (ErrorReporter) context.getBean("errorReporter");

        // Initialize the data objects
        AttributesService attrsService = (AttributesService) context.getBean("attributesService");
        Attributes attributes = attrsService.getAttributes();
        LOGGER.info("Got attributes");
        LOGGER.debug(attributes.toString());

        // Deal with the input
        Input input = (Input) context.getBean("input");
        if (!input.setInputFromUser(args)) {
            errorReporter.report("Could not set the input file - check it exists and is readable");
        } else {
            // Parse
            @SuppressWarnings("unchecked")
            Parser<Person> parser = (Parser<Person>) context.getBean("parser");
            parser.setAttributes(attributes);
            try {
                // TODO: If this was to be extended to cover staff to then you
                // may wish to check the
                // start of the file
                Player player = (Player) parser.parse(input.getInputFile());
                LOGGER.info("Got Player\n" + player.toString());

                // Determine player instructions
                PlayerInstructionService playerInstructionsService = (PlayerInstructionService) context
                        .getBean("playerInstructionService");
                PlayerInstructions playerInstructions = playerInstructionsService
                        .determinePossiblePlayerInstructions(player.getPositions());
                LOGGER.info("Available player instructions\n" + playerInstructions.getPlayerInstructions());

                // Recommend
                // Recommender recommender = (Recommender)
                // context.getBean("recommender");
                // recommender.recommend(playerInstructions);

            } catch (ParseException pe) {
                errorReporter.report("Couldn't parse the input file" + input.getInputFile(), pe);
            } catch (PlayerInstructionAlreadyAddedException piaae) {
                errorReporter.report("There is an error with the configuration of the possible roles", piaae);
            }
        }
    }
}
