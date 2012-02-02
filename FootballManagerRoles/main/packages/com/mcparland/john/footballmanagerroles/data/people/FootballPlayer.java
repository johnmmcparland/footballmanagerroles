/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.people;

import java.util.ArrayList;
import java.util.List;

import com.mcparland.john.footballmanagerroles.data.exceptions.PositionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.roles.Position;

/**
 * A football player in Football Manager
 * 
 * @author John McParland
 * 
 */
public class FootballPlayer extends AbstractPerson implements Player {

    /**
     * The positions this player can play
     */
    private List<Position> positions = new ArrayList<Position>();

    /**
     * The height of this player
     */
    private String height = "0.0m";

    /**
     * What foot they prefer to use
     */
    private String preferredFoot = "Right";

    /**
     * Their mass
     */
    private String mass = "0 kg";

    /**
     * The weekly wage
     */
    private String wage = "£0";

    /**
     * Their value
     */
    private String value = "£0";

    /**
     * Create a Football Player with a given name
     * 
     * @param name
     *            The name of the player
     */
    public FootballPlayer(String name) {
        this.name = name;
    }

    /**
     * Create a Football Player
     */
    public FootballPlayer() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#getPositions()
     */
    @Override
    public List<Position> getPositions() {
        return positions;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Player#addPosition(com.mcparland
     * .john.footballmanagerroles.data.Position)
     */
    @Override
    public void addPosition(Position pos) {
        if (positions.contains(pos)) {
            throw new PositionAlreadyAddedException("Already have position: " + pos);
        } else {
            positions.add(pos);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Player#removePosition(com
     * .mcparland.john.footballmanagerroles.data.Position)
     */
    @Override
    public void removePosition(Position pos) {
        positions.remove(pos);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#clearPositions()
     */
    @Override
    public void clearPositions() {
        positions.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#getHeight()
     */
    @Override
    public String getHeight() {
        return height;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#setHeight(float)
     */
    @Override
    public void setHeight(String height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Player#getPreferredFoot()
     */
    @Override
    public String getPreferredFoot() {
        return preferredFoot;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Player#setPreferredFoot(
     * java.lang.String)
     */
    @Override
    public void setPreferredFoot(String preferredFoot) {
        this.preferredFoot = preferredFoot;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#getMass()
     */
    @Override
    public String getMass() {
        return mass;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#setMass(int)
     */
    @Override
    public void setMass(String mass) {
        this.mass = mass;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#getWage()
     */
    @Override
    public String getWage() {
        return wage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#setWage(int)
     */
    @Override
    public void setWage(String wage) {
        this.wage = wage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#getValue()
     */
    @Override
    public String getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Player#setValue(int)
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return super.toString() + getPositions();
    }
}
