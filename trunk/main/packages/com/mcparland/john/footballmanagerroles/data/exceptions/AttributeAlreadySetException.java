/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.exceptions;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;

/**
 * The attribute already exists in the person
 * 
 * @author John McParland
 * 
 */
public class AttributeAlreadySetException extends Exception {

    /**
     * @see java.io.Serializable
     */
    public static final long serialVersionUID = 0L;

    /**
     * The attribute
     */
    private Attribute attribute = null;

    /**
     * The old value
     */
    private int oldValue = 0;

    /**
     * The new value
     */
    private int newValue = 0;

    /**
     * Create an exception giving the attribute already set
     * 
     * @param attribute
     *            The attribute
     * @param value
     *            The old value
     * @param The
     *            new value
     */
    public AttributeAlreadySetException(Attribute attribute, int oldValue,
	    int newValue) {
	super("The atttribute, " + attribute + " was already set to value: "
		+ oldValue + ", tried to set to new value:" + newValue);
	this.attribute = attribute;
	this.oldValue = oldValue;
	this.newValue = newValue;
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

    /**
     * @return The old value
     */
    public int getOldValue() {
	return oldValue;
    }

    /**
     * @param oldValue
     *            The old value
     */
    public void setOldValue(int oldValue) {
	this.oldValue = oldValue;
    }

    /**
     * @return The new value
     */
    public int getNewValue() {
	return newValue;
    }

    /**
     * @param newValue
     *            The new value
     */
    public void setNewValue(int newValue) {
	this.newValue = newValue;
    }

}
