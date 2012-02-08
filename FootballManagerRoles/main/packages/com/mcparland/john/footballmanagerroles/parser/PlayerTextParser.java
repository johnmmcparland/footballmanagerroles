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
/**
 * 
 */
package com.mcparland.john.footballmanagerroles.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.exceptions.AttributeAlreadySetException;
import com.mcparland.john.footballmanagerroles.data.exceptions.ParseException;
import com.mcparland.john.footballmanagerroles.data.people.FootballPlayer;
import com.mcparland.john.footballmanagerroles.data.people.Player;
import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition;
import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.data.roles.Side;

/**
 * Parser for Football Players from the text file output of Football Manager
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
public class PlayerTextParser implements Parser<Player> {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(PlayerTextParser.class);

    /**
     * The attributes to parse out
     */
    private Attributes attributes = null;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.parser.Parser#parse(java.io.File)
     */
    @Override
    public Player parse(File input) throws ParseException {
        // Create the player and set their name
        Player player = new FootballPlayer();
        player.setName(getPlayerNameFromFileName(input.getAbsolutePath()));
        LOGGER.debug("Got name");

        BufferedReader reader = null;
        try {
            System.out.println("JMCP: File " + input.getName() + " length is " + input.length());

            // This reads .txt (UTF-8) only
            // reader = new BufferedReader(new FileReader(input));
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-16"));

            String line = reader.readLine();
            // Get the positions
            if (null != line) {
                List<Position> positions = readPositions(line.substring(0, line.indexOf("-") - 1));
                for (Position pos : positions) {
                    player.addPosition(pos);
                }
                LOGGER.debug("Got positions");
                // Also get the club from the first line
                player.setClub(line.substring(line.indexOf("-") + 2, line.length()));
                // Get the "general" information
                readGeneralInformation(reader, player);
                LOGGER.debug("Got general information");
                // Read attributes
                readAttributes(reader, player);
                LOGGER.debug("Got attributes");
            } else {
                throw new ParseException("Could not read the first line of the file");
            }

        } catch (FileNotFoundException fnfe) {
            throw new ParseException("Cannot find the file " + input.getAbsolutePath(), fnfe);
        } catch (IOException ioe) {
            throw new ParseException("Error reading the file " + input.getAbsolutePath(), ioe);
        } finally {
            try {
                reader.close();
            } catch (IOException ioe) {
                // If we can't close the file it is a serious error
                LOGGER.error("Cannot close the file " + input.getAbsolutePath());
                throw new ParseException("Error reading the file " + input.getAbsolutePath(), ioe);
            }
            reader = null;
        }
        return player;
    }

    /**
     * Read the positions from the reader into the player
     * 
     * @param line
     *            The line of text which should contain the positions
     */
    public List<Position> readPositions(String posString) {
        List<Position> positions = new ArrayList<Position>();

        // Examples of positions are in the JUnit test

        // Algorithm
        // Find short or long name "lines"
        // Long ones before the first / short ones after
        int firstSplit = posString.indexOf('/');
        String longPos = posString;
        String shortPos = "";
        if (-1 != firstSplit) {
            longPos = posString.substring(0, firstSplit);
            shortPos = posString.substring(firstSplit + 1);
            // Annoyingly, shortPos might contain yet another long pos name,
            if (shortPos.contains(PitchArea.AttackingMidfielder.getLongName())) {
                final String amLongName = PitchArea.AttackingMidfielder.getLongName();
                longPos += "/" + amLongName;
                shortPos = shortPos.substring(shortPos.lastIndexOf(amLongName) + amLongName.length());
            }
        }
        // Find the NEXT () for the sides they can play in that pitch area
        for (PitchArea area : PitchArea.values()) {
            // Need to do long then short name
            // Determines if the position contains the given area
            boolean posContainsArea = false;
            // Determines the last index in the posString for the area
            int areaLastIndex = 0;
            for (int i = 0; i < 2; i++) {
                if (0 == i) {
                    posContainsArea = longPos.contains(area.getLongName());
                    if (posContainsArea) {
                        areaLastIndex = longPos.lastIndexOf(area.getLongName()) + area.getLongName().length();
                        // Now we have three similarly named positions;
                        // Midfielder
                        // Defensive Midfielder
                        // Attacking Midfielder
                        // So if this is midfielder, check "Attacking " or
                        // "Defensive " don't precede it
                        // First is it long enough for this
                        if (PitchArea.Midfielder.equals(area)) {
                            int earlyIndex = areaLastIndex - PitchArea.AttackingMidfielder.getLongName().length();
                            if (0 <= earlyIndex) {
                                // Before we go any further check Midfielder
                                // isn't also included before earlyIndex
                                if (!longPos.substring(0, earlyIndex).contains(PitchArea.Midfielder.getLongName())) {
                                    String substr = posString.substring(earlyIndex, areaLastIndex);
                                    if (substr.equals(PitchArea.AttackingMidfielder.getLongName())) {
                                        posContainsArea = false;
                                    }
                                }
                            }
                            if (posContainsArea) {
                                earlyIndex = areaLastIndex - PitchArea.DefensiveMidfielder.getLongName().length();
                                if (0 <= earlyIndex) {
                                    String substr = posString.substring(earlyIndex, areaLastIndex);
                                    if (substr.equals(PitchArea.DefensiveMidfielder.getLongName())) {
                                        posContainsArea = false;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    posContainsArea = shortPos.contains(area.getShortName());
                    if (posContainsArea) {
                        areaLastIndex = posString.lastIndexOf(area.getShortName()) + area.getShortName().length();
                        // Now we have
                        // D which is included in DM
                        // and M, which is included in DM and AM
                        // So check the next or previous character to see if
                        // this "really" contains short position
                        if (PitchArea.Defender.equals(area)) {
                            String nextPos = posString.substring(areaLastIndex - 1, areaLastIndex + 1);
                            if (nextPos.equals(PitchArea.DefensiveMidfielder.getShortName())) {
                                posContainsArea = false;
                            }
                        } else if (PitchArea.Midfielder.equals(area)) {
                            if (0 < areaLastIndex) {
                                String nextPos = "";
                                if (areaLastIndex < posString.length() - 1) {
                                    nextPos = posString.substring(areaLastIndex - 2, areaLastIndex + 1);
                                } else {
                                    nextPos = posString.substring(areaLastIndex - 2, areaLastIndex);
                                }
                                nextPos = nextPos.trim();
                                if (nextPos.equals(PitchArea.DefensiveMidfielder.getShortName())
                                        || nextPos.equals(PitchArea.AttackingMidfielder.getShortName())) {
                                    posContainsArea = false;
                                }
                            }
                        }
                    }
                }
                if (posContainsArea) {
                    LOGGER.debug("Got area " + area);
                    Position pos = new PlayerPosition();
                    pos.setLine(area);
                    if (!area.isSided()) {
                        positions.add(pos);
                    } else {
                        int nextSide = posString.substring(areaLastIndex).indexOf('(') + areaLastIndex + 1;
                        if (-1 != nextSide) {
                            // There could be one or more sides here, either
                            // long or
                            // short named
                            int endOfSides = posString.indexOf(')', nextSide);
                            String sidesString = posString.substring(nextSide, endOfSides);
                            // We are looking for C, L or R but we could have
                            // all
                            // three
                            boolean alreadyAdded = false;
                            if (sidesString.contains("C")) {
                                pos.setSide(Side.Centre);
                                positions.add(pos);
                                alreadyAdded = true;
                            }
                            if (sidesString.contains("R")) {
                                if (!alreadyAdded) {
                                    pos.setSide(Side.Right);
                                    alreadyAdded = true;
                                } else {
                                    pos = new PlayerPosition();
                                    pos.setLine(area);
                                    pos.setSide(Side.Right);
                                }
                                positions.add(pos);
                            }
                            if (sidesString.contains("L")) {
                                if (!alreadyAdded) {
                                    pos.setSide(Side.Left);
                                    alreadyAdded = true;
                                } else {
                                    pos = new PlayerPosition();
                                    pos.setLine(area);
                                    pos.setSide(Side.Left);
                                }
                                positions.add(pos);
                            }
                        } else {
                            // I don't think this should happen!
                            LOGGER.warn("No side found for area " + area);
                        }
                    }
                }
            }
        }

        return positions;
    }

    /**
     * Get the players name from the file name
     * 
     * @param fileName
     *            The file name. Can be a relative or absolute path
     * @return The players name
     */
    public String getPlayerNameFromFileName(String fileName) {
        // A file name could look like
        // testFiles\5. Daniel Majstorovic.rtf
        // or
        // C:\Documents and Settings\John\My Documents\Sports
        // Interactive\Football Manager 2012\1. Gianluigi Buffon.rtf
        // Generically it is
        // <some path>\N. First Middle Last Other.rtf
        // Basically get the last path separator index and to the 5th last
        // character
        final int lastSepIndex = fileName.lastIndexOf(File.separator);
        final int endIndex = fileName.length() - 4;
        return fileName.substring(lastSepIndex + 4, endIndex);
    }

    /**
     * Read the "general information" about the player
     * <p>
     * This depends heavily on the users preferences inside the Football Manager
     * game, including language, how they measure mass, height, date formats
     * etc. So all of this is a "best-effort" basis
     * </p>
     * 
     * @param reader
     *            The reader parsing the file
     * @param player
     *            The player to set the general information of
     * @throws IOException
     *             If there is any problem reading the exception will be thrown
     */
    public void readGeneralInformation(BufferedReader reader, Player player) throws IOException {
        // Line 26: | | Nationality | | Age |
        // Line 28: | | X caps / Y goals | | d.m.yyyy |
        // Line 30: | | Height | | Preferred Foot |
        // Line 32: | | Mass | | |
        // Line 34: | | Wage | | Value |
        // Line 36: | | Contract Expiry | | |
        final int FIRST_INFO = 2;
        final int SECOND_INFO = 4;

        // Initially I was going to parse everything as numbers or dates where
        // required and I even got it working
        // But when considering internationlization and the fact none of this
        // "general" information is used in any calculation
        // I stopped.
        // For example all it would take is for someone to change the date
        // format or use $ instead of £ for it to fall apart
        // never mind using a languague other than UK English

        try {
            int lineNo = 1;
            // Skip lines
            while (25 > lineNo) {
                reader.readLine();
                lineNo++;
            }
            // Nationality and age (line 26)
            String line = reader.readLine();
            String[] info = line.split("\\|");
            player.setNationality(info[FIRST_INFO].trim());
            String age = info[SECOND_INFO].trim();
            // age = age.substring(0, age.indexOf("y") - 1);
            // player.setAge(Integer.parseInt(age));
            player.setAge(age);
            LOGGER.debug("Parsed Nationality and Age");

            // International status and DOB (line 28)
            reader.readLine();
            line = reader.readLine();
            info = line.split("\\|");
            // String caps = info[FIRST_INFO].split("\\/")[0];
            // String goals = info[FIRST_INFO].split("\\/")[1];
            // player.setInternationalStatus(Integer.parseInt(caps.substring(1,
            // caps.indexOf("c") - 1)));
            // player.setInternationalGoals(Integer.parseInt(goals.substring(1,
            // goals.indexOf("g") - 1)));
            player.setInternationalStatus(info[FIRST_INFO].trim());
            player.setDob(info[SECOND_INFO].trim());
            // try {
            // player.setDob(FORMAT.parse(dob));
            // } catch (java.text.ParseException e) {
            // throw new IOException("Cannot read the date of birth");
            // }
            LOGGER.debug("Parsed Caps, Goals and DOB");

            // Height, preferred foot (line 30)
            reader.readLine();
            line = reader.readLine();
            info = line.split("\\|");
            // player.setHeight(Float.parseFloat(info[FIRST_INFO].trim().substring(0,
            // 3)));
            player.setHeight(info[FIRST_INFO].trim());
            player.setPreferredFoot(info[SECOND_INFO].trim());
            LOGGER.debug("Parsed Height and Preferred Foot");

            // Mass (line 32)
            reader.readLine();
            line = reader.readLine();
            info = line.split("\\|");
            // player.setMass(Integer.parseInt(info[FIRST_INFO].trim().substring(0,
            // info[FIRST_INFO].trim().indexOf("k") - 1)));
            player.setMass(info[FIRST_INFO].trim());
            LOGGER.debug("Parsed Mass");

            // Wage, value (line 34)
            reader.readLine();
            line = reader.readLine();
            info = line.split("\\|");
            // String wage = info[FIRST_INFO].trim().substring(1,
            // info[FIRST_INFO].trim().indexOf("per week") - 1);
            // wage = wage.replace(",", "");
            // wage = wage.replace(".", "");
            // player.setWage(Integer.parseInt(wage));
            player.setWage(info[FIRST_INFO].trim());
            // String value = info[SECOND_INFO].trim();
            // // Get rid of ccy character
            // value = value.substring(1);
            // // Find out the last character
            // char lastChar = value.charAt(value.length() - 1);
            // value = value.substring(0, value.length() - 1);
            // float floatValue = Float.parseFloat(value);
            // if ('m' == lastChar || 'M' == lastChar) {
            // floatValue *= 1000000;
            // } else if ('k' == lastChar || 'k' == lastChar) {
            // floatValue *= 1000;
            // }
            // player.setValue((int) floatValue);
            player.setValue(info[SECOND_INFO].trim());
            LOGGER.debug("Parsed Wage and Value");

            // Contract expiry (line 36)
            reader.readLine();
            line = reader.readLine();
            info = line.split("\\|");
            player.setContractExpiry(info[FIRST_INFO].trim());
            // String contract = info[FIRST_INFO].trim();
            // try {
            // player.setContractExpiry(FORMAT.parse(contract));
            // } catch (java.text.ParseException e) {
            // throw new IOException("Cannot read the contract expiry");
            // }
            LOGGER.debug("Parsed Contract Expiry");

        } catch (Exception ex) {
            LOGGER.warn("Couldn't parse certain general information about the player, giving up but continuing with the rest of the parsing");
        }
    }

    /**
     * Read the "attributes" of the player
     * 
     * @param reader
     *            The reader parsing the file
     * @param player
     *            The player to set the attributes of
     * @throws IOException
     *             If there is any problem reading the file this exception will
     *             be thrown
     */
    public void readAttributes(BufferedReader reader, Player player) throws IOException {
        // The trick here is that the attributes are in a fixed known order
        // which the "attibutes" object should know
        Collection<Attribute> attrs = null;
        if (player.getPositions().contains((new PlayerPosition(PitchArea.Goalkeeper)))) {
            LOGGER.debug("Going to read Goalkeeper attributes");
            attrs = attributes.getAttributes(AttributeType.Goalkeeping);
        } else {
            LOGGER.debug("Going to read Technical attributes");
            attrs = attributes.getAttributes(AttributeType.Technical);
        }

        readAttributes(reader, player, attrs);
        LOGGER.debug("Going to read Mental attributes");
        readAttributes(reader, player, attributes.getAttributes(AttributeType.Mental));
        LOGGER.debug("Going to read Physical attributes");
        readAttributes(reader, player, attributes.getAttributes(AttributeType.Physical));
    }

    /**
     * Read the attributes for the player
     * 
     * @param reader
     *            The reader
     * @param player
     *            The player to set the attributes of
     * @param attrs
     *            The collection of attributes to look for
     * @throws IOException
     *             If there is a problem reading the file
     */
    protected void readAttributes(BufferedReader reader, Player player, Collection<Attribute> attrs) throws IOException {

        for (Attribute attr : attrs) {
            LOGGER.trace("Looking for attribute: " + attr.getName());
            System.err.println("Looking for attribute: " + attr.getName());
            String line = reader.readLine();
            String[] info = line.split("\\|");
            final int ATTR_NAME_INDEX = 1;
            final int ATTR_VALUE_INDEX = 2;
            final int NUM_INDICES = 5;
            while (NUM_INDICES > info.length || !info[ATTR_NAME_INDEX].trim().equals(attr.getName())) {
                line = reader.readLine();
                System.err.println(line);
                info = line.split("\\|");
            }
            try {
                LOGGER.trace("Got attribute " + attr.getName());
                int attrValue = Integer.parseInt(info[ATTR_VALUE_INDEX].trim());
                LOGGER.trace("Got value " + attrValue);
                player.addAttribute(attr, attrValue);
            } catch (NumberFormatException e) {
                throw new IOException("Could not parse the attribute value for " + attr.getName(), e);
            } catch (IllegalArgumentException e) {
                throw new IOException("Could not parse the attribute value for " + attr.getName(), e);
            } catch (AttributeAlreadySetException e) {
                throw new IOException("Could not parse the attribute value for " + attr.getName(), e);
            }
        }
    }

    @Override
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public Attributes getAttributes() {
        return attributes;
    }
}
