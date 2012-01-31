/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.exceptions;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;

/**
 * No Such attribute exists
 * 
 * @author John McParland
 * 
 */
public class NoSuchAttributeException extends Exception {

    /**
     * @see java.io.Serializable
     */
    public static final long serialVersionUID = 0L;

    /**
     * The attribute
     */
    private Attribute attribute = null;

    /**
     * Create an exception giving the attribute already set and its OLD value
     * 
     * @param attribute
     *            The attribute
     */
    public NoSuchAttributeException(Attribute attribute) {
	super("The atttribute, " + attribute + " doesn't exist");
	this.attribute = attribute;
    }

    /**
     * @return The attribute
     */
    public Attribute getAttribute() {
	return attribute;
    }

    /**
     * @param attribute
     *            The attribute
     */
    public void setAttribute(Attribute attribute) {
	this.attribute = attribute;
    }

}
