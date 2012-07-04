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
package tests.com.mcparland.john.footballmanagerroles.data.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeCategory;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.attributes.OutfieldPlayerAttribute;
import com.mcparland.john.footballmanagerroles.data.attributes.PlayerAttributes;
import com.mcparland.john.footballmanagerroles.data.exceptions.AttributeAlreadyAddedException;

/**
 * Test class for {@link PlayerAttributes}
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
public class PlayerAttributesTest {

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.PlayerAttributes#PlayerAttributes()}
     * .
     */
    @Test
    public void testPlayerAttributes() {
        Attributes attrs = new PlayerAttributes();
        assertNotNull(attrs);
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.PlayerAttributes#addAttribute(com.mcparland.john.footballmanagerroles.data.attributes.Attribute)}
     * .
     */
    @Test
    public void testAddAttribute() {
        Attributes attrs = new PlayerAttributes();

        // Add one
        Attribute attribute = new OutfieldPlayerAttribute("Heading", AttributeType.Technical);
        attribute.setCategory(AttributeCategory.BallControl);

        attrs.addAttribute(attribute);
        assertTrue(attrs.getAttributes().contains(attribute));

        // Try to add it again
        boolean exceptionCaught = false;
        try {
            attrs.addAttribute(attribute);
        } catch (AttributeAlreadyAddedException aaae) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertTrue(attrs.getAttributes().contains(attribute));

        // Add one of another type
        Attribute attribute1 = new OutfieldPlayerAttribute("Anticipation", AttributeType.Mental);
        attribute1.setCategory(AttributeCategory.Tactics);
        attrs.addAttribute(attribute1);
        assertTrue(attrs.getAttributes().contains(attribute1));

        // Add one of the existing types
        Attribute attribute2 = new OutfieldPlayerAttribute("Decisions", AttributeType.Mental);
        attribute2.setCategory(AttributeCategory.Tactics);
        attrs.addAttribute(attribute2);
        assertTrue(attrs.getAttributes().contains(attribute2));

        // Check sizes etc
        assertEquals(3, attrs.getAttributes().size());
        assertEquals(2, attrs.getAttributes(AttributeType.Mental).size());
        assertEquals(1, attrs.getAttributes(AttributeType.Technical).size());

        Attribute toCheck = attrs.getAttribute(attribute.getName(), attribute.getType());
        assertEquals(attribute, toCheck);

        assertNull(attrs.getAttribute(attribute1.getName(), AttributeType.Physical));
    }

}
