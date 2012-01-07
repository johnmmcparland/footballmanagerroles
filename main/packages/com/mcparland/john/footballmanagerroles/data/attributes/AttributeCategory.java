/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.attributes;

/**
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
public enum AttributeCategory {

    Aerobic("Aerobic"), Attacking("Attacking"), BallControl("Ball Control"), Defending("Defending"), NoCategory(
            "No Category"), Shooting("Shooting"), Strength("Strength"), Tactics("Tactics"), GKHandling("GK - Handling"), GKShotStopping(
            "GK - Shot Stopping");

    /**
     * Name of this category
     */
    private String name = null;

    /**
     * Create an Attribute Category with the given display name
     * 
     * @param name
     *            The display name
     */
    private AttributeCategory(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return name;
    }

    /**
     * Set the name of this category
     * 
     * @param name
     *            The name of this category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of this category
     * 
     * @return The name of this category
     */
    public String getName() {
        return this.name;
    }
    
}
