/**
 * 
 */
package com.mcparland.john.footballmanagerroles.input;

import java.io.File;

/**
 * Any kind of input
 * 
 * @author John
 * 
 */
public abstract class AbstractInput implements Input {

    /**
     * The input file
     */
    private File file = null;

    /**
     * Create an abstract input
     */
    public AbstractInput() {

    }

    /**
     * Create an abstract input with the input file set
     * 
     * @param file
     *            The input file
     */
    public AbstractInput(File file) {
	this.file = file;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanaerroles.input.Input#getInputFile()
     */
    @Override
    public File getInputFile() {
	return file;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanaerroles.input.Input#setInputFile(java.
     * io.File)
     */
    @Override
    public void setInputFile(File file) {
	this.file = file;
    }

}
