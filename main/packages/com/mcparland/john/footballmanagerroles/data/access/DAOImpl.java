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
