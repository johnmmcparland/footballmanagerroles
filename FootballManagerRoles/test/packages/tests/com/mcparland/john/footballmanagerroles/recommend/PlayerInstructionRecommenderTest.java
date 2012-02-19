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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeCategory;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.OutfieldPlayerAttribute;
import com.mcparland.john.footballmanagerroles.data.exceptions.AttributeAlreadySetException;
import com.mcparland.john.footballmanagerroles.data.exceptions.PlayerInstructionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.people.FootballPlayer;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionsImpl;
import com.mcparland.john.footballmanagerroles.data.roles.Role;
import com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation;
import com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommender;
import com.mcparland.john.footballmanagerroles.recommend.Recommender;

/**
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommender}
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
public class PlayerInstructionRecommenderTest {

    /**
     * The Player Instruction Recommender to test
     */
    private PlayerInstructionRecommender recommender = null;

    /**
     * Set the Recommender to use
     * 
     * @param recommender
     *            The Recommender
     */
    @Autowired
    public void setRecommender(Recommender<?> recommender) {
        if (recommender instanceof PlayerInstructionRecommender) {
            this.recommender = (PlayerInstructionRecommender) recommender;
        } else {
            throw new IllegalArgumentException("Expected a PlayerInstructionRecommender, got a "
                    + recommender.getClass());
        }
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommender#recommend(com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions, com.mcparland.john.footballmanagerroles.data.people.Player)}
     * .
     */
    @Test
    public void testRecommend() {
        Collection<Attribute> keyAttributes = new ArrayList<Attribute>();
        keyAttributes.add(new OutfieldPlayerAttribute("Creativity", AttributeType.Mental, AttributeCategory.Attacking));
        keyAttributes.add(new OutfieldPlayerAttribute("Decisions", AttributeType.Mental, AttributeCategory.Tactics));
        keyAttributes.add(new OutfieldPlayerAttribute("First Touch", AttributeType.Technical,
                AttributeCategory.BallControl));
        keyAttributes.add(new OutfieldPlayerAttribute("Flair", AttributeType.Mental, AttributeCategory.BallControl));
        keyAttributes.add(new OutfieldPlayerAttribute("Passing", AttributeType.Technical, AttributeCategory.Attacking));
        keyAttributes.add(new OutfieldPlayerAttribute("Stamina", AttributeType.Physical, AttributeCategory.Strength));
        keyAttributes.add(new OutfieldPlayerAttribute("Teamwork", AttributeType.Mental, AttributeCategory.Tactics));
        keyAttributes.add(new OutfieldPlayerAttribute("Technique", AttributeType.Technical,
                AttributeCategory.BallControl));
        keyAttributes.add(new OutfieldPlayerAttribute("Work Rate", AttributeType.Mental, AttributeCategory.Strength));

        // Set all the key attributes to 10 so the rating will be 50%
        Player player = new FootballPlayer();
        for (Attribute attr : keyAttributes) {
            try {
                player.addAttribute(attr, 10);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                fail("IllegalArgumentException obtained unexpectedly: " + e.getMessage());
            } catch (AttributeAlreadySetException e) {
                e.printStackTrace();
                fail("AttributeAlreadySetException obtained unexpectedly: " + e.getMessage());
            }
        }

        PlayerInstruction instruction = new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Support, "AP_S");
        PlayerInstructions instructions = new PlayerInstructionsImpl();
        try {
            instructions.addPlayerInstruction(instruction);
        } catch (PlayerInstructionAlreadyAddedException e) {
            e.printStackTrace();
            fail("Unexpected PlayerInstructionAlreadyAddedException: " + e.getMessage());
        }
        Collection<PlayerInstructionRecommendation> recommendations = recommender.recommend(instructions, player)
                .getRecommendations();
        assertEquals(1, recommendations.size());

        final PlayerInstructionRecommendation advancedPlayermakerSupportRecommendation = new PlayerInstructionRecommendation(
                (new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Support, "AP_S")), 50);
        assertTrue(recommendations.contains(advancedPlayermakerSupportRecommendation));

    }
}
