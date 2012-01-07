/**
 * Position.java
 * John McParland
 * Created: 11 May 2011
 */
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * Positions, consisting of a {@link PitchArea} of the pitch and a {@link Side}
 * @author John McParland
 *
 */
public interface Position extends Comparable<Position> {

    /**
     * @return The line of the position (defence, attacking midfield, forward)
     */
    public PitchArea getLine();
    
    /**
     * @param line The line of the position (defence, attacking midfield, forward)
     */
    public void setLine(PitchArea line);
    
    /**
     * @return The side of the position (centre, left, right)
     */
    public Side getSide();
    
    /**
     * @param side The side of the position (centre, left, right)
     */
    public void setSide(Side side);
    
}
