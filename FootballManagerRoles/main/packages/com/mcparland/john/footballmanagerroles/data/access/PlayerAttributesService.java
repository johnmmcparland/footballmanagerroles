/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.access;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.attributes.PlayerAttributes;

/**
 * Player AttrbuteService
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
public class PlayerAttributesService implements AttributesService {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(PlayerAttributesService.class);

    /**
     * Data Access Objects
     */
    private Collection<DAO<Attribute>> daos = null;

    /**
     * Create a PlayerAttribute Service
     */
    public PlayerAttributesService() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.AttributesService
     * #getAttributes()
     */
    @Override
    public Attributes getAttributes() {
        Attributes attrs = new PlayerAttributes();
        for (DAO<Attribute> dao : daos) {
            LOGGER.debug(dao.toString());
            List<Attribute> ats = (List<Attribute>) dao.getJdbcTemplate().query(dao.getQuery(), dao.getQueryier());
            for (Attribute at : ats) {
                attrs.addAttribute(at);
            }
        }
        return attrs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.AttributesService
     * #getDAOs()
     */
    public Collection<DAO<Attribute>> getDAOs() {
        return daos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.access.AttributesService
     * #setDAOs(java.util.Collection)
     */
    public void setDAOs(Collection<DAO<Attribute>> daos) {
        this.daos = daos;
    }

}
