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
package com.mcparland.john.footballmanagerroles.support;

/**
 * Command line error reporter
 * 
 * @author John McParland (johnmmcparland@gmail.com)
 * 
 */
public class CmdLineErrorReporter implements ErrorReporter {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.support.ErrorReporter#report(
     * java.lang.String)
     */
    @Override
    public void report(String message) {
	System.err.println(message);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.support.ErrorReporter#report(
     * java.lang.String, java.lang.Throwable)
     */
    @Override
    public void report(String message, Throwable throwable) {
	System.err.println(message);
	throwable.printStackTrace();
    }

}
