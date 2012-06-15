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
