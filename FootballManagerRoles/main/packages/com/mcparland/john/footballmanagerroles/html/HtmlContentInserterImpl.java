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
package com.mcparland.john.footballmanagerroles.html;

import java.io.InputStream;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import com.mcparland.john.footballmanagerroles.view.SimpleHTMLFootballManagerRolesView;

/**
 * The ability to insert content into an HTML page
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
public class HtmlContentInserterImpl implements HtmlContentInserter, InitializingBean {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(HtmlContentInserterImpl.class);

    /**
     * The file containing the "top" of the HTML to print
     */
    private String htmlTopFileName = null;

    /**
     * The file containing the "bottom" of the HTML to print
     */
    private String htmlBottomFileName = null;

    /**
     * Create an HtmlContentInserter
     */
    public HtmlContentInserterImpl() {

    }

    /**
     * Get the HTML Top file name
     * 
     * @return name of the file containing the top of the HTML to output
     */
    public String getHtmlTopFileName() {
        return htmlTopFileName;
    }

    /**
     * Set the HTML Top file name
     * 
     * @param htmlTopFileName
     *            name of the file containing the top of the HTML to output
     */
    public void setHtmlTopFileName(String htmlTopFileName) {
        this.htmlTopFileName = htmlTopFileName;
        LOGGER.trace("htmlTopFileName = " + this.htmlTopFileName);
    }

    /**
     * Get the name of the file containing the bottom of the HTML to output
     * 
     * @return name of the file containing the bottom of the HTML to output
     */
    public String getHtmlBottomFileName() {
        return htmlBottomFileName;
    }

    /**
     * Set the name of the file containing the bottom of the HTML to output
     * 
     * @param htmlBottomFileName
     *            name of the file containing the bottom of the HTML to output
     */
    public void setHtmlBottomFileName(String htmlBottomFileName) {
        this.htmlBottomFileName = htmlBottomFileName;
        LOGGER.trace("htmlBottomFileName = " + this.htmlBottomFileName);
    }

    /**
     * Append the given input file to the given writer
     * 
     * @param inputFile
     *            the given input file
     * @param writer
     *            the given writer
     * @throws Exception
     *             any exceptions which may occur
     */
    private void appendFile(String inputFile, Writer writer) throws Exception {
        InputStream is = SimpleHTMLFootballManagerRolesView.class.getResourceAsStream(inputFile);
        int nextChar = 0;
        while (-1 != (nextChar = is.read())) {
            writer.append((char) nextChar);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.trace("htmlTopFileName = " + this.htmlTopFileName);
        LOGGER.trace("htmlBottomFileName = " + this.htmlBottomFileName);
        try {
            InputStream is = HtmlContentInserterImpl.class.getResourceAsStream(getHtmlTopFileName());
            if (0 == is.available()) {
                throw new IllegalArgumentException("The html top file cannot be read or found: " + getHtmlTopFileName());
            }
        } catch (NullPointerException npe) {
            LOGGER.error("NullPointerException caught - is the file name (" + getHtmlTopFileName() + ") null?", npe);
            throw new IllegalArgumentException("Is the filename (" + getHtmlTopFileName() + ") null? "
                    + npe.getMessage());
        }

        try {
            InputStream is = HtmlContentInserterImpl.class.getResourceAsStream(getHtmlBottomFileName());
            if (0 == is.available()) {
                throw new IllegalArgumentException("The html bottom file cannot be read or found: "
                        + getHtmlBottomFileName());
            }
        } catch (NullPointerException npe) {
            LOGGER.error("NullPointerException caught - is the file name (" + getHtmlBottomFileName() + ") null?", npe);
            throw new IllegalArgumentException("Is the filename (" + getHtmlBottomFileName() + ") null? "
                    + npe.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.html.HtmlContentInserter#insert
     * (java.lang.String, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void insert(String html, HttpServletResponse response) throws Exception {
        // Top
        appendFile(getHtmlTopFileName(), response.getWriter());

        // The middle (i.e. content)
        response.getWriter().append(html);

        // Bottom
        appendFile(getHtmlBottomFileName(), response.getWriter());
    }

}
