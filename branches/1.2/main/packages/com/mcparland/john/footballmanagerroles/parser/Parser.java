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
 * Parser.java
 * John McParland
 * Created: 10 May 2011
 */
package com.mcparland.john.footballmanagerroles.parser;

import java.io.File;

import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.exceptions.ParseException;
import com.mcparland.john.footballmanagerroles.data.people.Person;

/**
 * Parser for Football Manager Data
 * 
 * @author John McParland
 * @version 1.0
 * 
 */
public interface Parser<T extends Person> {

    /**
     * Parse one record from the input
     * 
     * @param input
     *            The input file
     * @return One record
     * @throws ParseException
     *             if the file cannot be parsed
     */
    public T parse(File input) throws ParseException;

    /**
     * Set the attributes to parse out
     * 
     * @param attributes
     *            The attributes to parse out
     */
    public void setAttributes(Attributes attributes);

    /**
     * The attributes parsed out
     * 
     * @return The attributes parsed out
     */
    public Attributes getAttributes();
}
