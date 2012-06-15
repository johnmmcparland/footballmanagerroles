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

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;

/**
 * No Such attribute exists
 * 
 * @author John McParland
 * 
 */
public class NoSuchAttributeException extends Exception {

    /**
     * @see java.io.Serializable
     */
    public static final long serialVersionUID = 0L;

    /**
     * The attribute
     */
    private Attribute attribute = null;

    /**
     * Create an exception giving the attribute already set and its OLD value
     * 
     * @param attribute
     *            The attribute
     */
    public NoSuchAttributeException(Attribute attribute) {
	super("The atttribute, " + attribute + " doesn't exist");
	this.attribute = attribute;
    }

    /**
     * @return The attribute
     */
    public Attribute getAttribute() {
	return attribute;
    }

    /**
     * @param attribute
     *            The attribute
     */
    public void setAttribute(Attribute attribute) {
	this.attribute = attribute;
    }

}
