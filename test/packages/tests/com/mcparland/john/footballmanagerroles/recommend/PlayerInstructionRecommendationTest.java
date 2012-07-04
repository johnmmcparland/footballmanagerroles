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
package tests.com.mcparland.john.footballmanagerroles.recommend;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.Role;
import com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation;
import com.mcparland.john.footballmanagerroles.recommend.Recommendation;

/**
 * Test for
 * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation}
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml", "classpath:/tests/com/mcparland/john/footballmanagerroles/config/test_datasource.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class PlayerInstructionRecommendationTest {

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation#PlayerInstructionRecommendation()}
     * .
     */
    @Test
    public void testPlayerInstructionRecommendation() {
        Recommendation<?> rec = new PlayerInstructionRecommendation();
        assertNotNull(rec);
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation#PlayerInstructionRecommendation(com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction, java.lang.Integer)}
     * .
     */
    @Test
    public void testPlayerInstructionRecommendationPlayerInstructionInteger() {
        PlayerInstruction instruction = new PlayerInstructionImpl(Role.AdvancedForward, Duty.Attack, "AF_A");
        int value = 90;
        Recommendation<Integer> rec = new PlayerInstructionRecommendation(instruction, value);
        assertNotNull(rec);
        assertEquals(instruction, rec.getPlayerInstruction());
        assertEquals(value, rec.getRating().intValue());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation#getPlayerInstruction()}
     * .
     */
    @Test
    public void testGetPlayerInstruction() {
        Recommendation<?> rec = new PlayerInstructionRecommendation();
        final PlayerInstruction ins = new PlayerInstructionImpl(Role.Goalkeeper, Duty.Defend, "GK_D");
        rec.setPlayerInstruction(ins);
        assertEquals(ins, rec.getPlayerInstruction());
        final PlayerInstruction ins1 = new PlayerInstructionImpl(Role.AnchorMan, Duty.Support, "AM_S");
        rec.setPlayerInstruction(ins1);
        assertEquals(ins1, rec.getPlayerInstruction());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation#getRating()}
     * .
     */
    @Test
    public void testGetRating() {
        Recommendation<Integer> rec = new PlayerInstructionRecommendation();
        Integer value = 88;
        rec.setRating(value);
        assertEquals(value, rec.getRating());
        int value1 = 6;
        rec.setRating(value1);
        assertEquals(value1, rec.getRating().intValue());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation#compareTo(com.mcparland.john.footballmanagerroles.recommend.Recommendation)}
     * .
     */
    @Test
    public void testCompareTo() {
        Recommendation<Integer> rec = new PlayerInstructionRecommendation();
        Recommendation<Integer> rec1 = new PlayerInstructionRecommendation();

        final PlayerInstruction ins = new PlayerInstructionImpl(Role.Goalkeeper, Duty.Defend, "GK_D");
        final PlayerInstruction ins1 = new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Attack, "AM_A");

        final Integer rating = 67;
        final Integer rating1 = 34;

        // Same instruction and rating
        rec.setPlayerInstruction(ins);
        rec1.setPlayerInstruction(ins);

        rec.setRating(rating);
        rec1.setRating(rating);

        assertEquals(0, rec.compareTo(rec1));
        assertTrue(rec.equals(rec1));
        assertEquals(rec.hashCode(), rec1.hashCode());

        // Different instruction, same rating
        rec1.setPlayerInstruction(ins1);
        
        assertNotSame(0, rec.compareTo(rec1));
        assertFalse(rec.equals(rec1));
        assertNotSame(rec.hashCode(), rec1.hashCode());

        // Same instruction, different rating
        rec1.setPlayerInstruction(ins);
        rec1.setRating(rating1);
        
        assertNotSame(0, rec.compareTo(rec1));
        assertFalse(rec.equals(rec1));
        assertNotSame(rec.hashCode(), rec1.hashCode());

        // Different rating and instruction
        rec1.setPlayerInstruction(ins1);
        
        assertNotSame(0, rec.compareTo(rec1));
        assertFalse(rec.equals(rec1));
        assertNotSame(rec.hashCode(), rec1.hashCode());
    }

}
