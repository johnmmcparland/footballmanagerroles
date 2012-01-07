/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.attributes;

import com.mcparland.john.footballmanagerroles.data.exceptions.IncorrectAttributeTypeException;

/**
 * An attribute for a goalkeeper
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
public class GoalkeeperAttribute extends AbstractAttribute {

    /**
     * Create a Goalkeeper attribute
     */
    public GoalkeeperAttribute() {
        super();
    }

    /**
     * Create an attribute
     * 
     * @param name
     *            The name of the attribute
     */
    public GoalkeeperAttribute(String name) {
        super(name, AttributeType.Goalkeeping);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.AbstractAttribute#setType
     * (com.mcparland.john.footballmanagerroles.data.AttributeType)
     */
    public void setType(AttributeType type) {
        if (type.equals(AttributeType.Technical)) {
            throw new IncorrectAttributeTypeException("The attribute type must not be Technical for an Goalkeeper");
        } else {
            super.setType(type);
        }
    }

}
