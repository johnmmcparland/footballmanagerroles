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
package com.mcparland.john.footballmanagerroles.input;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * Command line input
 * 
 * @author John
 * 
 */
public class CmdLineInput extends AbstractInput {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(CmdLineInput.class);

    /**
     * Create a new command line input instance
     */
    public CmdLineInput() {
	super();
    }

    /**
     * Create a command line input instance
     * 
     * @param file
     *            The input file
     */
    public CmdLineInput(File file) {
	super(file);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanaerroles.input.Input#setInputFromUser(java
     * .lang.String[])
     */
    public boolean setInputFromUser(String[] args) {
	if (1 != args.length) {
	    LOGGER.error("Incorrect number of arguments");
	    printUsage();
	    return false;
	}
	File f = new File(args[0]);
	if (f.exists() && f.canRead() && f.isFile()) {
	    setInputFile(f);
	    LOGGER.info("Set input file as " + f.getAbsolutePath());
	    return true;
	} else {
	    LOGGER.error("Cannot and/or read file " + f.getAbsolutePath());
	    System.out
		    .println("Cannot and/or read file " + f.getAbsolutePath());
	    printUsage();
	    return false;
	}
    }

    /**
     * Print usage information
     */
    public void printUsage() {
	System.out.println("java -jar FMCoach.jar <inputfile> <player name>");
	System.out.println("<inputfile> Is the player or coach file to read");
	System.out.println("<player name> is the name of the player or coach");
    }

}
