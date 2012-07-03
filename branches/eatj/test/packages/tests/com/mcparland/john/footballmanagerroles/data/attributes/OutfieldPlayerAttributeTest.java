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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.OutfieldPlayerAttribute;
import com.mcparland.john.footballmanagerroles.data.exceptions.IncorrectAttributeTypeException;

/**
 * Test class for {@link OutfieldPlayerAttribute}
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
public class OutfieldPlayerAttributeTest {

    /**
     * Test for {@link OutfieldPlayerAttribute#setType(AttributeType)}
     */
    @Test
    public void testSetType() {
        Attribute attr = new OutfieldPlayerAttribute();
        attr.setType(AttributeType.Technical);
        assertEquals(AttributeType.Technical, attr.getType());
        attr.setType(AttributeType.Mental);
        assertEquals(AttributeType.Mental, attr.getType());
        attr.setType(AttributeType.Physical);
        assertEquals(AttributeType.Physical, attr.getType());
        boolean exceptionCaught = false;
        try {
            attr.setType(AttributeType.Goalkeeping);
        } catch (IncorrectAttributeTypeException iae) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertEquals(AttributeType.Physical, attr.getType());
    }

    /**
     * Test for {@link OutfieldPlayerAttribute#OutfieldPlayerAttribute()}
     */
    @Test
    public void testOutfieldPlayerAttribute() {
        Attribute attr = new OutfieldPlayerAttribute();
        assertNotNull(attr);
    }

    /**
     * Test for
     * {@link OutfieldPlayerAttribute#OutfieldPlayerAttribute(String, AttributeType)}
     */
    @Test
    public void testOutfieldPlayerAttributeStringAttributeType() {
        Attribute attr = new OutfieldPlayerAttribute("Heading", AttributeType.Technical);
        assertEquals("Heading", attr.getName());
        assertEquals(AttributeType.Technical, attr.getType());
    }

}
