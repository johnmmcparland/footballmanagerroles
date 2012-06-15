/*
 * A program to determine the best role for footballer in the Football Manager game
 * Copyright (C) 2011-12  John McParland (johnmmcparland@gmail.com)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
