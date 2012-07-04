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
package com.mcparland.john.footballmanagerroles.data.access;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.exceptions.PlayerInstructionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionsImpl;
import com.mcparland.john.footballmanagerroles.data.roles.Position;

/**
 * Service to get player instructions
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
public class PlayerInstructionServiceImpl implements PlayerInstructionService {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(PlayerInstructionServiceImpl.class);

    /**
     * Data access objects for the Player Instructions
     */
    private Collection<DAO<PlayerInstruction>> daos = null;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionService
     * #determinePossiblePlayerInstructions(java.util.Collection)
     */
    @Override
    public PlayerInstructions determinePossiblePlayerInstructions(Collection<Position> positions)
            throws PlayerInstructionAlreadyAddedException {
        if (null == positions) {
            throw new NullPointerException("positions is null!");
        }
        PlayerInstructions instructions = new PlayerInstructionsImpl();
        if (0 != positions.size()) {
            // For each data access object, go through and query for the
            // positions
            for (DAO<PlayerInstruction> dao : daos) {
                LOGGER.debug(dao.toString());

                // Build the query
                String query = buildPlayerInstructionQuery(dao.getQuery(), positions);

                // Do the query
                List<PlayerInstruction> instructs = (List<PlayerInstruction>) dao.getJdbcTemplate().query(query,
                        dao.getQueryier());
                for (PlayerInstruction ins : instructs) {
                    instructions.addPlayerInstruction(ins);
                }
            }
        }
        return instructions;
    }

    /**
     * Build the query to query for player instructions based on positions
     * 
     * @param queryStart
     *            The start of the query
     * @param positions
     *            The positions
     * @return The query as a String
     */
    private String buildPlayerInstructionQuery(String queryStart, Collection<Position> positions) {
        StringBuilder builder = new StringBuilder(queryStart);
        LOGGER.trace("Query start: " + queryStart);
        LOGGER.trace("Number of positions: " + positions.size());

        // Ok security check - ensure there is only one select keyword, no
        // insert, no update and no delete
        if (0 != queryStart.lastIndexOf("select")) {
            throw new IllegalArgumentException("The query has more than one select keyword: " + queryStart);
        }
        if (-1 != queryStart.indexOf("insert")) {
            throw new IllegalArgumentException("The query contains the insert keyword: " + queryStart);
        }
        if (-1 != queryStart.indexOf("update")) {
            throw new IllegalArgumentException("The query contains the update keyword: " + queryStart);
        }
        if (-1 != queryStart.indexOf("delete")) {
            throw new IllegalArgumentException("The query contains the delete keyword: " + queryStart);
        }

        // Now build it
        boolean first = true;
        for (Position pos : positions) {
            if (!first) {
                builder.append(" or ");
            } else {
                first = false;
            }
            builder.append("(PitchArea = '" + pos.getLine().getLongName() + "'");
            if (pos.getLine().isSided()) {
                builder.append(" and Side = '" + pos.getSide() + "'");
            }
            builder.append(")");
        }
        LOGGER.trace("Final Query: " + builder);
        return builder.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionService
     * #setDAOs(java.util.Collection)
     */
    @Override
    public void setDAOs(Collection<DAO<PlayerInstruction>> daos) {
        this.daos = daos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionService
     * #getDAOs()
     */
    @Override
    public Collection<DAO<PlayerInstruction>> getDAOs() {
        return daos;
    }

}
