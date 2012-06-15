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
package com.mcparland.john.footballmanagerroles.recommend;

import com.mcparland.john.footballmanagerroles.data.people.Player;

/**
 * A player with their recommendations
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
public class PlayerRecommendationsImpl implements PlayerRecommendations {

    /**
     * The player
     */
    private Player player = null;

    /**
     * The players recommendations
     */
    private Recommendations<?> recommendations = null;

    /**
     * Create a player with recommendations
     */
    public PlayerRecommendationsImpl() {

    }

    /**
     * Create a player with recommendations
     * 
     * @param player
     *            The player
     * @param recommendations
     *            The players recommendations
     */
    public PlayerRecommendationsImpl(Player player, Recommendations<?> recommendations) {
        this.player = player;
        this.recommendations = recommendations;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations
     * #getPlayer()
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations
     * #setPlayer(com.mcparland.john.footballmanagerroles.data.people.Player)
     */
    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations
     * #getRecommendations()
     */
    @Override
    public Recommendations<?> getRecommendations() {
        return recommendations;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations
     * #setRecommendations
     * (com.mcparland.john.footballmanagerroles.recommend.Recommendations)
     */
    @Override
    public void setRecommendations(Recommendations<?> recommendations) {
        this.recommendations = recommendations;
    }

}
