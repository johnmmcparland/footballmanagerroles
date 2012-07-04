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
