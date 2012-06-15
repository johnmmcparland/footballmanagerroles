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
