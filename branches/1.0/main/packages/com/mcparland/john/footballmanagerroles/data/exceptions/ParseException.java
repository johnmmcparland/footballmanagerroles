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
 * A problem parsing an input file
 * 
 * @author John
 * 
 */
public class ParseException extends Exception {

    /**
     * @see {@link java.io.Serializable}
     */
    private static final long serialVersionUID = -6772990715251556883L;

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     */
    public ParseException() {
	super();
    }

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     * 
     * @param message
     *            A message describing the error
     */
    public ParseException(String message) {
	super(message);
    }

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     * 
     * @param cause
     *            The underlying cause of the exception
     */
    public ParseException(Throwable cause) {
	super(cause);
    }

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     * 
     * @param message
     *            A message describing the error
     * @param cause
     *            The underlying cause of the exception
     */
    public ParseException(String message, Throwable cause) {
	super(message, cause);
    }

}