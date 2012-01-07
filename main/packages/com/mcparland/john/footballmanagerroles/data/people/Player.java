/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.people;

import java.util.List;

import com.mcparland.john.footballmanagerroles.data.roles.Position;

/**
 * A Football Player
 * 
 * @author John McParland
 * 
 */
public interface Player extends Person {

    /**
     * @return The positions this player can play
     */
    public List<Position> getPositions();

    /**
     * Add a position that this player can play
     * 
     * @param pos
     *            The position to add
     */
    public void addPosition(Position pos);

    /**
     * Remove the position this player can play
     * 
     * @param pos
     *            The position
     */
    public void removePosition(Position pos);

    /**
     * Clear their positions
     */
    public void clearPositions();

    /**
     * @return Their height
     */
    public String getHeight();

    /**
     * @param height
     *            Their height
     */
    public void setHeight(String height);

    /**
     * @return Preferred foot
     */
    public String getPreferredFoot();

    /**
     * @param preferredFoot
     *            Their preferred foot
     */
    public void setPreferredFoot(String preferredFoot);

    /**
     * @return Their mass
     */
    public String getMass();

    /**
     * @param mass
     *            Their mass
     */
    public void setMass(String mass);

    /**
     * @return Their wage
     */
    public String getWage();

    /**
     * @param wage
     *            Their wage
     */
    public void setWage(String wage);

    /**
     * @return Their value
     */
    public String getValue();

    /**
     * @param value
     *            Their value
     */
    public void setValue(String value);

}
