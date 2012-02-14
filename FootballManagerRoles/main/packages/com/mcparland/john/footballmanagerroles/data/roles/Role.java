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
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * A Role in the game
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
public enum Role {

    /*
     * Goalkeeping Roles
     */

    /**
     * Goalkeeper
     */
    Goalkeeper("Goalkeeper"),

    /**
     * Sweeper Keeper
     */
    SweeperKeeper("Sweeper Keeper"),

    /*
     * Sweeper Roles
     */

    /**
     * Libero
     */
    Libero("Libero"),

    /**
     * Sweeper
     */
    Sweeper("Sweeper"),

    /*
     * Defender Roles
     */

    /**
     * Ball Playing Defender
     */
    BallPlayingDefender("Ball Playing Defender"),

    /**
     * Central Defender
     */
    CentralDefender("Central Defender"),

    /**
     * Limited Defender
     */
    LimitedDefender("Limited Defender"),

    /**
     * Full Back
     */
    FullBack("Full Back"),

    /**
     * Wing Back
     */
    WingBack("Wing Back"),

    /*
     * Defensive Midfield Roles
     */

    /**
     * Anchor Man
     */
    AnchorMan("Anchor Man"),

    /**
     * Defensive Midfielder
     */
    DefensiveMidfielder("Defensive Midfielder"),

    /*
     * Midfielder Roles
     */

    /**
     * Deep Lying Playmaker
     */
    DeepLyingPlaymaker("Deep Lying Playmaker"),

    /**
     * Advanced Playmaker
     */
    AdvancedPlaymaker("Advanced Playmaker"),

    /**
     * Ball Winning Midfielder
     */
    BallWinningMidfielder("Ball Winning Midfielder"),

    /**
     * Box To Box Midfielder
     */
    BoxToBoxMidfielder("Box To Box Midfielder"),

    /**
     * Central Midfielder
     */
    CentralMidfielder("Central Midfielder"),

    /**
     * Defensive Winger
     */
    DefensiveWinger("Defensive Winger"),

    /**
     * Winger
     */
    Winger("Winger"),

    /**
     * Wide Midfielder
     */
    WideMidfielder("Wide Midfielder"),

    /*
     * Attacking Midfield Roles
     */

    /**
     * Attacking Midfielder
     */
    AttackingMidfielder("Attacking Midfielder"),

    /*
     * Forward Roles
     */

    /**
     * Advanced Forward
     */
    AdvancedForward("Advanced Forward"),

    /**
     * Complete Forward
     */
    CompleteForward("Complete Forward"),

    /**
     * Deep Lying Forward
     */
    DeepLyingForward("Deep Lying Forward"),

    /**
     * Defensive Forward
     */
    DefensiveForward("Defensive Forward"),

    /**
     * Poacher
     */
    Poacher("Poacher"),

    /**
     * Target Man
     */
    TargetMan("Target Man");

    /**
     * The name of this role
     */
    private String name = null;

    /**
     * Create a role with a given name
     * 
     * @param name
     *            The name of the role
     */
    private Role(String name) {
        this.name = name;
    }

    /**
     * Set the name of the role
     * 
     * @param name
     *            The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the role
     * 
     * @return The name
     */
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return name;
    }
}
