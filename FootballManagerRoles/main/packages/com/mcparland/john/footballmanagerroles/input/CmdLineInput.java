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

        // This is just extra debugging
        if (!f.exists()) {
            LOGGER.error(f.getAbsolutePath() + " does not EXIST");
        } else if (!f.canRead()) {
            LOGGER.error(f.getAbsolutePath() + " cannot be READ");
        } else if (!f.isFile()) {
            LOGGER.error(f.getAbsoluteFile() + " isn't a FILE");
        }

        if (f.exists() && f.canRead() && f.isFile()) {
            setInputFile(f);
            LOGGER.info("Set input file as " + f.getAbsolutePath());
            return true;
        } else {
            LOGGER.error("Cannot find and/or read file " + f.getAbsolutePath());
            System.out.println("Cannot find and/or read file " + f.getAbsolutePath());
            printUsage();
            return false;
        }
    }

    /**
     * Print usage information
     */
    public void printUsage() {
        System.out.println("java -jar FMCoach.jar <inputfile>");
        System.out.println("<inputfile> Is the player file to read");
    }

}
