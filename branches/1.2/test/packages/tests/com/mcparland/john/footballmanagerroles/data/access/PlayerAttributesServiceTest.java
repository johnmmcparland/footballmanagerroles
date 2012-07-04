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

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.data.access.AttributesService;
import com.mcparland.john.footballmanagerroles.data.access.PlayerAttributesService;
import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.attributes.OutfieldPlayerAttribute;

/**
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.data.access.PlayerAttributesService}
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
@ContextConfiguration(locations = { "classpath:/com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml", "classpath:/tests/com/mcparland/john/footballmanagerroles/config/test_datasource.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class PlayerAttributesServiceTest {

    /**
     * The attributes service tested
     */
    private AttributesService service = null;

    /**
     * Set the attributes service to use
     * 
     * @param service
     *            The service to use
     */
    @Autowired
    public void setAttributesService(AttributesService service) {
        if (service instanceof PlayerAttributesService) {
            this.service = service;
        } else {
            throw new IllegalArgumentException(
                    "Not the right kind of AttributesService, expected PlayerAttributesService, got "
                            + service.getClass());
        }
    }

    /**
     * Get the attributes service which is under test
     * 
     * @return The tested attributes service
     */
    public AttributesService getAttributesService() {
        return service;
    }

    @Test
    public void testGetAttributes() {
        // Ensure we have the right attributes
        Attributes attributes = service.getAttributes();
        Collection<Attribute> attrs = attributes.getAttributes();
        Assert.assertEquals(50, attrs.size());
        Assert.assertTrue(attrs.contains(new OutfieldPlayerAttribute("Crossing", AttributeType.Technical)));
    }
    
}
