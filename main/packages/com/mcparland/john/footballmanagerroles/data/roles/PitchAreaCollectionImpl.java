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
package com.mcparland.john.footballmanagerroles.data.roles;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.mcparland.john.footballmanagerroles.data.exceptions.PitchAreaAlreadyAddedException;

/**
 * A collection of PitchAreas
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
public class PitchAreaCollectionImpl implements PitchAreaCollection, InitializingBean {

    /**
     * The PitchAreas
     */
    private Map<String, PitchArea> pitchAreas = new HashMap<String, PitchArea>();

    /**
     * Create a collection of PitchAreas
     */
    public PitchAreaCollectionImpl() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PitchAreaCollection
     * #getPitchArea(java.lang.String)
     */
    @Override
    public PitchArea getPitchArea(String name) {
        return pitchAreas.get(name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PitchAreaCollection
     * #addPitchArea
     * (com.mcparland.john.footballmanagerroles.data.roles.PitchArea)
     */
    @Override
    public void addPitchArea(PitchArea pitchArea) throws PitchAreaAlreadyAddedException {
        if (pitchAreas.containsKey(pitchArea.getLongName()) || pitchAreas.containsKey(pitchArea.getShortName())) {
            throw new PitchAreaAlreadyAddedException("PitchArea: " + pitchArea.getLongName()
                    + " has already been added");
        } else {
            pitchAreas.put(pitchArea.getLongName(), pitchArea);
            pitchAreas.put(pitchArea.getShortName(), pitchArea);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for (PitchArea area : PitchArea.values()) {
            addPitchArea(area);
        }
    }

}
