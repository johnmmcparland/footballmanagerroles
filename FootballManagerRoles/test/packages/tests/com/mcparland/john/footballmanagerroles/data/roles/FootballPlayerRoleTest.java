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
package tests.com.mcparland.john.footballmanagerroles.data.roles;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.mcparland.john.footballmanagerroles.data.roles.FootballPlayerRole;
import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition;
import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.data.roles.Side;

/**
 * <p> 
 * (c) John McParland
 * </p>
 * <p>
 * You may enhance this code and re-submit to the depot.
 * But you may not sell it or use it for profit!
 * </p>
 * @author John McParland (john.mcparland@gmail.com)
 */
public class FootballPlayerRoleTest {

    /**
     * Test method for {@link com.mcparland.john.footballmanagerroles.data.roles.AbstractRole#getPosition()}.
     */
    @Test
    public void testGetPosition() {
        final Position position = new PlayerPosition(PitchArea.AttackingMidfielder, Side.Centre);
        final String viewName = "";
        FootballPlayerRole role = new FootballPlayerRole();
        role.setPosition(position);
    }

    /**
     * Test method for {@link com.mcparland.john.footballmanagerroles.data.roles.AbstractRole#getViewName()}.
     */
    @Test
    public void testGetViewName() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.mcparland.john.footballmanagerroles.data.roles.AbstractRole#compareTo(com.mcparland.john.footballmanagerroles.data.roles.Role)}.
     */
    @Test
    public void testCompareTo() {
        fail("Not yet implemented");
    }

}
