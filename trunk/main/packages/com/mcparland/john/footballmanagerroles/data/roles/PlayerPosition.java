/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * A players position
 * 
 * @author John
 * 
 */
public class PlayerPosition implements Position {

    /**
     * The side
     */
    private Side side = null;

    /**
     * The pitch area
     */
    private PitchArea pitchArea = null;

    /**
     * Create a players position
     */
    public PlayerPosition() {

    }

    /**
     * Create a players position
     * 
     * @param line
     *            The line the player plays on
     */
    public PlayerPosition(PitchArea line) {
        this.pitchArea = line;
    }

    /**
     * Create a players position
     * 
     * @param line
     *            The line the player plays on
     * @param side
     *            The side the player plays on
     */
    public PlayerPosition(PitchArea line, Side side) {
        this.pitchArea = line;
        this.side = side;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Position#getLine()
     */
    @Override
    public PitchArea getLine() {
        return pitchArea;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Position#setLine(com.mcparland
     * .john.footballmanagerroles.data.PitchArea)
     */
    @Override
    public void setLine(PitchArea line) {
        this.pitchArea = line;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Position#getSide()
     */
    @Override
    public Side getSide() {
        return side;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Position#setSide(com.mcparland
     * .john.footballmanagerroles.data.Side)
     */
    @Override
    public void setSide(Side side) {
        this.side = side;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = pitchArea.getLongName();
        if (null != side) {
            str += "(" + side.toString() + ")";
        }
        return str;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Position o) {
        if (null == pitchArea && null == o.getLine()) {
            return 0;
        } else if (null == pitchArea) {
            return -1;
        } else if (null == o.getLine()) {
            return 1;
        } else {
            int diff = pitchArea.compareTo(o.getLine());
            if (0 != diff) {
                return diff;
            } else {
                if (null == side && null == o.getSide()) {
                    return 0;
                } else if (null == side) {
                    return -1;
                } else if (null == o.getSide()) {
                    return 1;
                } else {
                    return side.compareTo(o.getSide());
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o instanceof PlayerPosition) {
            return 0 == this.compareTo((PlayerPosition) o);
        } else {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return getLine().hashCode() ^ getSide().hashCode();
    }

}
