/**
 * 
 */
package com.mcparland.john.footballmanagerroles.input;

import java.io.File;

/**
 * Input for the role calculator
 * 
 * @author John
 * 
 */
public interface Input {

    /**
     * @return The input file
     */
    public File getInputFile();

    /**
     * @param file
     *            The input file
     */
    public void setInputFile(File file);

    /**
     * Set the input from the user
     * 
     * @param args
     *            Program arguments
     * @return True if the input file was set, false otherwise
     */
    public boolean setInputFromUser(String[] args);

}
