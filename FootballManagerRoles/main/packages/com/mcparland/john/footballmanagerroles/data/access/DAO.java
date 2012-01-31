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
