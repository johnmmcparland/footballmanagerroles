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
