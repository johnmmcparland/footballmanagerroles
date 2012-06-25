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
package com.mcparland.john.footballmanagerroles.support;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.html.HtmlContentInserter;

/**
 * <p>
 * (c) John McParland
 * </p>
 * <p>
 * You may enhance this code and re-submit to the depot. But you may not sell it
 * or use it for profit!
 * </p>
 * 
 * @author John McParland (john.mcparland@gmail.com)
 */
public class HtmlErrorReporter implements ErrorReporter {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(HtmlErrorReporter.class);

    /**
     * The HTML Content Inserter which handles inserting of the results
     */
    private HtmlContentInserter htmlContentInserter = null;

    /**
     * The response object to write the errors to
     */
    private HttpServletResponse response = null;

    /**
     * Create an HTML Error Reporter
     */
    public HtmlErrorReporter() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.support.ErrorReporter#report(
     * java.lang.String)
     */
    @Override
    public void report(String message) {
        String html = "<h3>Whoops!</h3>\n<p>\n" + message + "\n</p>\n";
        try {
            getHtmlContentInserter().insert(html, getResponse());
        } catch (Throwable th) {
            // Damn, not much we can do - we're already reporting an error
            th.printStackTrace();
            LOGGER.error("Error while reporting an error: " + th.getMessage(), th);
        }
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
        String html = "<h3>Whoops!</h3>\n<p>\n" + message + "\n</p><br /><br />\n<p>" + throwable.getMessage()
                + "</p><br /><br />\n";
        html += "Here's a really techie bit - don't worry, just contact me with it :)\n+<p>"
                + getStackTraceString(throwable) + "</p>\n";
        try {
            getHtmlContentInserter().insert(html, getResponse());
        } catch (Throwable th) {
            // Damn, not much we can do - we're already reporting an error
            th.printStackTrace();
            LOGGER.error("Error while reporting an error: " + th.getMessage(), th);
        }
    }

    /**
     * Get the stack trace as a String
     * 
     * @param aThrowable
     *            the throwable
     * @return the String
     */
    protected String getStackTraceString(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }

    /**
     * Set the HTML content inserter for inserting HTML
     * 
     * @param htmlContentInserter
     *            the HTML content inserter for inserting HTML
     */
    public void setHtmlContentInserter(HtmlContentInserter htmlContentInserter) {
        this.htmlContentInserter = htmlContentInserter;
    }

    /**
     * Get the HTML content inserter for inserting HTML
     * 
     * @return the htmlContentInserter the HTML content inserter for inserting
     *         HTML
     */
    public HtmlContentInserter getHtmlContentInserter() {
        return htmlContentInserter;
    }

    /**
     * Get the Http response object for writing the errors to
     * 
     * @return the http response object
     */
    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * Set the http response object for writing the errors to
     * 
     * @param response
     *            the http response object
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

}
