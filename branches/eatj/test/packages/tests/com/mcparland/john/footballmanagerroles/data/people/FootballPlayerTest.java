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
package tests.com.mcparland.john.footballmanagerroles.data.people;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeCategory;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.OutfieldPlayerAttribute;
import com.mcparland.john.footballmanagerroles.data.exceptions.AttributeAlreadySetException;
import com.mcparland.john.footballmanagerroles.data.exceptions.NoSuchAttributeException;
import com.mcparland.john.footballmanagerroles.data.exceptions.PositionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.people.FootballPlayer;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition;
import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.data.roles.Side;

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
public class FootballPlayerTest {

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.people.FootballPlayer#FootballPlayer(java.lang.String)}
     * .
     */
    @Test
    public void testFootballPlayerString() {
        Player player = new FootballPlayer("Gianluigi Buffon");
        assertEquals("Gianluigi Buffon", player.getName());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.people.FootballPlayer#FootballPlayer()}
     * .
     */
    @Test
    public void testFootballPlayer() {
        Player player = new FootballPlayer();
        assertNotNull(player);
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.people.FootballPlayer#getPositions()} and
     * {@link FootballPlayer#addPositions(Position)} and {@link FootballPlayer#removePosition(Position)}
     * .
     */
    @Test
    public void testGetAddRemovePositions() {
        Player player = new FootballPlayer();

        // Add one and check
        Position pos = new PlayerPosition();
        pos.setLine(PitchArea.AttackingMidfielder);
        pos.setSide(Side.Centre);
        player.addPosition(pos);
        assertEquals(1, player.getPositions().size());
        assertTrue(player.getPositions().contains(pos));

        // Add another and check
        Position pos1 = new PlayerPosition();
        pos1.setLine(PitchArea.Striker);
        pos1.setSide(Side.Centre);
        player.addPosition(pos1);
        assertEquals(2, player.getPositions().size());
        assertTrue(player.getPositions().contains(pos));
        assertTrue(player.getPositions().contains(pos));

        // Try to add the same one
        boolean exceptionCaught = false;
        try {
            player.addPosition(pos1);
        } catch (PositionAlreadyAddedException paae) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertEquals(2, player.getPositions().size());
        assertTrue(player.getPositions().contains(pos));
        assertTrue(player.getPositions().contains(pos));

        // Remove it
        player.removePosition(pos1);
        assertEquals(1, player.getPositions().size());
        assertTrue(player.getPositions().contains(pos));
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.people.FootballPlayer#clearPositions()}
     * .
     */
    @Test
    public void testClearPositions() {
        Player player = new FootballPlayer();
        // Add one then clear
        Position pos = new PlayerPosition();
        pos.setLine(PitchArea.AttackingMidfielder);
        pos.setSide(Side.Centre);
        player.addPosition(pos);
        assertEquals(1, player.getPositions().size());
        assertTrue(player.getPositions().contains(pos));

        player.clearPositions();
        assertEquals(0, player.getPositions().size());

        // Clear again
        player.clearPositions();
        assertEquals(0, player.getPositions().size());
    }


    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.people.AbstractPerson#getAttributes()} and 
     * {@link AbstractPerson#addAttribute(Attribute)} and {@link AbstractPerson#removeAttribute(Attribute)}} and 
     * {@link AbstractPerson#clearAttributes()}
     * .
     */
    @Test
    public void testGetAttributes() {
        Player player = new FootballPlayer();

        // Add an attribute and check
        Attribute attr = new OutfieldPlayerAttribute("Heading", AttributeType.Technical);
        attr.setCategory(AttributeCategory.BallControl);

        try {
            player.addAttribute(attr, 10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            fail("Caught IllegalArgumentException unexpectedly");
        } catch (AttributeAlreadySetException e) {
            e.printStackTrace();
            fail("Caught AttributeAlreadySetException unexpectedly");
        }

        assertEquals(1, player.getAttributes().size());
        assertEquals(10, player.getAttributes().get(attr).intValue());

        // Try to add again
        boolean exceptionCaught = false;
        try {
            player.addAttribute(attr, 20);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            fail("Caught IllegalArgumentException unexpectedly");
        } catch (AttributeAlreadySetException e) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertEquals(1, player.getAttributes().size());
        assertEquals(10, player.getAttributes().get(attr).intValue());

        // Add a different one
        Attribute attr1 = new OutfieldPlayerAttribute("Stamina", AttributeType.Physical);
        attr1.setCategory(AttributeCategory.Strength);
        try {
            player.addAttribute(attr1, 6);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            fail("Caught IllegalArgumentException unexpectedly");
        } catch (AttributeAlreadySetException e) {
            e.printStackTrace();
            fail("Caught AttributeAlreadySetException unexpectedly");
        }
        assertEquals(2, player.getAttributes().size());
        assertEquals(10, player.getAttributes().get(attr).intValue());
        assertEquals(6, player.getAttributes().get(attr1).intValue());

        // Remove one
        try {
            player.removeAttribute(attr1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            fail("Caught IllegalArgumentException unexpectedly");
        } catch (NoSuchAttributeException e) {
            e.printStackTrace();
            fail("Caught NoSuchAttributeException unexpectedly");
        }
        assertEquals(1, player.getAttributes().size());
        assertEquals(10, player.getAttributes().get(attr).intValue());

        // Try removing again
        exceptionCaught = false;
        try {
            player.removeAttribute(attr1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            fail("Caught IllegalArgumentException unexpectedly");
        } catch (NoSuchAttributeException e) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertEquals(1, player.getAttributes().size());
        assertEquals(10, player.getAttributes().get(attr).intValue());

        // And clear
        player.clearAttributes();
        assertEquals(0, player.getAttributes().size());
    }

}
