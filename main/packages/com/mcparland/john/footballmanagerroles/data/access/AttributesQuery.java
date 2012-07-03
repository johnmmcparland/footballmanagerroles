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
package com.mcparland.john.footballmanagerroles.data.access;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeCategory;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.GoalkeeperAttribute;
import com.mcparland.john.footballmanagerroles.data.attributes.OutfieldPlayerAttribute;

/**
 * Accesses Attributes
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
public class AttributesQuery implements RowMapper<Attribute> {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(AttributesQuery.class);

    /**
     * Create Attribute Access
     */
    public AttributesQuery() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet
     * , int)
     */
    @Override
    public Attribute mapRow(ResultSet rs, int rowNum) throws SQLException {
        Attribute attr = null;

        // Get the type and create the attribute object from that
        String type = rs.getString("type");
        if (type.equals(AttributeType.Goalkeeping.toString())) {
            attr = new GoalkeeperAttribute();
        } else {
            attr = new OutfieldPlayerAttribute();
        }
        try {
            attr.setType(AttributeType.valueOf(type));
        } catch (Exception ex) {
            throw new SQLException("The type read is not valid " + type, ex);
        }

        // Name
        attr.setName(rs.getString("attribute"));

        // Category
        String category = rs.getString("category");
        // Remove the spaces so that the database can contain user friendly
        // strings but our enums still work
        category = category.replaceAll(" ", "");
        // And the dashes
        category = category.replaceAll("-", "");
        try {
            attr.setCategory(AttributeCategory.valueOf(category));
        } catch (Exception ex) {
            LOGGER.error("The category read is not valid: " + category, ex);
            ex.printStackTrace();
            throw new SQLException("The type read is not valid " + type, ex);
        }

        return attr;
    }
}
