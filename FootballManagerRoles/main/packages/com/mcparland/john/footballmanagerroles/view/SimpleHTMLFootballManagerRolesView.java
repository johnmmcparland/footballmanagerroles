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

import org.apache.commons.beanutils.BeanUtilsBean2;

import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;

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
        response.getWriter().append(
                BeanUtilsBean2.getInstance().describe(playerRecommendations.getPlayer()).toString()
                        .replaceAll(",", "<br/>"));
        response.getWriter().append("<br/><br/>Recomendations: <br/>");
        response.getWriter().append(
                playerRecommendations.getRecommendations().getRecommendations().toString().replaceAll(",", "<br/>"));
    }

}
