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

import com.mcparland.john.footballmanagerroles.data.exceptions.RecommendationAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.Role;
import com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation;
import com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendations;

/**
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendations}
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
@ContextConfiguration(locations = { "classpath:/com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class PlayerInstructionRecommendationsTest {

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendations#PlayerInstructionRecommendations()}
     * .
     */
    @Test
    public void testPlayerInstructionRecommendations() {
        PlayerInstructionRecommendations recs = new PlayerInstructionRecommendations();
        assertNotNull(recs);
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendations#addRecommendation(com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation)}
     * .
     */
    @Test
    public void testAddRecommendation() {
        PlayerInstructionRecommendations recs = new PlayerInstructionRecommendations();
        final PlayerInstructionRecommendation rec1 = new PlayerInstructionRecommendation(new PlayerInstructionImpl(Role.AdvancedForward, Duty.Attack, "AF_A"),45);
       
        // Add one 
        try {
            recs.addRecommendation(rec1);
        } catch (RecommendationAlreadyAddedException e) {
            e.printStackTrace();
            fail("Caught RecommendationAlreadyAddedException when not expected");
        }
        assertTrue(recs.getRecommendations().contains(rec1));
        assertEquals(1, recs.getRecommendations().size());
        
        // Try to add again
        boolean exceptionCaught = false;
        try {
            recs.addRecommendation(rec1);
        } catch(RecommendationAlreadyAddedException ex) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        exceptionCaught = false;
        assertTrue(recs.getRecommendations().contains(rec1));
        assertEquals(1, recs.getRecommendations().size());
        
        // Add a different one 
        final PlayerInstructionRecommendation rec2 = new PlayerInstructionRecommendation(new PlayerInstructionImpl(Role.BallWinningMidfielder, Duty.Defend, "BWM_D"),20);
        try {
            recs.addRecommendation(rec2);
        } catch (RecommendationAlreadyAddedException ex) {
            ex.printStackTrace();
            fail("RecommendationAlreadyAddedException caught when it wasn't expected");
        }
        assertTrue(recs.getRecommendations().contains(rec1));
        assertTrue(recs.getRecommendations().contains(rec2));
        assertEquals(2, recs.getRecommendations().size());
    }

}
