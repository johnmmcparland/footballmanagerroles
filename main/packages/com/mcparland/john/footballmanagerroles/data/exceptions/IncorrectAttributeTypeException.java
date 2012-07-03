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
 * 
 */
package com.mcparland.john.footballmanagerroles.data.exceptions;

/**
 * Indicates an attribute is of the wrong type
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
public class IncorrectAttributeTypeException extends RuntimeException {

    /**
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = 4175816867570783897L;

    /**
     * Create an exception indicating an attribute is of the wrong type
     */
    public IncorrectAttributeTypeException() {
        super();
    }

    /**
     * Create an exception indicating an attribute is of the wrong type
     * 
     * @param message
     *            A message describing the exception
     */
    public IncorrectAttributeTypeException(String message) {
        super(message);
    }

    /**
     * Create an exception indicating an attribute is of the wrong type
     * 
     * @param cause
     *            The underlying cause of the exception
     */
    public IncorrectAttributeTypeException(Throwable cause) {
        super(cause);
    }

    /**
     * Create an exception indicating an attribute is of the wrong type
     * 
     * @param message
     *            A message describing the exception
     * @param cause
     *            The underlying cause of the exception
     */
    public IncorrectAttributeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

}
