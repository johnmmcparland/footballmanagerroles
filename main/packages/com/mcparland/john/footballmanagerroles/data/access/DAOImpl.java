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
 * Data Access Object
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
public class DAOImpl<T> implements DAO<T> {

    /**
     * JDBC Template
     */
    private JdbcTemplate jdbcTemplate = null;

    /**
     * Query object
     */
    private RowMapper<T> queryier = null;

    /**
     * The query to execute
     */
    private String query = null;

    /**
     * Abstract Data Access Object
     */
    public DAOImpl() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.DAO#setJdbcTemplate
     * (org.springframework.jdbc.core.JdbcTemplate)
     */
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.DAO#getJdbcTemplate()
     */
    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.DAO#setMappingSqlQuery
     * (org.springframework.jdbc.object.RowMapper)
     */
    @Override
    public void setQueryier(RowMapper<T> queryier) {
        this.queryier = queryier;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.DAO#getMappingSqlQuery
     * ()
     */
    @Override
    public RowMapper<T> getQueryier() {
        return queryier;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.DAO#setQuery(java
     * .lang.String)
     */
    @Override
    public void setQuery(String query) {
        this.query = query;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.access.DAO#getQuery()
     */
    @Override
    public String getQuery() {
        return query;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "SQL: " + query + " Querier: " + queryier.toString() + " JDBCTemplate non-null? " + (null != jdbcTemplate);
    }

}
