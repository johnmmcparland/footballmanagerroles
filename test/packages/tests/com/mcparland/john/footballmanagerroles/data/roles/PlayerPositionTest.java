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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition;
import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.data.roles.Side;

/**
 * Test class for {@link PlayerPosition}
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
public class PlayerPositionTest {

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition#PlayerPosition()}
     * .
     */
    @Test
    public void testPlayerPosition() {
        Position pos = new PlayerPosition();
        assertNotNull(pos);
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition#PlayerPosition(com.mcparland.john.footballmanagerroles.data.roles.PitchArea)}
     * .
     */
    @Test
    public void testPlayerPositionPitchArea() {
        Position pos = new PlayerPosition(PitchArea.Goalkeeper);
        assertEquals(PitchArea.Goalkeeper, pos.getLine());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition#PlayerPosition(com.mcparland.john.footballmanagerroles.data.roles.PitchArea, com.mcparland.john.footballmanagerroles.data.roles.Side)}
     * .
     */
    @Test
    public void testPlayerPositionPitchAreaSide() {
        Position pos = new PlayerPosition(PitchArea.Defender, Side.Left);
        assertEquals(PitchArea.Defender, pos.getLine());
        assertEquals(Side.Left, pos.getSide());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition#getLine()}
     * .
     */
    @Test
    public void testGetLine() {
        Position pos = new PlayerPosition(PitchArea.Defender, Side.Left);
        assertEquals(PitchArea.Defender, pos.getLine());
        pos.setLine(PitchArea.Midfielder);
        assertEquals(PitchArea.Midfielder, pos.getLine());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition#getSide()}
     * .
     */
    @Test
    public void testGetSide() {
        Position pos = new PlayerPosition(PitchArea.Defender, Side.Left);
        assertEquals(Side.Left, pos.getSide());
        pos.setSide(Side.Centre);
        assertEquals(Side.Centre, pos.getSide());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition#compareTo(com.mcparland.john.footballmanagerroles.data.roles.Position)}
     * and {@link PlayerPosition#equals(Object)} and
     * {@link PlayerPosition#hashCode()} .
     */
    @Test
    public void testCompareTo() {
        Position pos = new PlayerPosition(PitchArea.Defender, Side.Left);
        Position pos1 = new PlayerPosition(PitchArea.Defender, Side.Left);

        // Same
        assertTrue(pos.equals(pos1));
        assertEquals(0, pos.compareTo(pos1));
        assertEquals(pos.hashCode(), pos1.hashCode());

        // Different lines
        pos1.setLine(PitchArea.Midfielder);
        assertFalse(pos.equals(pos1));
        assertNotSame(0, pos.compareTo(pos1));
        assertNotSame(pos.hashCode(), pos1.hashCode());

        // Different sides
        pos1.setLine(PitchArea.Defender);
        pos1.setSide(Side.Right);
        assertFalse(pos.equals(pos1));
        assertNotSame(0, pos.compareTo(pos1));
        assertNotSame(pos.hashCode(), pos1.hashCode());

        // Different lines and sides
        pos1.setLine(PitchArea.WingBack);
        assertFalse(pos.equals(pos1));
        assertNotSame(0, pos.compareTo(pos1));
        assertNotSame(pos.hashCode(), pos1.hashCode());
    }

}
