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
