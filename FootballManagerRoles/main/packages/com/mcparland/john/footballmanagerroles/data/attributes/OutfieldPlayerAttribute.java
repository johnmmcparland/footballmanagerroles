/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.attributes;

import com.mcparland.john.footballmanagerroles.data.exceptions.IncorrectAttributeTypeException;

/**
 * An outfield players attribute
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
public class OutfieldPlayerAttribute extends AbstractAttribute {

    /**
     * Create an OutfieldPlayerAttribute
     */
    public OutfieldPlayerAttribute() {
        super();
    }

    /**
     * Create an outfield player attribute
     * 
     * @param name
     *            The name of the attribute
     * @param type
     *            The type of the attribute
     */
    public OutfieldPlayerAttribute(String name, AttributeType type) {
        super();
        if (type.equals(AttributeType.Goalkeeping)) {
            throw new IncorrectAttributeTypeException(
                    "The attribute type must not be Goalkeeping for an Outfield player");
        } else {
            setType(type);
            setName(name);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.AbstractAttribute#setType
     * (com.mcparland.john.footballmanagerroles.data.AttributeType)
     */
    public void setType(AttributeType type) {
        if (type.equals(AttributeType.Goalkeeping)) {
            throw new IncorrectAttributeTypeException(
                    "The attribute type must not be Goalkeeping for an Outfield player");
        } else {
            super.setType(type);
        }
    }

}
