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
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.FootballManagerRoles}
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
public class FootballManagerRolesTest {

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
     * Test method for {@link FootballManagerRoles#process(File)} for the first
     * player
     */
    @Test
    public void testProcess_PlayerOne() {
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
     * Test for {@link FootballManagerRoles#process(File)} for player two
     */
    @Test
    public void testProcess_PlayerTwo() {
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

    /**
     * Test for {@link FootballManagerRoles#process(File)} for player three
     */
    @Test
    public void testProcess_PlayerThree() {
        File file = new File("testFiles/10. Lionel Messi.rtf");
        try {
            PlayerRecommendations playerRecommendations = footballManagerRoles.process(file);

            Player player = playerRecommendations.getPlayer();
            // Check the player
            assertEquals("Lionel Messi", player.getName());
            assertEquals(6, player.getPositions().size());
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.AttackingMidfielder, Side.Centre)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Midfielder, Side.Right)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Midfielder, Side.Left)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.AttackingMidfielder, Side.Right)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.AttackingMidfielder, Side.Left)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Striker)));
            assertEquals("Barcelona", player.getClub());
            assertEquals("Argentina", player.getNationality());
            assertEquals("23 years old", player.getAge());
            assertEquals("50 caps / 13 goals", player.getInternationalStatus());
            assertEquals("24.6.1987", player.getDob());
            assertEquals("1.70 m", player.getHeight());
            assertEquals("Left", player.getPreferredFoot());
            assertEquals("67 kg", player.getMass());
            assertEquals("£275,000 per week", player.getWage());
            assertEquals("£35,500,000", player.getValue());
            assertEquals("30.6.2016", player.getContractExpiry());

            Map<Attribute, Integer> attrs = player.getAttributes();
            // Technical
            assertEquals(12, attrs.get(attributes.getAttribute("Corners", AttributeType.Technical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Crossing", AttributeType.Technical)).intValue());
            assertEquals(20, attrs.get(attributes.getAttribute("Dribbling", AttributeType.Technical)).intValue());
            assertEquals(18, attrs.get(attributes.getAttribute("Finishing", AttributeType.Technical)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("First Touch", AttributeType.Technical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Free Kick Taking", AttributeType.Technical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Heading", AttributeType.Technical)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Long Shots", AttributeType.Technical)).intValue());
            assertEquals(5, attrs.get(attributes.getAttribute("Long Throws", AttributeType.Technical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Marking", AttributeType.Technical)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Passing", AttributeType.Technical)).intValue());
            assertEquals(18, attrs.get(attributes.getAttribute("Penalty Taking", AttributeType.Technical)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Tackling", AttributeType.Technical)).intValue());
            assertEquals(20, attrs.get(attributes.getAttribute("Technique", AttributeType.Technical)).intValue());

            // Mental
            assertEquals(7, attrs.get(attributes.getAttribute("Aggression", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Anticipation", AttributeType.Mental)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Bravery", AttributeType.Mental)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Composure", AttributeType.Mental)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Concentration", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Creativity", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Decisions", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Determination", AttributeType.Mental)).intValue());
            assertEquals(20, attrs.get(attributes.getAttribute("Flair", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Influence", AttributeType.Mental)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Off The Ball", AttributeType.Mental)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Positioning", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Teamwork", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Work Rate", AttributeType.Mental)).intValue());

            // Physical
            assertEquals(18, attrs.get(attributes.getAttribute("Acceleration", AttributeType.Physical)).intValue());
            assertEquals(20, attrs.get(attributes.getAttribute("Agility", AttributeType.Physical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Balance", AttributeType.Physical)).intValue());
            assertEquals(5, attrs.get(attributes.getAttribute("Jumping", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Natural Fitness", AttributeType.Physical)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Pace", AttributeType.Physical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Stamina", AttributeType.Physical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Strength", AttributeType.Physical)).intValue());

            // Check the recommendations
            PlayerInstructionRecommendation recommendation1 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Attack, "AP_A"), 86);
            PlayerInstructionRecommendation recommendation2 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Support, "AP_S"), 81);
            PlayerInstructionRecommendation recommendation3 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Attack, "AM_A"), 87);
            PlayerInstructionRecommendation recommendation4 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Support, "AM_S"), 81);
            PlayerInstructionRecommendation recommendation5 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.InsideForward, Duty.Attack, "IF_A"), 84);
            PlayerInstructionRecommendation recommendation6 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.InsideForward, Duty.Support, "IF_S"), 86);
            PlayerInstructionRecommendation recommendation7 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Trequartista, Duty.Attack, "T_A"), 89);
            PlayerInstructionRecommendation recommendation8 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Attack, "DW_SA"), 69);
            PlayerInstructionRecommendation recommendation9 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Support, "DW_SA"), 69);
            PlayerInstructionRecommendation recommendation10 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Support, "W_SA"), 88);
            PlayerInstructionRecommendation recommendation11 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Attack, "W_SA"), 88);
            PlayerInstructionRecommendation recommendation12 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Attack, "WM_DSAAu"), 72);
            PlayerInstructionRecommendation recommendation13 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Support, "WM_DSAAu"), 72);
            PlayerInstructionRecommendation recommendation14 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Automatic, "WM_DSAAu"), 72);
            PlayerInstructionRecommendation recommendation15 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Defend, "WM_DSAAu"), 72);
            PlayerInstructionRecommendation recommendation16 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AdvancedForward, Duty.Attack, "AF_A"), 79);
            PlayerInstructionRecommendation recommendation17 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CompleteForward, Duty.Attack, "CF_SA"), 77);
            PlayerInstructionRecommendation recommendation18 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CompleteForward, Duty.Support, "CF_SA"), 77);
            PlayerInstructionRecommendation recommendation19 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DeepLyingForward, Duty.Attack, "DLF_A"), 85);
            PlayerInstructionRecommendation recommendation20 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DeepLyingForward, Duty.Support, "DLF_S"), 79);
            PlayerInstructionRecommendation recommendation21 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveForward, Duty.Attack, "DF_A"), 63);
            PlayerInstructionRecommendation recommendation22 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveForward, Duty.Support, "DF_S"), 62);
            PlayerInstructionRecommendation recommendation23 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.TargetMan, Duty.Attack, "TM_A"), 63);
            PlayerInstructionRecommendation recommendation24 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.TargetMan, Duty.Support, "TM_S"), 57);
            PlayerInstructionRecommendation recommendation25 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Poacher, Duty.Attack, "P_A"), 86);

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
            knownRecommendations.addRecommendation(recommendation13);
            knownRecommendations.addRecommendation(recommendation14);
            knownRecommendations.addRecommendation(recommendation15);
            knownRecommendations.addRecommendation(recommendation16);
            knownRecommendations.addRecommendation(recommendation17);
            knownRecommendations.addRecommendation(recommendation18);
            knownRecommendations.addRecommendation(recommendation19);
            knownRecommendations.addRecommendation(recommendation20);
            knownRecommendations.addRecommendation(recommendation21);
            knownRecommendations.addRecommendation(recommendation22);
            knownRecommendations.addRecommendation(recommendation23);
            knownRecommendations.addRecommendation(recommendation24);
            knownRecommendations.addRecommendation(recommendation25);

            assertEquals(knownRecommendations.getRecommendations().size(), playerRecommendations.getRecommendations()
                    .getRecommendations().size());

            for (PlayerInstructionRecommendation rec : knownRecommendations.getRecommendations()) {
                assertTrue("Failure on: " + rec, playerRecommendations.getRecommendations().getRecommendations()
                        .contains(rec));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Exception unexpectedly caught: " + ex.getMessage());
        }
    }

    /**
     * Test for {@link FootballManagerRoles#process(File)} for player four
     */
    @Test
    public void testProcess_PlayerFour() {
        File file = new File("testFiles/2. Adam Matthews.rtf");
        try {
            PlayerRecommendations playerRecommendations = footballManagerRoles.process(file);

            Player player = playerRecommendations.getPlayer();
            // Check the player
            assertEquals("Adam Matthews", player.getName());
            assertEquals(3, player.getPositions().size());
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Defender, Side.Right)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Defender, Side.Left)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Midfielder, Side.Right)));
            assertEquals("Celtic", player.getClub());
            assertEquals("Wales", player.getNationality());
            assertEquals("21 years old", player.getAge());
            assertEquals("3 caps / 0 goals", player.getInternationalStatus());
            assertEquals("13.1.1992", player.getDob());
            assertEquals("1.78 m", player.getHeight());
            assertEquals("Right", player.getPreferredFoot());
            assertEquals("70 kg", player.getMass());
            assertEquals("£4,000 per week", player.getWage());
            assertEquals("£600K", player.getValue());
            assertEquals("30.6.2015", player.getContractExpiry());

            Map<Attribute, Integer> attrs = player.getAttributes();
            // Technical
            assertEquals(11, attrs.get(attributes.getAttribute("Corners", AttributeType.Technical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Crossing", AttributeType.Technical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Dribbling", AttributeType.Technical)).intValue());
            assertEquals(5, attrs.get(attributes.getAttribute("Finishing", AttributeType.Technical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("First Touch", AttributeType.Technical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Free Kick Taking", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Heading", AttributeType.Technical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Long Shots", AttributeType.Technical)).intValue());
            assertEquals(16, attrs.get(attributes.getAttribute("Long Throws", AttributeType.Technical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Marking", AttributeType.Technical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Passing", AttributeType.Technical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Penalty Taking", AttributeType.Technical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Tackling", AttributeType.Technical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Technique", AttributeType.Technical)).intValue());

            // Mental
            assertEquals(9, attrs.get(attributes.getAttribute("Aggression", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Anticipation", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Bravery", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Composure", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Concentration", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Creativity", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Decisions", AttributeType.Mental)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Determination", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Flair", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Influence", AttributeType.Mental)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Off The Ball", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Positioning", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Teamwork", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Work Rate", AttributeType.Mental)).intValue());

            // Physical
            assertEquals(14, attrs.get(attributes.getAttribute("Acceleration", AttributeType.Physical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Agility", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Balance", AttributeType.Physical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Jumping", AttributeType.Physical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Natural Fitness", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Pace", AttributeType.Physical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Stamina", AttributeType.Physical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Strength", AttributeType.Physical)).intValue());

            // Check the recommendations
            PlayerInstructionRecommendation recommendation1 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Attack, "FB_A"), 62);
            PlayerInstructionRecommendation recommendation2 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Automatic, "FB_SAu"), 62);
            PlayerInstructionRecommendation recommendation3 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Support, "FB_SAu"), 62);
            PlayerInstructionRecommendation recommendation4 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Defend, "FB_D"), 61);
            PlayerInstructionRecommendation recommendation5 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Attack, "WB_A"), 63);
            PlayerInstructionRecommendation recommendation6 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Automatic, "WB_SAu"), 63);
            PlayerInstructionRecommendation recommendation7 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Support, "WB_SAu"), 63);
            PlayerInstructionRecommendation recommendation8 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Defend, "WB_D"), 62);
            PlayerInstructionRecommendation recommendation9 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Attack, "DW_SA"), 64);
            PlayerInstructionRecommendation recommendation10 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Support, "DW_SA"), 64);
            PlayerInstructionRecommendation recommendation11 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Attack, "WM_DSAAu"), 63);
            PlayerInstructionRecommendation recommendation12 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Automatic, "WM_DSAAu"), 63);
            PlayerInstructionRecommendation recommendation13 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Support, "WM_DSAAu"), 63);
            PlayerInstructionRecommendation recommendation14 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Defend, "WM_DSAAu"), 63);
            PlayerInstructionRecommendation recommendation15 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Attack, "W_SA"), 65);
            PlayerInstructionRecommendation recommendation16 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Support, "W_SA"), 65);

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
            knownRecommendations.addRecommendation(recommendation13);
            knownRecommendations.addRecommendation(recommendation14);
            knownRecommendations.addRecommendation(recommendation15);
            knownRecommendations.addRecommendation(recommendation16);

            assertEquals(knownRecommendations.getRecommendations().size(), playerRecommendations.getRecommendations()
                    .getRecommendations().size());

            for (PlayerInstructionRecommendation rec : knownRecommendations.getRecommendations()) {
                assertTrue("Failure on: " + rec, playerRecommendations.getRecommendations().getRecommendations()
                        .contains(rec));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Exception unexpectedly caught: " + ex.getMessage());
        }
    }

    /**
     * Test for {@link FootballManagerRoles#process(File)} for player five
     */
    @Test
    public void testProcess_PlayerFive() {
        File file = new File("testFiles/8. Scott Brown.rtf");
        try {
            PlayerRecommendations playerRecommendations = footballManagerRoles.process(file);

            Player player = playerRecommendations.getPlayer();
            // Check the player
            assertEquals("Scott Brown", player.getName());
            assertEquals(2, player.getPositions().size());
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Midfielder, Side.Centre)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Midfielder, Side.Right)));
            assertEquals("Celtic", player.getClub());
            assertEquals("Scotland", player.getNationality());
            assertEquals("28 years old", player.getAge());
            assertEquals("35 caps / 2 goals", player.getInternationalStatus());
            assertEquals("25.6.1985", player.getDob());
            assertEquals("1.78 m", player.getHeight());
            assertEquals("Right", player.getPreferredFoot());
            assertEquals("71 kg", player.getMass());
            assertEquals("£35,000 per week", player.getWage());
            assertEquals("£1.8M", player.getValue());
            assertEquals("31.5.2015", player.getContractExpiry());

            Map<Attribute, Integer> attrs = player.getAttributes();
            // Technical
            assertEquals(7, attrs.get(attributes.getAttribute("Corners", AttributeType.Technical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Crossing", AttributeType.Technical)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Dribbling", AttributeType.Technical)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Finishing", AttributeType.Technical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("First Touch", AttributeType.Technical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Free Kick Taking", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Heading", AttributeType.Technical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Long Shots", AttributeType.Technical)).intValue());
            assertEquals(4, attrs.get(attributes.getAttribute("Long Throws", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Marking", AttributeType.Technical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Passing", AttributeType.Technical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Penalty Taking", AttributeType.Technical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Tackling", AttributeType.Technical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Technique", AttributeType.Technical)).intValue());

            // Mental
            assertEquals(15, attrs.get(attributes.getAttribute("Aggression", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Anticipation", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Bravery", AttributeType.Mental)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Composure", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Concentration", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Creativity", AttributeType.Mental)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Decisions", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Determination", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Flair", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Influence", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Off The Ball", AttributeType.Mental)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Positioning", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Teamwork", AttributeType.Mental)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Work Rate", AttributeType.Mental)).intValue());

            // Physical
            assertEquals(15, attrs.get(attributes.getAttribute("Acceleration", AttributeType.Physical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Agility", AttributeType.Physical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Balance", AttributeType.Physical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Jumping", AttributeType.Physical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Natural Fitness", AttributeType.Physical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Pace", AttributeType.Physical)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Stamina", AttributeType.Physical)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Strength", AttributeType.Physical)).intValue());

            // Check the recommendations
            PlayerInstructionRecommendation recommendation1 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Support, "CM_SAu"), 62);
            PlayerInstructionRecommendation recommendation2 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Automatic, "CM_SAu"), 62);
            PlayerInstructionRecommendation recommendation3 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Defend, "CM_D"), 60);
            PlayerInstructionRecommendation recommendation4 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Attack, "CM_A"), 64);
            PlayerInstructionRecommendation recommendation5 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DeepLyingPlaymaker, Duty.Defend, "DLP_D"), 56);
            PlayerInstructionRecommendation recommendation6 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DeepLyingPlaymaker, Duty.Support, "DLP_S"), 59);
            PlayerInstructionRecommendation recommendation7 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.BallWinningMidfielder, Duty.Defend, "BWM_D"), 69);
            PlayerInstructionRecommendation recommendation8 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.BallWinningMidfielder, Duty.Support, "BWM_S"), 71);
            PlayerInstructionRecommendation recommendation9 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.BoxToBoxMidfielder, Duty.Support, "B2BM_S"), 62);
            PlayerInstructionRecommendation recommendation10 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Support, "AP_S"), 67);
            PlayerInstructionRecommendation recommendation11 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Attack, "AP_A"), 62);
            PlayerInstructionRecommendation recommendation12 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Attack, "DW_SA"), 63);
            PlayerInstructionRecommendation recommendation13 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Support, "DW_SA"), 63);
            PlayerInstructionRecommendation recommendation14 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Attack, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation15 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Automatic, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation16 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Support, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation17 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Defend, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation18 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Attack, "W_SA"), 63);
            PlayerInstructionRecommendation recommendation19 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Support, "W_SA"), 63);

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
            knownRecommendations.addRecommendation(recommendation13);
            knownRecommendations.addRecommendation(recommendation14);
            knownRecommendations.addRecommendation(recommendation15);
            knownRecommendations.addRecommendation(recommendation16);
            knownRecommendations.addRecommendation(recommendation17);
            knownRecommendations.addRecommendation(recommendation18);
            knownRecommendations.addRecommendation(recommendation19);

            assertEquals(knownRecommendations.getRecommendations().size(), playerRecommendations.getRecommendations()
                    .getRecommendations().size());

            for (PlayerInstructionRecommendation rec : knownRecommendations.getRecommendations()) {
                assertTrue("Failure on: " + rec, playerRecommendations.getRecommendations().getRecommendations()
                        .contains(rec));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Exception unexpectedly caught: " + ex.getMessage());
        }
    }

    /**
     * Test for {@link FootballManagerRoles#process(File)} for player six
     */
    @Test
    public void testProcess_PlayerSix() {
        File file = new File("testFiles/János Tóth.rtf");
        try {
            PlayerRecommendations playerRecommendations = footballManagerRoles.process(file);

            Player player = playerRecommendations.getPlayer();
            // Check the player
            assertEquals("János Tóth", player.getName());
            assertEquals(3, player.getPositions().size());
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.AttackingMidfielder, Side.Left)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.WingBack, Side.Left)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Midfielder, Side.Left)));
            assertEquals("Fót", player.getClub());
            assertEquals("Hungary", player.getNationality());
            assertEquals("16 years old", player.getAge());
            assertEquals("Uncapped", player.getInternationalStatus());
            assertEquals("2.6.1997", player.getDob());
            assertEquals("1.77 m", player.getHeight());
            assertEquals("Left Only", player.getPreferredFoot());
            assertEquals("67 kg", player.getMass());
            assertEquals("N/A", player.getWage());
            assertEquals("-", player.getValue());
            assertEquals("N/A", player.getContractExpiry());

            Map<Attribute, Integer> attrs = player.getAttributes();
            // Technical
            assertEquals(8, attrs.get(attributes.getAttribute("Corners", AttributeType.Technical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Crossing", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Dribbling", AttributeType.Technical)).intValue());
            assertEquals(4, attrs.get(attributes.getAttribute("Finishing", AttributeType.Technical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("First Touch", AttributeType.Technical)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Free Kick Taking", AttributeType.Technical)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Heading", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Long Shots", AttributeType.Technical)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Long Throws", AttributeType.Technical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Marking", AttributeType.Technical)).intValue());
            assertEquals(4, attrs.get(attributes.getAttribute("Passing", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Penalty Taking", AttributeType.Technical)).intValue());
            assertEquals(2, attrs.get(attributes.getAttribute("Tackling", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Technique", AttributeType.Technical)).intValue());

            // Mental
            assertEquals(14, attrs.get(attributes.getAttribute("Aggression", AttributeType.Mental)).intValue());
            assertEquals(5, attrs.get(attributes.getAttribute("Anticipation", AttributeType.Mental)).intValue());
            assertEquals(4, attrs.get(attributes.getAttribute("Bravery", AttributeType.Mental)).intValue());
            assertEquals(5, attrs.get(attributes.getAttribute("Composure", AttributeType.Mental)).intValue());
            assertEquals(4, attrs.get(attributes.getAttribute("Concentration", AttributeType.Mental)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Creativity", AttributeType.Mental)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Decisions", AttributeType.Mental)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Determination", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Flair", AttributeType.Mental)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Influence", AttributeType.Mental)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Off The Ball", AttributeType.Mental)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Positioning", AttributeType.Mental)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Teamwork", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Work Rate", AttributeType.Mental)).intValue());

            // Physical
            assertEquals(12, attrs.get(attributes.getAttribute("Acceleration", AttributeType.Physical)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Agility", AttributeType.Physical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Balance", AttributeType.Physical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Jumping", AttributeType.Physical)).intValue());
            assertEquals(17, attrs.get(attributes.getAttribute("Natural Fitness", AttributeType.Physical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Pace", AttributeType.Physical)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Stamina", AttributeType.Physical)).intValue());
            assertEquals(2, attrs.get(attributes.getAttribute("Strength", AttributeType.Physical)).intValue());

            // Check the recommendations
            PlayerInstructionRecommendation recommendation1 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Defend, "WB_D"), 36);
            PlayerInstructionRecommendation recommendation2 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Support, "WB_SAu"), 37);
            PlayerInstructionRecommendation recommendation3 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Automatic, "WB_SAu"), 37);
            PlayerInstructionRecommendation recommendation4 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Attack, "WB_A"), 37);

            PlayerInstructionRecommendation recommendation5 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Attack, "DW_SA"), 38);
            PlayerInstructionRecommendation recommendation6 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Support, "DW_SA"), 38);
            PlayerInstructionRecommendation recommendation7 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Attack, "WM_DSAAu"), 36);
            PlayerInstructionRecommendation recommendation8 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Automatic, "WM_DSAAu"), 36);
            PlayerInstructionRecommendation recommendation9 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Support, "WM_DSAAu"), 36);
            PlayerInstructionRecommendation recommendation10 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Defend, "WM_DSAAu"), 36);
            PlayerInstructionRecommendation recommendation11 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Attack, "W_SA"), 42);
            PlayerInstructionRecommendation recommendation12 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Support, "W_SA"), 42);

            PlayerInstructionRecommendation recommendation13 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Attack, "AP_A"), 36);
            PlayerInstructionRecommendation recommendation14 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Support, "AP_S"), 39);
            PlayerInstructionRecommendation recommendation15 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.InsideForward, Duty.Attack, "IF_A"), 40);
            PlayerInstructionRecommendation recommendation16 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.InsideForward, Duty.Support, "IF_S"), 41);

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
            knownRecommendations.addRecommendation(recommendation13);
            knownRecommendations.addRecommendation(recommendation14);
            knownRecommendations.addRecommendation(recommendation15);
            knownRecommendations.addRecommendation(recommendation16);

            assertEquals(knownRecommendations.getRecommendations().size(), playerRecommendations.getRecommendations()
                    .getRecommendations().size());

            for (PlayerInstructionRecommendation rec : knownRecommendations.getRecommendations()) {
                assertTrue("Failure on: " + rec, playerRecommendations.getRecommendations().getRecommendations()
                        .contains(rec));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Exception unexpectedly caught: " + ex.getMessage());
        }
    }

    /**
     * Test for {@link FootballManagerRoles#process(File)} for player seven
     */
  //  @Test
    public void testProcess_PlayerSeven() {
        File file = new File("testFiles/Sergio Romero.rtf");
        try {
            PlayerRecommendations playerRecommendations = footballManagerRoles.process(file);

            Player player = playerRecommendations.getPlayer();
            // Check the player
            assertEquals("Sergio Romero", player.getName());
            assertEquals(4, player.getPositions().size());
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Defender, Side.Left)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.WingBack, Side.Left)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.DefensiveMidfielder)));
            assertTrue(player.getPositions().contains(new PlayerPosition(PitchArea.Midfielder, Side.Left)));
            assertEquals("", player.getClub());
            assertEquals("Spain", player.getNationality());
            assertEquals("21 years old", player.getAge());
            assertEquals("Uncapped", player.getInternationalStatus());
            assertEquals("2.11.1991", player.getDob());
            assertEquals("1.77 m", player.getHeight());
            assertEquals("Left Only", player.getPreferredFoot());
            assertEquals("71 kg", player.getMass());
            assertEquals("N/A", player.getWage());
            assertEquals("-", player.getValue());
            assertEquals("N/A", player.getContractExpiry());

            Map<Attribute, Integer> attrs = player.getAttributes();
            // Technical
            assertEquals(9, attrs.get(attributes.getAttribute("Corners", AttributeType.Technical)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Crossing", AttributeType.Technical)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Dribbling", AttributeType.Technical)).intValue());
            assertEquals(20, attrs.get(attributes.getAttribute("Finishing", AttributeType.Technical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("First Touch", AttributeType.Technical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Free Kick Taking", AttributeType.Technical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Heading", AttributeType.Technical)).intValue());
            assertEquals(4, attrs.get(attributes.getAttribute("Long Shots", AttributeType.Technical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Long Throws", AttributeType.Technical)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Marking", AttributeType.Technical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Passing", AttributeType.Technical)).intValue());
            assertEquals(3, attrs.get(attributes.getAttribute("Penalty Taking", AttributeType.Technical)).intValue());
            assertEquals(2, attrs.get(attributes.getAttribute("Tackling", AttributeType.Technical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Technique", AttributeType.Technical)).intValue());

            // Mental
            assertEquals(1, attrs.get(attributes.getAttribute("Aggression", AttributeType.Mental)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Anticipation", AttributeType.Mental)).intValue());
            assertEquals(1, attrs.get(attributes.getAttribute("Bravery", AttributeType.Mental)).intValue());
            assertEquals(1, attrs.get(attributes.getAttribute("Composure", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Concentration", AttributeType.Mental)).intValue());
            assertEquals(8, attrs.get(attributes.getAttribute("Creativity", AttributeType.Mental)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Decisions", AttributeType.Mental)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Determination", AttributeType.Mental)).intValue());
            assertEquals(15, attrs.get(attributes.getAttribute("Flair", AttributeType.Mental)).intValue());
            assertEquals(12, attrs.get(attributes.getAttribute("Influence", AttributeType.Mental)).intValue());
            assertEquals(20, attrs.get(attributes.getAttribute("Off The Ball", AttributeType.Mental)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Positioning", AttributeType.Mental)).intValue());
            assertEquals(14, attrs.get(attributes.getAttribute("Teamwork", AttributeType.Mental)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Work Rate", AttributeType.Mental)).intValue());

            // Physical
            assertEquals(19, attrs.get(attributes.getAttribute("Acceleration", AttributeType.Physical)).intValue());
            assertEquals(9, attrs.get(attributes.getAttribute("Agility", AttributeType.Physical)).intValue());
            assertEquals(13, attrs.get(attributes.getAttribute("Balance", AttributeType.Physical)).intValue());
            assertEquals(18, attrs.get(attributes.getAttribute("Jumping", AttributeType.Physical)).intValue());
            assertEquals(6, attrs.get(attributes.getAttribute("Natural Fitness", AttributeType.Physical)).intValue());
            assertEquals(10, attrs.get(attributes.getAttribute("Pace", AttributeType.Physical)).intValue());
            assertEquals(11, attrs.get(attributes.getAttribute("Stamina", AttributeType.Physical)).intValue());
            assertEquals(7, attrs.get(attributes.getAttribute("Strength", AttributeType.Physical)).intValue());

            // Check the recommendations
            PlayerInstructionRecommendation recommendation1 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Attack, "FB_A"), 62);
            PlayerInstructionRecommendation recommendation2 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Automatic, "FB_SAu"), 62);
            PlayerInstructionRecommendation recommendation3 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Support, "FB_SAu"), 60);
            PlayerInstructionRecommendation recommendation4 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Defend, "FB_D"), 64);
            PlayerInstructionRecommendation recommendation5 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Defend, "WB_D"), 56);
            PlayerInstructionRecommendation recommendation6 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Support, "WB_SAu"), 59);
            PlayerInstructionRecommendation recommendation7 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Automatic, "WB_SAu"), 69);
            PlayerInstructionRecommendation recommendation8 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Attack, "WB_A"), 71);

            PlayerInstructionRecommendation recommendation9 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveMidfielder, Duty.Defend, "DM_D"), 62);
            PlayerInstructionRecommendation recommendation10 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveMidfielder, Duty.Support, "DM_S"), 67);
            PlayerInstructionRecommendation recommendation11 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DeepLyingPlaymaker, Duty.Defend, "DLP_D"), 56);
            PlayerInstructionRecommendation recommendation12 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DeepLyingPlaymaker, Duty.Support, "DLP_S"), 59);
            PlayerInstructionRecommendation recommendation13 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.AnchorMan, Duty.Defend, "AM_D"), 59);

            PlayerInstructionRecommendation recommendation14 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Attack, "DW_SA"), 63);
            PlayerInstructionRecommendation recommendation15 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Support, "DW_SA"), 63);
            PlayerInstructionRecommendation recommendation16 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Attack, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation17 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Automatic, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation18 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Support, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation19 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Defend, "WM_DSAAu"), 66);
            PlayerInstructionRecommendation recommendation20 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Attack, "W_SA"), 63);
            PlayerInstructionRecommendation recommendation21 = new PlayerInstructionRecommendation(
                    new PlayerInstructionImpl(Role.Winger, Duty.Support, "W_SA"), 63);

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
            knownRecommendations.addRecommendation(recommendation13);
            knownRecommendations.addRecommendation(recommendation14);
            knownRecommendations.addRecommendation(recommendation15);
            knownRecommendations.addRecommendation(recommendation16);
            knownRecommendations.addRecommendation(recommendation17);
            knownRecommendations.addRecommendation(recommendation18);
            knownRecommendations.addRecommendation(recommendation19);
            knownRecommendations.addRecommendation(recommendation20);
            knownRecommendations.addRecommendation(recommendation21);

            assertEquals(knownRecommendations.getRecommendations().size(), playerRecommendations.getRecommendations()
                    .getRecommendations().size());

            for (PlayerInstructionRecommendation rec : knownRecommendations.getRecommendations()) {
                assertTrue("Failure on: " + rec, playerRecommendations.getRecommendations().getRecommendations()
                        .contains(rec));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Exception unexpectedly caught: " + ex.getMessage());
        }
    }
}
