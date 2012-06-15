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
package com.mcparland.john.footballmanagerroles.data.exceptions;

/**
 * Indicated a PlayerInstruction was already added to a collection
 * <p> 
 * (c) John McParland
 * </p>
 * <p>
 * You may enhance this code and re-submit to the depot.
 * But you may not sell it or use it for profit!
 * </p>
 * @author John McParland (john.mcparland@gmail.com)
 */
public class PlayerInstructionAlreadyAddedException extends Exception {

    /**
     * @see {@link java.io.Serializable}
     */
    private static final long serialVersionUID = 3781172492501366277L;

    /**
     * Create an exception indicating a PlayerInstruction was already added
     */
    public PlayerInstructionAlreadyAddedException() {
        
    }

    /**
     * Create an exception indicating a PlayerInstruction was already added
     * @param message A message describing this exception
     */
    public PlayerInstructionAlreadyAddedException(String message) {
        super(message);
    }

    /**
     * Create an exception indicating a PlayerInstruction was already added
     * @param cause The underlying cause of this exception
     */
    public PlayerInstructionAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    /**
     * Create an exception indicating a PlayerInstruction was already added
     * @param message A message describing this exception
     * @param cause The underlying cause of this exception
     */
    public PlayerInstructionAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);    }

}
