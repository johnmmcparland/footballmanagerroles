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
package com.mcparland.john.footballmanagerroles.output;

import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;
import com.mcparland.john.footballmanagerroles.recommend.Recommendation;

/**
 * Command line output mechanism
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
public class CmdLineOutput implements Output {

    /**
     * Create a command line output mechanism
     */
    public CmdLineOutput() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.output.Output#output(com.mcparland
     * .john.footballmanagerroles.recommend.PlayerRecommendations)
     */
    @Override
    public void output(PlayerRecommendations playerRecommendations) {
        System.out.println(playerRecommendations.getPlayer().getName() + ": "
                + playerRecommendations.getPlayer().getPositions());
        for (Recommendation<?> rec : playerRecommendations.getRecommendations().getRecommendations()) {
            System.out.println(rec.getPlayerInstruction() + ": " + rec.getRating());
        }
    }

}
