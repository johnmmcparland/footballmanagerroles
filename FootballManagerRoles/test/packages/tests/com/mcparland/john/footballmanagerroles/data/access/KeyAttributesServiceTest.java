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
package tests.com.mcparland.john.footballmanagerroles.data.access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.data.access.KeyAttributesService;
import com.mcparland.john.footballmanagerroles.data.access.KeyAttributesServiceImpl;
import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeCategory;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.OutfieldPlayerAttribute;

/**
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.data.access.KeyAttributesService}
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class KeyAttributesServiceTest {

    /**
     * The service being tested
     */
    private KeyAttributesService service = null;

    /**
     * Set the key attributes service to test
     * 
     * @param service
     *            The service to test
     */
    @Autowired
    public void setKeyAttributesService(KeyAttributesService service) {
        if (service instanceof KeyAttributesServiceImpl) {
            this.service = service;
        } else {
            throw new IllegalArgumentException("Expected a KeyAttributesServiceImpl, got a " + service.getClass());
        }
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.access.KeyAttributesServiceImpl#getKeyAttributeNames(java.lang.String)}
     * .
     */
    @Test
    public void testGetKeyAttributeNames() {
        // Check specific attributes for specific roles
        Collection<Attribute> attrs = service.getKeyAttributes("AP_S");
        assertEquals(9, attrs.size());
        Collection<Attribute> knownAttrs = new ArrayList<Attribute>();
        knownAttrs.add(new OutfieldPlayerAttribute("Creativity", AttributeType.Mental, AttributeCategory.Attacking));
        knownAttrs.add(new OutfieldPlayerAttribute("Decisions", AttributeType.Mental, AttributeCategory.Tactics));
        knownAttrs.add(new OutfieldPlayerAttribute("First Touch", AttributeType.Technical, AttributeCategory.BallControl));
        knownAttrs.add(new OutfieldPlayerAttribute("Flair", AttributeType.Mental, AttributeCategory.BallControl));
        knownAttrs.add(new OutfieldPlayerAttribute("Passing", AttributeType.Technical, AttributeCategory.Attacking));
        knownAttrs.add(new OutfieldPlayerAttribute("Stamina", AttributeType.Physical, AttributeCategory.Strength));
        knownAttrs.add(new OutfieldPlayerAttribute("Teamwork", AttributeType.Mental, AttributeCategory.Tactics));
        knownAttrs.add(new OutfieldPlayerAttribute("Technique", AttributeType.Technical, AttributeCategory.BallControl));
        knownAttrs.add(new OutfieldPlayerAttribute("Work Rate", AttributeType.Mental, AttributeCategory.Strength));
        assertTrue(attrs.containsAll(knownAttrs));
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.access.KeyAttributesServiceImpl#getDAOs()}
     * .
     */
    @Test
    public void testGetDAOs() {
        assertTrue(0 < service.getDAOs().size());
    }

}
