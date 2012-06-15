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
package com.mcparland.john.footballmanagerroles.view;

import java.io.InputStream;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;
import com.mcparland.john.footballmanagerroles.recommend.Recommendation;

/**
 * A Simple HTML view for Football Manager Roles
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
public class SimpleHTMLFootballManagerRolesView implements FootballManagerRolesView, InitializingBean {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(SimpleHTMLFootballManagerRolesView.class);

    /**
     * The file containing the "top" of the HTML to print
     */
    private String htmlTopFileName = null;

    /**
     * The file containing the "bottom" of the HTML to print
     */
    private String htmlBottomFileName = null;

    /**
     * Create a SimpleHTMLFootballManagerRolesView
     */
    public SimpleHTMLFootballManagerRolesView() {
        // Nothing to do
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.view.FootballManagerRolesView
     * #view
     * (com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void view(PlayerRecommendations playerRecommendations, HttpServletResponse response) throws Exception {
        // Put the "top" of the file in
        appendFile(getHtmlTopFileName(), response.getWriter());

        // Put the main stuff in
        // Header bits
        response.getWriter().append(
                "<h3>Recommendations for: " + playerRecommendations.getPlayer().getName() + "</h3><br />");
        response.getWriter().append("<h4>Positions</h4><br />");
        response.getWriter().append("<ul>");
        for (Position pos : playerRecommendations.getPlayer().getPositions()) {
            response.getWriter().append("<li>" + pos.toString() + "</li>");
        }
        response.getWriter().append(
                "</ul><br /><h4>Preferred Foot</h4><br /><ul><li>" + playerRecommendations.getPlayer().getPreferredFoot()
                        + "</li></ul><br />");

        // The actual recommendations
        response.getWriter().append("<table><tr><th>Role</th><th>Duty</th><th>Rating</th></tr>");
        for (Recommendation<?> rec : playerRecommendations.getRecommendations().getRecommendations()) {
            response.getWriter().append(
                    "<tr><td>" + rec.getPlayerInstruction().getRole() + "</td><td>"
                            + rec.getPlayerInstruction().getDuty() + "</td><td>" + rec.getRating() + "</td></tr>");
        }
        response.getWriter().append("</table><br />");
        
        // Put the "bottom" of the file in
        appendFile(getHtmlBottomFileName(), response.getWriter());
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
            InputStream is = SimpleHTMLFootballManagerRolesView.class.getResourceAsStream(getHtmlTopFileName());
            if (0 == is.available()) {
                throw new IllegalArgumentException("The html top file cannot be read or found: " + getHtmlTopFileName());
            }
        } catch (NullPointerException npe) {
            LOGGER.error("NullPointerException caught - is the file name (" + getHtmlTopFileName() + ") null?", npe);
            throw new IllegalArgumentException("Is the filename (" + getHtmlTopFileName() + ") null? "
                    + npe.getLocalizedMessage());
        }

        try {
            InputStream is = SimpleHTMLFootballManagerRolesView.class.getResourceAsStream(getHtmlBottomFileName());
            if (0 == is.available()) {
                throw new IllegalArgumentException("The html bottom file cannot be read or found: "
                        + getHtmlBottomFileName());
            }
        } catch (NullPointerException npe) {
            LOGGER.error("NullPointerException caught - is the file name (" + getHtmlBottomFileName() + ") null?", npe);
            throw new IllegalArgumentException("Is the filename (" + getHtmlBottomFileName() + ") null? "
                    + npe.getLocalizedMessage());
        }
    }
}
