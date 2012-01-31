/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.attributes;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.exceptions.AttributeAlreadyAddedException;

/**
 * The player attributes
 * <p>
 * (c) John McParland
 * </p>
 * <p>
 * You may enhance this code and re-submit to the depot. But you may not sell it
 * or use it for profit!
 * </p>
 * 
 * @author John McParland (john.mcparland@gmail.com)
 * 
 */
public class PlayerAttributes implements Attributes {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(PlayerAttributes.class);

    /**
     * The attributes
     */
    private Set<Attribute> attributes = new LinkedHashSet<Attribute>();

    /**
     * The attributes by their types
     */
    private Map<AttributeType, Set<Attribute>> attributesByType = new HashMap<AttributeType, Set<Attribute>>();

    /**
     * Create the set of attributes
     */
    public PlayerAttributes() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attributes#addAttribute(
     * com.mcparland.john.footballmanagerroles.data.Attribute)
     */
    @Override
    public void addAttribute(Attribute attribute) throws AttributeAlreadyAddedException {
        if (attributes.contains(attribute)) {
            // Log + throw exception - because the logging is persistent, the
            // exception may not be
            final String msg = "Attribute " + attribute + " already in the set!";
            LOGGER.error(msg);
            throw new AttributeAlreadyAddedException(msg);
        } else {
            attributes.add(attribute);
            // Ensure we've got a mapping for this type already
            if (!attributesByType.containsKey(attribute.getType())) {
                attributesByType.put(attribute.getType(), new LinkedHashSet<Attribute>());
            }
            // Check if it has been added already - it really shouldn't have due
            // to the earlier check
            if (attributesByType.get(attribute.getType()).contains(attribute)) {
                final String msg = "Attribute " + attribute + " already added for this type!";
                LOGGER.warn(msg);
                throw new AttributeAlreadyAddedException(msg);
            } else {
                attributesByType.get(attribute.getType()).add(attribute);
            }
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attributes#getAttribute(
     * java.lang.String)
     */
    @Override
    public Attribute getAttribute(String name, AttributeType type) {
        for (Attribute attr : attributes) {
            if (attr.getName().equals(name) && attr.getType().equals(type)) {
                return attr;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attributes#getAttributes()
     */
    @Override
    public Collection<Attribute> getAttributes() {
        return attributes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attributes#getAttributes
     * (com.mcparland.john.footballmanagerroles.data.AttributeType)
     */
    @Override
    public Collection<Attribute> getAttributes(AttributeType attributeType) {
        return attributesByType.get(attributeType);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attributes#setAttributes
     * (java.util.Collection)
     */
    @Override
    public void setAttributes(Collection<Attribute> attributes) throws AttributeAlreadyAddedException {
        for (Attribute attr : attributes) {
            addAttribute(attr);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Attribute attr : attributes) {
            str.append(attr.toString() + " ");
        }
        return str.toString();
    }

}
