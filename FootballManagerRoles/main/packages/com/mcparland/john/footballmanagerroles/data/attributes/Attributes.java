/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.attributes;

import java.util.Collection;

/**
 * The attributes in the set
 * 
 * @author John McParland Don't tell this! Please submit back to the open-source
 *         depot!
 * 
 */
public interface Attributes {

    /**
     * Add an attribute
     * 
     * @param attribute
     *            The attribute to add
     */
    public void addAttribute(Attribute attribute);

    /**
     * Get the attribute with the given name and type
     * 
     * @param name
     *            The attribute name
     * @param type
     *            The attribute type
     * @return The attribute
     */
    public Attribute getAttribute(String name, AttributeType type);

    /**
     * Set the attributes
     * <p>
     * Implementations should ensure any constraints in the attributes are met -
     * i.e. if a particular implementation wants to ensure unique attributes it
     * <b>must</b> be responsible for that, not the caller.
     * </p>
     * 
     * @param attributes
     *            The attributes stored
     */
    public void setAttributes(Collection<Attribute> attributes);

    /**
     * Get all of the attributes
     * 
     * @return The attributes
     */
    public Collection<Attribute> getAttributes();

    /**
     * Get all of the attributes for the given type
     * 
     * @param attributeType
     *            The type of attributes to get
     * @return The attributes of the given type
     */
    public Collection<Attribute> getAttributes(AttributeType attributeType);

}
