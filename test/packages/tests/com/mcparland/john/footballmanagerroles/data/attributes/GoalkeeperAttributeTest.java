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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeCategory;
import com.mcparland.john.footballmanagerroles.data.attributes.AttributeType;
import com.mcparland.john.footballmanagerroles.data.attributes.GoalkeeperAttribute;
import com.mcparland.john.footballmanagerroles.data.exceptions.IncorrectAttributeTypeException;

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
public class GoalkeeperAttributeTest {

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.GoalkeeperAttribute#GoalkeeperAttribute()}
     * .
     */
    @Test
    public void testGoalkeeperAttribute() {
        Attribute attr = new GoalkeeperAttribute();
        assertNotNull(attr);
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.GoalkeeperAttribute#GoalkeeperAttribute(java.lang.String)}
     * .
     */
    @Test
    public void testGoalkeeperAttributeString() {
        Attribute attr = new GoalkeeperAttribute("Handling");
        assertEquals("Handling", attr.getName());
        assertEquals(AttributeType.Goalkeeping, attr.getType());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.AbstractAttribute#hashCode()}
     * .
     */
    @Test
    public void testHashCode() {
        Attribute attr = new GoalkeeperAttribute("Handling");
        attr.setCategory(AttributeCategory.GKHandling);
        attr.setType(AttributeType.Goalkeeping);

        // Different name
        Attribute attr1 = new GoalkeeperAttribute("Kicking");
        attr1.setCategory(AttributeCategory.GKHandling);
        attr1.setType(AttributeType.Goalkeeping);
        assertNotSame(attr.hashCode(), attr1.hashCode());

        // Different category and name
        Attribute attr2 = new GoalkeeperAttribute("Reflexes");
        attr2.setCategory(AttributeCategory.GKShotStopping);
        attr2.setType(AttributeType.Goalkeeping);
        assertNotSame(attr.hashCode(), attr2.hashCode());

        // Different in all three
        Attribute attr3 = new GoalkeeperAttribute("Anticipation");
        attr3.setCategory(AttributeCategory.Tactics);
        attr3.setType(AttributeType.Mental);
        assertNotSame(attr.hashCode(), attr3.hashCode());

        // Same
        Attribute attr4 = new GoalkeeperAttribute("Handling");
        attr4.setCategory(AttributeCategory.GKHandling);
        attr4.setType(AttributeType.Goalkeeping);
        assertEquals(attr.hashCode(), attr4.hashCode());

    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.AbstractAttribute#getType()}
     * .
     */
    @Test
    public void testGetType() {
        Attribute attr = new GoalkeeperAttribute();
        attr.setType(AttributeType.Goalkeeping);
        assertEquals(AttributeType.Goalkeeping, attr.getType());
        attr.setType(AttributeType.Mental);
        assertEquals(AttributeType.Mental, attr.getType());
        attr.setType(AttributeType.Physical);
        assertEquals(AttributeType.Physical, attr.getType());
        boolean exceptionCaught = false;
        try {
            attr.setType(AttributeType.Technical);
        } catch (IncorrectAttributeTypeException iae) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertEquals(AttributeType.Physical, attr.getType());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.AbstractAttribute#getName()}
     * .
     */
    @Test
    public void testGetName() {
        Attribute attr = new GoalkeeperAttribute("Handling");
        assertEquals("Handling", attr.getName());
        attr.setName("Reflexes");
        assertEquals("Reflexes", attr.getName());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.AbstractAttribute#getCategory()}
     * .
     */
    @Test
    public void testGetCategory() {
        Attribute attr = new GoalkeeperAttribute("Handling");
        attr.setCategory(AttributeCategory.GKHandling);
        assertEquals(AttributeCategory.GKHandling, attr.getCategory());
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.AbstractAttribute#compareTo(com.mcparland.john.footballmanagerroles.data.attributes.Attribute)}
     * .
     */
    @Test
    public void testCompareTo() {
        Attribute attr = new GoalkeeperAttribute("Handling");
        attr.setCategory(AttributeCategory.GKHandling);
        attr.setType(AttributeType.Goalkeeping);

        // Different name
        Attribute attr1 = new GoalkeeperAttribute("Kicking");
        attr1.setCategory(AttributeCategory.GKHandling);
        attr1.setType(AttributeType.Goalkeeping);
        assertFalse(0 == attr.compareTo(attr1));

        // Different category and name
        Attribute attr2 = new GoalkeeperAttribute("Reflexes");
        attr2.setCategory(AttributeCategory.GKShotStopping);
        attr2.setType(AttributeType.Goalkeeping);
        assertFalse(0 == attr.compareTo(attr2));

        // Different in all three
        Attribute attr3 = new GoalkeeperAttribute("Anticipation");
        attr3.setCategory(AttributeCategory.Tactics);
        attr3.setType(AttributeType.Mental);
        assertFalse(0 == attr.compareTo(attr3));

        // Same
        Attribute attr4 = new GoalkeeperAttribute("Handling");
        attr4.setCategory(AttributeCategory.GKHandling);
        attr4.setType(AttributeType.Goalkeeping);
        assertTrue(0 == attr.compareTo(attr4));
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.attributes.AbstractAttribute#equals(Object)}
     * .
     */
    @Test
    public void testEquals() {
        Attribute attr = new GoalkeeperAttribute("Handling");
        attr.setCategory(AttributeCategory.GKHandling);
        attr.setType(AttributeType.Goalkeeping);

        // Different name
        Attribute attr1 = new GoalkeeperAttribute("Kicking");
        attr1.setCategory(AttributeCategory.GKHandling);
        attr1.setType(AttributeType.Goalkeeping);
        assertFalse(attr.equals(attr1));

        // Different category and name
        Attribute attr2 = new GoalkeeperAttribute("Reflexes");
        attr2.setCategory(AttributeCategory.GKShotStopping);
        attr2.setType(AttributeType.Goalkeeping);
        assertFalse(attr.equals(attr2));

        // Different in all three
        Attribute attr3 = new GoalkeeperAttribute("Anticipation");
        attr3.setCategory(AttributeCategory.Tactics);
        attr3.setType(AttributeType.Mental);
        assertFalse(attr.equals(attr3));

        // Same
        Attribute attr4 = new GoalkeeperAttribute("Handling");
        attr4.setCategory(AttributeCategory.GKHandling);
        attr4.setType(AttributeType.Goalkeeping);
        assertTrue(attr.equals(attr4));
    }

}
