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
package tests.com.mcparland.john.footballmanagerroles.data.roles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.data.exceptions.PitchAreaAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PitchAreaCollection;
import com.mcparland.john.footballmanagerroles.data.roles.PitchAreaCollectionImpl;

/**
 * Test class for
 * {@link com.mcparlan.john.footballmanagerroles.data.roles.PitchAreaCollectionImpl}
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
public class PitchAreaCollectionTest {

    /**
     * The collection being tested
     */
    private PitchAreaCollection collection = null;

    /**
     * Set the PitchAreaCollection to test
     * 
     * @param collection
     *            The collection to test
     */
    @Autowired
    public void setPitchAreaCollectionImpl(PitchAreaCollectionImpl collection) {
        this.collection = collection;
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PitchAreaCollectionImpl#getPitchArea(java.lang.String)}
     * .
     */
    @Test
    public void testGetPitchArea() {
        assertEquals(PitchArea.Defender, collection.getPitchArea("Defender"));
        assertEquals(PitchArea.Defender, collection.getPitchArea("D"));
        assertEquals(PitchArea.AttackingMidfielder, collection.getPitchArea("Attacking Midfielder"));
        assertEquals(PitchArea.AttackingMidfielder, collection.getPitchArea("AM"));
        assertEquals(null, collection.getPitchArea(null));
        assertEquals(null, collection.getPitchArea("Oogba booga"));
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PitchAreaCollectionImpl#addPitchArea(com.mcparland.john.footballmanagerroles.data.roles.PitchArea)}
     * .
     */
    @Test
    public void testAddPitchArea() {
        PitchAreaCollection col = new PitchAreaCollectionImpl();

        // Simple add
        boolean exceptionCaught = false;
        try {
            col.addPitchArea(PitchArea.AttackingMidfielder);
        } catch (PitchAreaAlreadyAddedException paaae) {
            fail("PitchAreaAlreadyAddedException caught when not expected: " + paaae.getMessage());
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);

        // Add a different one
        try {
            col.addPitchArea(PitchArea.Goalkeeper);
        } catch (PitchAreaAlreadyAddedException paaae) {
            fail("PitchAreaAlreadyAddedException caught when not expected: " + paaae.getMessage());
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);

        // Add an existing one
        try {
            col.addPitchArea(PitchArea.AttackingMidfielder);
        } catch (PitchAreaAlreadyAddedException paaae) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
    }

}
