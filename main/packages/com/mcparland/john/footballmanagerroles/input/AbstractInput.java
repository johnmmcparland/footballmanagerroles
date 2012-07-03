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
