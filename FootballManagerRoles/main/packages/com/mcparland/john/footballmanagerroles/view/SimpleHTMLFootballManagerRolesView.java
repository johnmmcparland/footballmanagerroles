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

import javax.servlet.http.HttpServletResponse;

import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.html.HtmlContentInserter;
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
public class SimpleHTMLFootballManagerRolesView implements FootballManagerRolesView {

    /**
     * The HTML Content Inserter which handles inserting of the results
     */
    private HtmlContentInserter htmlContentInserter = null;

    /**
     * Create a SimpleHTMLFootballManagerRolesView
     */
    public SimpleHTMLFootballManagerRolesView() {
        // Nothing to do
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
        StringBuilder builder = new StringBuilder();

        // Put the main stuff in
        // Header bits
        builder.append("<h3>Recommendations for: " + playerRecommendations.getPlayer().getName() + "</h3><br />");
        builder.append("<h4>Positions</h4><br />");
        builder.append("<ul>");
        for (Position pos : playerRecommendations.getPlayer().getPositions()) {
            builder.append("<li>" + pos.toString() + "</li>");
        }
        builder.append("</ul><br /><h4>Preferred Foot</h4><br /><ul><li>"
                + playerRecommendations.getPlayer().getPreferredFoot() + "</li></ul><br />");

        // The actual recommendations
        builder.append("<table><tr><th>Role</th><th>Duty</th><th>Rating</th></tr>");
        for (Recommendation<?> rec : playerRecommendations.getRecommendations().getRecommendations()) {
            builder.append("<tr><td>" + rec.getPlayerInstruction().getRole() + "</td><td>"
                    + rec.getPlayerInstruction().getDuty() + "</td><td>" + rec.getRating() + "</td></tr>");
        }
        builder.append("</table><br />");

        getHtmlContentInserter().insert(builder.toString(), response);
    }

    /**
     * @param htmlContentInserter
     *            the htmlContentInserter to set
     */
    public void setHtmlContentInserter(HtmlContentInserter htmlContentInserter) {
        this.htmlContentInserter = htmlContentInserter;
    }

    /**
     * @return the htmlContentInserter
     */
    public HtmlContentInserter getHtmlContentInserter() {
        return htmlContentInserter;
    }
}
