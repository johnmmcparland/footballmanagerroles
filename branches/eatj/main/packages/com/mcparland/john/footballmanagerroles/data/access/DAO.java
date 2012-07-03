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

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Data Access Object allowing for querying the football manager roles database
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
public interface DAO<T> {

    /**
     * Set the JDBC Template to use
     * 
     * @param jdbcTemplate
     *            The template to use
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    /**
     * Get the template to use
     * 
     * @return The template to use
     */
    public JdbcTemplate getJdbcTemplate();

    /**
     * Set the queryier
     * 
     * @param queryier
     *            The queryier
     */
    public void setQueryier(RowMapper<T> querier);

    /**
     * Get the queryier
     * 
     * @return The queryier
     */
    public RowMapper<T> getQueryier();

    /**
     * Set the query to execute
     * 
     * @param query
     *            The query
     */
    public void setQuery(String query);

    /**
     * Get the query to execute
     * 
     * @return The query
     */
    public String getQuery();

}
