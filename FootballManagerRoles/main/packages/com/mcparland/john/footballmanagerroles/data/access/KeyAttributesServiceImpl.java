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
package com.mcparland.john.footballmanagerroles.data.access;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;

/**
 * Service for obtaining the key attributes for a given role
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
public class KeyAttributesServiceImpl implements KeyAttributesService {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(KeyAttributesServiceImpl.class);

    /**
     * The data access objects
     */
    private Collection<DAO<Attribute>> daos = null;

    /**
     * Create the service
     */
    public KeyAttributesServiceImpl() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.KeyAttributesService
     * #getKeyAttributeNames(java.lang.String)
     */
    @Override
    public Collection<Attribute> getKeyAttributes(String viewName) {
        List<Attribute> keyAttributes = new ArrayList<Attribute>();
        for (DAO<Attribute> dao : daos) {
            String query = buildQuery(dao.getQuery(), viewName);
            LOGGER.debug("Query: " + query);
            keyAttributes.addAll(dao.getJdbcTemplate().query(query, dao.getQueryier()));
        }
        return keyAttributes;
    }

    /**
     * Build the query to find the key attribute names with
     * 
     * @param queryStart
     *            The start of the query
     * @param viewName
     *            The name of the view containing the key attributes
     * @return The SQL query
     */
    private String buildQuery(String queryStart, String viewName) {
        // Ok security check - ensure there is only one select keyword, no
        // insert, no update and no delete
        if (0 != queryStart.lastIndexOf("select")) {
            throw new IllegalArgumentException("The query has more than one select keyword: " + queryStart);
        }
        if (-1 != queryStart.indexOf("insert")) {
            throw new IllegalArgumentException("The query contains the insert keyword: " + queryStart);
        }
        if (-1 != queryStart.indexOf("update")) {
            throw new IllegalArgumentException("The query contains the update keyword: " + queryStart);
        }
        if (-1 != queryStart.indexOf("delete")) {
            throw new IllegalArgumentException("The query contains the delete keyword: " + queryStart);
        }
        return (queryStart + " " + viewName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.KeyAttributesService
     * #setDAOs(java.util.Collection)
     */
    @Override
    public void setDAOs(Collection<DAO<Attribute>> daos) {
        this.daos = daos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.KeyAttributesService
     * #getDAOs()
     */
    @Override
    public Collection<DAO<Attribute>> getDAOs() {
        return daos;
    }

}
