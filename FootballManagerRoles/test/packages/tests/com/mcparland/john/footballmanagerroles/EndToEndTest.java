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
package tests.com.mcparland.john.footballmanagerroles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.FootballManagerRoles;
import com.mcparland.john.footballmanagerroles.data.access.AttributesService;
import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition;
import com.mcparland.john.footballmanagerroles.data.roles.Role;
import com.mcparland.john.footballmanagerroles.data.roles.Side;
import com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendation;
import com.mcparland.john.footballmanagerroles.recommend.PlayerInstructionRecommendations;
import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;

/**
 * End to end test of the application, from input from file through calculation
 * but analysing the output
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
public class EndToEndTest {

    /**
     * The FootballManagerRoles object being tested
     */
    private FootballManagerRoles footballManagerRoles = null;

    /**
     * The attributes service
     */
    private AttributesService attributesService = null;

    /**
     * The attributes
     */
    private Attributes attributes = null;

    /**
     * Set the FootballManagerRoles object to test
     * 
     * @param footballManagerRoles
     *            The object to test
     */
    @Autowired
    public void setFootballManagerRoles(FootballManagerRoles footballManagerRoles) {
        this.footballManagerRoles = footballManagerRoles;
    }

    /**
     * Set the attributes service
     * 
     * @param attributesService
     *            The attributes service
     */
    @Autowired
    public void setAttributesService(AttributesService attributesService) {
        this.attributesService = attributesService;
    }

    /**
     * Get the attributes service
     * 
     * @return The attributes service
     */
    public AttributesService getAttributesService() {
        return attributesService;
    }

    /**
     * Set up the tests
     */
    @Before
    public void setUp() {
        this.attributes = getAttributesService().getAttributes();
    }

    /**
     * End to end test for the first player
     */
    @Test
    public void testPlayerOne() {
        File file = new File("testFiles/1. Gianluigi Buffon.rtf");
        try {
            PlayerRecommendations playerRecommendations = footballManagerRoles.process(file);

            // Check the player
            Player player = playerRecommendations.getPlayer();
            assertEquals("Gianluigi Buffon", player.getName());
            assertEquals(1, player.getPositions().size());
            assertTrue(player.getPositions().contains((new PlayerPosition(PitchArea.Goalkeeper))));
            assertEquals("Juventus", player.getClub());
            assertEquals("Italy", player.getNationality());
            assertEquals("33 years old", player.getAge());
            assertEquals("105 caps / 0 goals", player.getInternationalStatus());
            assertEquals("28.1.1978", player.getDob());
            assertEquals("1.90 m", player.getHeight());
            assertEquals("Right Only", player.getPreferredFoot());
            assertEquals("80 kg", player.getMass());
            assertEquals("£175,000 per week", player.getWage());
            assertEquals("£11.5M", player.getValue());
            assertEquals("30.6.2013", player.getContractExpiry());

            Map<Attribute, Integer> attrs = player.getAttributes();
            // Goalkeeping
            assertEquals(17, attrs.get(attributes.getAttribute("Aerial Ability", AttributeType.Goalkeeping)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Command Of Area", AttributeType.Goalkeeping))
                    .intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Communication", AttributeType.Goalkeeping)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Eccentricity", AttributeType.Goalkeeping)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("First Touch", AttributeType.Goalkeeping)).intValue());
            assertEquals(1, attrs.get(attributes.getAttribute("Free Kick Taking", AttributeType.Goalkeeping))
                    .intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Handling", AttributeType.Goalkeeping)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Kicking", AttributeType.Goalkeeping)).intValue());
            assertEquals(18, attrs.get(attributes.getAttribute("One On Ones", AttributeType.Goalkeeping)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Penalty Taking", AttributeType.Goalkeeping)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Reflexes", AttributeType.Goalkeeping)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Rushing Out", AttributeType.Goalkeeping)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Tendency To Punch", AttributeType.Goalkeeping))
                    .intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Throwing", AttributeType.Goalkeeping)).intValue());

            // Mental
            assertEquals(11, attrs.get(attributes.getAttribute("Aggression", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Anticipation", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Bravery", AttributeType.Mental)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Composure", AttributeType.Mental)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Concentration", AttributeType.Mental)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Creativity", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Decisions", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Determination", AttributeType.Mental)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Flair", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Influence", AttributeType.Mental)).intValue());
            assertEquals(1, attrs.get(attributes.getAttribute("Off The Ball", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Positioning", AttributeType.Mental)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Teamwork", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Work Rate", AttributeType.Mental)).intValue());

            // Physical
            assertEquals(13, attrs.get(attributes.getAttribute("Acceleration", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Agility", AttributeType.Physical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Balance", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Jumping", AttributeType.Physical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Natural Fitness", AttributeType.Physical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Pace", AttributeType.Physical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Stamina", AttributeType.Physical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Strength", AttributeType.Physical)).intValue());

            // Check the recommendations
            PlayerInstructionRecommendation recommendation1 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Goalkeeper, Duty.Defend, "GK_D"), 79);
            PlayerInstructionRecommendation recommendation2 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.SweeperKeeper, Duty.Support, "SWK_DSA"), 73);
            PlayerInstructionRecommendation recommendation3 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.SweeperKeeper, Duty.Defend, "SWK_DSA"), 73);
            PlayerInstructionRecommendation recommendation4 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.SweeperKeeper, Duty.Attack, "SWK_DSA"), 73);
            PlayerInstructionRecommendations knownRecommendations = new PlayerInstructionRecommendations();
            knownRecommendations.addRecommendation(recommendation1);
            knownRecommendations.addRecommendation(recommendation2);
            knownRecommendations.addRecommendation(recommendation3);
            knownRecommendations.addRecommendation(recommendation4);

            assertEquals(knownRecommendations.getRecommendations().size(), playerRecommendations.getRecommendations()
                    .getRecommendations().size());
            for (PlayerInstructionRecommendation rec : knownRecommendations.getRecommendations()) {
                assertTrue(playerRecommendations.getRecommendations().getRecommendations().contains(rec));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Exception unexpectedly caught: " + ex.getMessage());
        }
    }
    
    /**
     * End to end test for the first player
     */
    @Test
    public void testPlayerTwo() {
        File file = new File("testFiles/5. Daniel Majstorovic.rtf");
        try {
            PlayerRecommendations playerRecommendations = footballManagerRoles.process(file);

            Player player = playerRecommendations.getPlayer();
            // Check the player
            assertEquals("Daniel Majstorovic", player.getName());
            assertEquals(2, player.getPositions().size());
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Defender, Side.Centre)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Sweeper)));
            assertEquals("Celtic", player.getClub());
            assertEquals("Sweden", player.getNationality());
            assertEquals("34 years old", player.getAge());
            assertEquals("41 caps / 2 goals", player.getInternationalStatus());
            assertEquals("5.5.1977", player.getDob());
            assertEquals("1.90 m", player.getHeight());
            assertEquals("Right", player.getPreferredFoot());
            assertEquals("89 kg", player.getMass());
            assertEquals("£7,000 per week", player.getWage());
            assertEquals("£275K", player.getValue());
            assertEquals("30.6.2012", player.getContractExpiry());

            Map<Attribute, Integer> attrs = player.getAttributes();
            // Technical
            assertEquals(7, attrs.get(attributes.getAttribute("Corners", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Crossing", AttributeType.Technical)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Dribbling", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Finishing", AttributeType.Technical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("First Touch", AttributeType.Technical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Free Kick Taking", AttributeType.Technical)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Heading", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Long Shots", AttributeType.Technical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Long Throws", AttributeType.Technical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Marking", AttributeType.Technical)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Passing", AttributeType.Technical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Penalty Taking", AttributeType.Technical)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Tackling", AttributeType.Technical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Technique", AttributeType.Technical)).intValue());

            // Mental
            assertEquals(10, attrs.get(attributes.getAttribute("Aggression", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Anticipation", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Bravery", AttributeType.Mental)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Composure", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Concentration", AttributeType.Mental)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Creativity", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Decisions", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Determination", AttributeType.Mental)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Flair", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Influence", AttributeType.Mental)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Off The Ball", AttributeType.Mental)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Positioning", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Teamwork", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Work Rate", AttributeType.Mental)).intValue());

            // Physical
            assertEquals(8, attrs.get(attributes.getAttribute("Acceleration", AttributeType.Physical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Agility", AttributeType.Physical)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Balance", AttributeType.Physical)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Jumping", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Natural Fitness", AttributeType.Physical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Pace", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Stamina", AttributeType.Physical)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Strength", AttributeType.Physical)).intValue());
            // Check the recommendations

            PlayerInstructionRecommendation recommendation1 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D"), 74);
            PlayerInstructionRecommendation recommendation2 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CentralDefender, Duty.Stopper, "CD_S"), 71);
            PlayerInstructionRecommendation recommendation3 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CentralDefender, Duty.Cover, "CD_C"), 71);
            PlayerInstructionRecommendation recommendation4 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.BallPlayingDefender, Duty.Defend, "BPD_D"), 68);
            PlayerInstructionRecommendation recommendation5 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.BallPlayingDefender, Duty.Stopper, "BPD_S"), 67);
            PlayerInstructionRecommendation recommendation6 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.BallPlayingDefender, Duty.Cover, "BPD_C"), 67);
            PlayerInstructionRecommendation recommendation7 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.LimitedDefender, Duty.Defend, "LD_D"), 79);
            PlayerInstructionRecommendation recommendation8 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.LimitedDefender, Duty.Stopper, "LD_S"), 74);
            PlayerInstructionRecommendation recommendation9 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.LimitedDefender, Duty.Cover, "LD_C"), 74);
            PlayerInstructionRecommendation recommendation10 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Libero, Duty.Support, "L_S"), 65);
            PlayerInstructionRecommendation recommendation11 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Libero, Duty.Attack, "L_A"), 63);
            PlayerInstructionRecommendation recommendation12 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Sweeper, Duty.Defend, "SW_D"), 68);
            
            PlayerInstructionRecommendations knownRecommendations = new PlayerInstructionRecommendations();
            knownRecommendations.addRecommendation(recommendation1);
            knownRecommendations.addRecommendation(recommendation2);
            knownRecommendations.addRecommendation(recommendation3);
            knownRecommendations.addRecommendation(recommendation4);
            knownRecommendations.addRecommendation(recommendation5);
            knownRecommendations.addRecommendation(recommendation6);
            knownRecommendations.addRecommendation(recommendation7);
            knownRecommendations.addRecommendation(recommendation8);
            knownRecommendations.addRecommendation(recommendation9);
            knownRecommendations.addRecommendation(recommendation10);
            knownRecommendations.addRecommendation(recommendation11);
            knownRecommendations.addRecommendation(recommendation12);
            
            assertEquals(knownRecommendations.getRecommendations().size(), playerRecommendations.getRecommendations()
                    .getRecommendations().size());
            for (PlayerInstructionRecommendation rec : knownRecommendations.getRecommendations()) {
                assertTrue(playerRecommendations.getRecommendations().getRecommendations().contains(rec));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Exception unexpectedly caught: " + ex.getMessage());
        }
    }
}
