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

import com.mcparland.john.footballmanagerroles.data.exceptions.PlayerInstructionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;
import com.mcparland.john.footballmanagerroles.data.roles.Position;

/**
 * A player instruction service which allows access to the available player
 * instructions
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
public interface PlayerInstructionService {

    /**
     * Determine the player instructions which can be assigned to the positions
     * given
     * 
     * @param positions
     *            The positions
     * @return The player instructions which those positions can be assigned to
     * @throws PlayerInstructionAlreadyAddedException
     *             If there are duplicate PlayerInstructions found (this is a
     *             configuration error)
     */
    public PlayerInstructions determinePossiblePlayerInstructions(Collection<Position> positions)
            throws PlayerInstructionAlreadyAddedException;

    /**
     * Set the Data Access Objects to use
     * 
     * @param daos
     *            The data access objects
     */
    public void setDAOs(Collection<DAO<PlayerInstruction>> daos);

    /**
     * Get the data access objects
     * 
     * @return The DAOs
     */
    public Collection<DAO<PlayerInstruction>> getDAOs();

}
