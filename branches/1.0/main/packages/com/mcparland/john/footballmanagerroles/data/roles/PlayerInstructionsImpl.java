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
package com.mcparland.john.footballmanagerroles.data.roles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mcparland.john.footballmanagerroles.data.exceptions.PlayerInstructionAlreadyAddedException;

/**
 * Implementation of PlayerInstructions
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
public class PlayerInstructionsImpl implements PlayerInstructions {

    /**
     * The PlayerInstructions
     */
    private Collection<PlayerInstruction> instructions = null;

    /**
     * Mapping of View Name -> Player Instructions
     */
    private Map<String, Collection<PlayerInstruction>> viewNameToPlayerInstructions = null;

    /**
     * Create a PlayerInstructionsImpl
     */
    public PlayerInstructionsImpl() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions
     * #addPlayerInstruction
     * (com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction)
     */
    @Override
    public void addPlayerInstruction(PlayerInstruction instruction) throws PlayerInstructionAlreadyAddedException {
        if (null == instructions) {
            instructions = new ArrayList<PlayerInstruction>();
            viewNameToPlayerInstructions = new HashMap<String, Collection<PlayerInstruction>>();
        }
        if (instructions.contains(instruction)) {
            throw new PlayerInstructionAlreadyAddedException("Already added PlayerInstruction: " + instruction);
        } else {
            instructions.add(instruction);
            if (!viewNameToPlayerInstructions.containsKey(instruction.getViewName())) {
                viewNameToPlayerInstructions.put(instruction.getViewName(), new ArrayList<PlayerInstruction>());
            }
            viewNameToPlayerInstructions.get(instruction.getViewName()).add(instruction);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions
     * #getPlayerInstructions()
     */
    @Override
    public Collection<PlayerInstruction> getPlayerInstructions() {
        return instructions;
    }

    @Override
    public Map<String, Collection<PlayerInstruction>> getViewNameToPlayerInstructions() {
        return viewNameToPlayerInstructions;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (PlayerInstruction inst : instructions) {
            builder.append(inst.toString() + "\n");
        }
        return builder.toString();
    }

}
