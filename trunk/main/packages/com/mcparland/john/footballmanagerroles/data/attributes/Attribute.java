/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.attributes;


/**
 * Attributes - typed and named values players can have
 * 
 * @author John
 * 
 */
public interface Attribute extends Comparable<Attribute> {

    /**
     * @return The type of this attribute
     */
    public AttributeType getType();

    /**
     * @param type
     *            The type of this attribute
     */
    public void setType(AttributeType type);

    /**
     * @return The name of this attribute
     */
    public String getName();

    /**
     * @param name
     *            The name of this attribute
     */
    public void setName(String name);

    /**
     * Get this attributes category
     * 
     * @return The category
     */
    public AttributeCategory getCategory();

    /**
     * Set this attributes category
     * 
     * @param category
     *            The category
     */
    public void setCategory(AttributeCategory category);

}
