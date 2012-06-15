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
abstract class AbstractAttribute implements Attribute {

    /**
     * This attribute's type
     */
    private AttributeType type = null;

    /**
     * This attributes name
     */
    private String name = "";

    /**
     * Category of this attribute
     */
    private AttributeCategory category = null;

    /**
     * Create an AbstractAttribute
     */
    public AbstractAttribute() {

    }

    /**
     * Create an attribute
     * 
     * @param name
     *            The attribute name
     * @param type
     *            The attribute type
     */
    public AbstractAttribute(String name, AttributeType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Create an attribute
     * 
     * @param name
     *            The name of the attribute
     * @param type
     *            The attribute type
     * @param category
     *            The attribute category
     */
    public AbstractAttribute(String name, AttributeType type, AttributeCategory category) {
        this.name = name;
        this.type = type;
        this.category = category;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Attribute#getType()
     */
    @Override
    public AttributeType getType() {
        return type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attribute#setType(com.mcparland
     * .john.footballmanagerroles.data.AttributeType)
     */
    @Override
    public void setType(AttributeType type) {
        this.type = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Attribute#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attribute#setName(java.lang
     * .String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Attribute#getCategory()
     */
    public AttributeCategory getCategory() {
        return category;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Attribute#setCategory(com
     * .mcparland.john.footballmanagerroles.data.AttributeCategory)
     */
    public void setCategory(AttributeCategory category) {
        this.category = category;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Attribute attr) {
        // Name then type
        int res = name.compareTo(attr.getName());
        if (0 == res) {
            res = type.compareTo(attr.getType());
        }
        return res;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o instanceof Attribute) {
            return 0 == this.compareTo((Attribute) o);
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return name.hashCode() ^ type.hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return name + "[Type: " + type + "/ Category: " + category + "]";
    }

}
