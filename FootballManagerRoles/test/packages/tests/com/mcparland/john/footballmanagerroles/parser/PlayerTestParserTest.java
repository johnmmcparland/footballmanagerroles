/**
 * 
 */
package tests.com.mcparland.john.footballmanagerroles.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.data.access.AttributesService;
import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.exceptions.ParseException;
import com.mcparland.john.footballmanagerroles.data.people.FootballPlayer;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition;
import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.data.roles.Side;
import com.mcparland.john.footballmanagerroles.parser.PlayerTextParser;

/**
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.parser.PlayerTextParser}
 * 
 * @author John
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class PlayerTestParserTest {

    /**
     * The attributes service
     */
    private AttributesService attributesService = null;

    /**
     * The attributes
     */
    private Attributes attributes = null;

    /**
     * The PlayerTextParser to use
     */
    private PlayerTextParser parser = null;

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
    public AttributesService getAttributes() {
        return attributesService;
    }

    /**
     * Get the parser
     * 
     * @return The parser to use
     */
    public PlayerTextParser getParser() {
        return parser;
    }

    /**
     * Set the parser
     * 
     * @param parser
     *            The parser to use
     */
    @Autowired
    public void setParser(PlayerTextParser parser) {
        this.parser = parser;
    }

    /**
     * Setup the tests
     */
    @Before
    public void setUp() {
        parser.setAttributes(attributesService.getAttributes());
        attributes = attributesService.getAttributes();
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.parser.PlayerTextParser#readPositions(java.lang.String)}
     * .
     */
    @Test
    public void testReadPositions() {
        // Positions for comparison
        // GK based
        final Position goalkeeper = new PlayerPosition(PitchArea.Goalkeeper);
        // Sweeper based
        final Position sweeper = new PlayerPosition(PitchArea.Sweeper);
        // Defender based
        final Position defender_right = new PlayerPosition(PitchArea.Defender, Side.Right);
        final Position defender_left = new PlayerPosition(PitchArea.Defender, Side.Left);
        final Position defender_centre = new PlayerPosition(PitchArea.Defender, Side.Centre);
        // Wing back based
        final Position wingback_right = new PlayerPosition(PitchArea.WingBack, Side.Right);
        final Position wingback_left = new PlayerPosition(PitchArea.WingBack, Side.Left);
        // Defensive midfield based
        final Position defensive_midfielder = new PlayerPosition(PitchArea.DefensiveMidfielder);
        // Midfield based
        final Position midfielder_centre = new PlayerPosition(PitchArea.Midfielder, Side.Centre);
        final Position midfielder_right = new PlayerPosition(PitchArea.Midfielder, Side.Right);
        final Position midfielder_left = new PlayerPosition(PitchArea.Midfielder, Side.Left);
        // Attacking midfield based
        final Position attacking_midfielder_centre = new PlayerPosition(PitchArea.AttackingMidfielder, Side.Centre);
        final Position attacking_midfielder_right = new PlayerPosition(PitchArea.AttackingMidfielder, Side.Right);
        final Position attacking_midfielder_left = new PlayerPosition(PitchArea.AttackingMidfielder, Side.Left);
        // Striker based
        final Position striker = new PlayerPosition(PitchArea.Striker);

        // The positions
        List<Position> positions = null;

        // GK based tests
        String pos = "Goalkeeper";
        positions = parser.readPositions(pos);
        assertEquals(1, positions.size());
        assertTrue(positions.contains(goalkeeper));

        // Sweeper based tests
        pos = "Sweeper";
        positions = parser.readPositions(pos);
        assertEquals(1, positions.size());
        assertTrue(positions.contains(sweeper));

        pos = "Sweeper / D (RLC)";
        positions = parser.readPositions(pos);
        assertEquals(4, positions.size());
        assertTrue(positions.contains(sweeper));
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(defender_left));
        assertTrue(positions.contains(defender_centre));

        pos = "Sweeper, Defender (Centre)";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(sweeper));
        assertTrue(positions.contains(defender_centre));

        pos = "Sweeper, Defensive Midfielder, Midfielder (Centre)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(sweeper));
        assertTrue(positions.contains(defensive_midfielder));
        assertTrue(positions.contains(midfielder_centre));

        // Defender (Right) based roles
        pos = "Defender (Right)";
        positions = parser.readPositions(pos);
        assertEquals(1, positions.size());
        assertTrue(positions.contains(defender_right));

        pos = "Defender (Right, Centre)";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(defender_centre));

        pos = "Defender (Right) / D (C)";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(defender_centre));

        pos = "Defender (Right) / D (LC)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(defender_left));
        assertTrue(positions.contains(defender_centre));

        pos = "Defender (Right, Left)";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(defender_left));

        pos = "Defender (Right) / SW, WB (R), DM";
        positions = parser.readPositions(pos);
        assertEquals(4, positions.size());
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(sweeper));
        assertTrue(positions.contains(wingback_right));
        assertTrue(positions.contains(defensive_midfielder));

        // Defender (Left) based
        pos = "Defender (Left) / D/WB (R)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(defender_left));
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(wingback_right));

        pos = "Defender, Midfielder (Left) / D (R)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(defender_left));
        assertTrue(positions.contains(midfielder_left));
        assertTrue(positions.contains(defender_right));

        // Defender (Centre) based
        pos = "Defender (Centre) / SW";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(defender_centre));
        assertTrue(positions.contains(sweeper));

        pos = "Defender (Centre) / SW, D (L)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(defender_centre));
        assertTrue(positions.contains(sweeper));
        assertTrue(positions.contains(defender_left));

        pos = "Defender (Centre) / SW, DM";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(defender_centre));
        assertTrue(positions.contains(sweeper));
        assertTrue(positions.contains(defensive_midfielder));

        // Wing Back (Right) based
        pos = "Wing Back (Right) / D/M (R)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(wingback_right));
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(midfielder_right));

        // Wing Back (Left) based
        pos = "Wing Back (Left) / SW, D (LC), M (L)";
        positions = parser.readPositions(pos);
        assertEquals(5, positions.size());
        assertTrue(positions.contains(wingback_left));
        assertTrue(positions.contains(sweeper));
        assertTrue(positions.contains(defender_left));
        assertTrue(positions.contains(defender_centre));
        assertTrue(positions.contains(midfielder_left));

        // Defensive Midfielder based
        pos = "Defensive Midfielder / D (R), M (C)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(defensive_midfielder));
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(midfielder_centre));

        // Midfielder (Right) based
        pos = "Midfielder (Right) / D (R), WB (RL), M (L)";
        positions = parser.readPositions(pos);
        assertEquals(5, positions.size());
        assertTrue(positions.contains(midfielder_right));
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(wingback_right));
        assertTrue(positions.contains(wingback_left));
        assertTrue(positions.contains(midfielder_left));

        pos = "Midfielder/Attacking Midfielder (Right, Left) / WB (RL)";
        positions = parser.readPositions(pos);
        assertEquals(6, positions.size());
        assertTrue(positions.contains(midfielder_right));
        assertTrue(positions.contains(midfielder_left));
        assertTrue(positions.contains(attacking_midfielder_right));
        assertTrue(positions.contains(attacking_midfielder_left));
        assertTrue(positions.contains(wingback_right));
        assertTrue(positions.contains(wingback_left));

        // Midfielder (Centre) based
        pos = "Midfielder/Attacking Midfielder (Centre) / AM (L)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(midfielder_centre));
        assertTrue(positions.contains(attacking_midfielder_centre));
        assertTrue(positions.contains(attacking_midfielder_left));

        // Attacking Midfielder (Right) based
        pos = "Attacking Midfielder (Right), Striker";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(attacking_midfielder_right));
        assertTrue(positions.contains(striker));

        // Attacking Midfielder (Left) based
        pos = "Attacking Midfielder (Left) / AM (C), ST";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(attacking_midfielder_left));
        assertTrue(positions.contains(attacking_midfielder_centre));
        assertTrue(positions.contains(striker));

        // Attacking Midfielder (Centre) based
        pos = "Attacking Midfielder (Centre), Striker";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(attacking_midfielder_centre));
        assertTrue(positions.contains(striker));

        // Striker based
        pos = "Striker";
        positions = parser.readPositions(pos);
        assertEquals(1, positions.size());
        assertTrue(positions.contains(striker));

        pos = "Striker / AM (L)";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(attacking_midfielder_left));
        assertTrue(positions.contains(striker));

        pos = "Striker / M/AM(C)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(midfielder_centre));
        assertTrue(positions.contains(attacking_midfielder_centre));
        assertTrue(positions.contains(striker));

        // Other multiples
        pos = "Attacking Midfielder (Centre) / M/AM (RL), ST";
        positions = parser.readPositions(pos);
        assertEquals(6, positions.size());
        assertTrue(positions.contains(attacking_midfielder_centre));
        assertTrue(positions.contains(midfielder_right));
        assertTrue(positions.contains(midfielder_left));
        assertTrue(positions.contains(attacking_midfielder_right));
        assertTrue(positions.contains(attacking_midfielder_left));
        assertTrue(positions.contains(striker));

        // Taken directly from the testFiles
        // testFiles/1. Gianluigi Buffon.rtf
        pos = "Goalkeeper";
        positions = parser.readPositions(pos);
        assertEquals(1, positions.size());
        assertTrue(positions.contains(goalkeeper));

        // testFiles/10. Lionel Messi.rtf
        pos = "Attacking Midfielder (Centre) / M/AM (RL), ST";
        positions = parser.readPositions(pos);
        assertEquals(6, positions.size());
        assertTrue(positions.contains(attacking_midfielder_centre));
        assertTrue(positions.contains(midfielder_right));
        assertTrue(positions.contains(midfielder_left));
        assertTrue(positions.contains(attacking_midfielder_right));
        assertTrue(positions.contains(attacking_midfielder_left));
        assertTrue(positions.contains(striker));

        // testFiles/2. Adam Matthews.rtf
        pos = "Defender (Right) / D (L), M (R)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(defender_right));
        assertTrue(positions.contains(defender_left));
        assertTrue(positions.contains(midfielder_right));

        // testFiles/5. Daniel Majstorovic.rtf
        pos = "Defender (Centre) / SW";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(defender_centre));
        assertTrue(positions.contains(sweeper));

        // testFiles/8. Scott Brown.rtf
        pos = "Midfielder (Centre) / M (R)";
        positions = parser.readPositions(pos);
        assertEquals(2, positions.size());
        assertTrue(positions.contains(midfielder_centre));
        assertTrue(positions.contains(midfielder_right));
        
        // testFiles/János Tóth.rtf
        pos = "Wing Back, Midfielder/Attacking Midfielder (Left)";
        positions = parser.readPositions(pos);
        assertEquals(3, positions.size());
        assertTrue(positions.contains(wingback_left));
        assertTrue(positions.contains(midfielder_left));
        assertTrue(positions.contains(attacking_midfielder_left));
        
        // testFiles/Serio Romero.rtf
        pos = "Defender/Wing Back (Left), Defensive Midfielder, Midfielder (Left)";
        positions = parser.readPositions(pos);
        assertEquals("Known ones are: "+positions.toString(), 4, positions.size());
        assertTrue(positions.contains(defender_left));
        assertTrue(positions.contains(wingback_left));
        assertTrue(positions.contains(defensive_midfielder));
        assertTrue(positions.contains(midfielder_left));
        assertTrue(positions.contains(attacking_midfielder_left));
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.parser.PlayerTextParser#readGeneralInformation(java.io.BufferedReader, com.mcparland.john.footballmanagerroles.data.people.Player)}
     */
    @Test
    public void testReadGeneralInformation() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("testFiles/1. Gianluigi Buffon.rtf"),
                    "UTF-16"));
            Player player = new FootballPlayer();
            reader.readLine();
            parser.readGeneralInformation(reader, player);

            // Test everything
            // assertEquals("Juventus", player.getClub()); Not in this
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

        } catch (FileNotFoundException fnfe) {
            fail("FileNotFoundException caught");
        } catch (IOException ioe) {
            fail("IOException caught");
        }
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.parser.PlayerTextParser#getPlayerNameFromFileName(java.lang.String)}
     * .
     */
    @Test
    public void testGetPlayerNameFromFileName() {
        // Full absolute path
        final String fileName = "C:\\Documents and Settings\\John\\My Documents\\Sports Interactive\\Football Manager 2012 Beta\\Other Files\\1. Gianluigi Buffon.rtf";
        final String playerName = "Gianluigi Buffon";
        Assert.assertEquals(playerName, parser.getPlayerNameFromFileName(fileName));

        // A relative path
        final String fileName1 = "testFiles\\5. Daniel Majstorovic.rtf";
        final String playerName1 = "Daniel Majstorovic";
        Assert.assertEquals(playerName1, parser.getPlayerNameFromFileName(fileName1));

        // No path
        final String fileName2 = "7. Henrik Larsson.rtf";
        final String playerName2 = "Henrik Larsson";
        Assert.assertEquals(playerName2, parser.getPlayerNameFromFileName(fileName2));

        // Two digit number
        final String fileName3 = "testFiles\\10. Lionel Messi.rtf";
        final String playerName3 = "Lionel Messi";
        Assert.assertEquals(playerName3, parser.getPlayerNameFromFileName(fileName3));

        // No Number
        final String fileName4 = "Adam Matthews.rtf";
        final String playerName4 = "Adam Matthews";
        Assert.assertEquals(playerName4, parser.getPlayerNameFromFileName(fileName4));
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.parser.PlayerTextParser#parse(java.io.File)}
     * .
     */
    @Test
    public void testParse() {
        final Position goalkeeper = new PlayerPosition(PitchArea.Goalkeeper);
        final Position sweeper = new PlayerPosition(PitchArea.Sweeper);
        final Position defender_centre = new PlayerPosition(PitchArea.Defender, Side.Centre);

        try {
            File file = new File("testFiles/5. Daniel Majstorovic.rtf");
            FootballPlayer player = (FootballPlayer) parser.parse(file);
            assertEquals("Daniel Majstorovic", player.getName());
            assertEquals(2, player.getPositions().size());
            assertTrue(player.getPositions().contains(sweeper));
            assertTrue(player.getPositions().contains(defender_centre));
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

            file = new File("testFiles/1. Gianluigi Buffon.rtf");
            player = (FootballPlayer) parser.parse(file);
            assertEquals("Gianluigi Buffon", player.getName());
            assertEquals(1, player.getPositions().size());
            assertTrue(player.getPositions().contains(goalkeeper));
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

            attrs = player.getAttributes();
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

        } catch (ParseException pe) {
            pe.printStackTrace();
            fail("ParseException caught");
        }
    }

    /**
     * Test method for {@link PlayerTextParser#parse(File)} but using a real RTF
     * file
     */
    @Test
    public void testParse_realRtf() {
        final Position defender_right = new PlayerPosition(PitchArea.Defender, Side.Right);
        final Position defender_left = new PlayerPosition(PitchArea.Defender, Side.Left);
        final Position midfielder_right = new PlayerPosition(PitchArea.Midfielder, Side.Right);
        try {
            File file = new File("testFiles/2. Adam Matthews.rtf");
            FootballPlayer player = (FootballPlayer) parser.parse(file);
            assertEquals("Adam Matthews", player.getName());
            assertEquals(3, player.getPositions().size());
            assertTrue(player.getPositions().contains(defender_right));
            assertTrue(player.getPositions().contains(defender_left));
            assertTrue(player.getPositions().contains(midfielder_right));
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

        } catch (ParseException pe) {
            pe.printStackTrace();
            fail("ParseException caught");
        }
    }
}
