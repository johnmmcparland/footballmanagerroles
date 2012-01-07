/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.access;

import java.util.Collection;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;

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
 */
public interface AttributesService {

    /**
     * Get the attributes
     * 
     * @return The attributes
     */
    public Attributes getAttributes();

    /**
     * Set the Data Access Objects to use
     * 
     * @param daos
     *            The data access objects
     */
    public void setDAOs(Collection<DAO<Attribute>> daos);

    /**
     * Get the data access objecsts
     * 
     * @return The DAOs
     */
    public Collection<DAO<Attribute>> getDAOs();

}
