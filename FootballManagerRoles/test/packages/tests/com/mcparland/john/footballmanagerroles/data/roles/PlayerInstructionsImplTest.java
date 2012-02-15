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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.data.exceptions.PlayerInstructionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionsImpl;
import com.mcparland.john.footballmanagerroles.data.roles.Role;

/**
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionsImpl}
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
public class PlayerInstructionsImplTest {

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionsImpl#PlayerInstructionsImpl()}
     * .
     */
    @Test
    public void testPlayerInstructionsImpl() {
        PlayerInstructions instructions = new PlayerInstructionsImpl();
        assertNotNull(instructions);
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionsImpl#addPlayerInstruction(com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction)}
     * .
     */
    @Test
    public void testAddPlayerInstruction() {
        PlayerInstructions instructions = new PlayerInstructionsImpl();

        // Ordinary add
        PlayerInstruction ins = new PlayerInstructionImpl(Role.AdvancedForward, Duty.Attack, "AF_A");
        try {
            instructions.addPlayerInstruction(ins);
        } catch (PlayerInstructionAlreadyAddedException e) {
            e.printStackTrace();
            fail("Caught PlayerInstructionAlreadyAddedException when not expected: " + e.getMessage());
        }
        assertTrue(instructions.getPlayerInstructions().contains(ins));
        assertEquals(1, instructions.getPlayerInstructions().size());
        assertTrue(instructions.getViewNameToPlayerInstructions().get("AF_A").contains(ins));
        assertEquals(1, instructions.getViewNameToPlayerInstructions().get("AF_A").size());

        // Duplicate
        boolean exceptionCaught = false;
        try {
            instructions.addPlayerInstruction(ins);
        } catch (PlayerInstructionAlreadyAddedException e) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        assertTrue(instructions.getPlayerInstructions().contains(ins));
        assertEquals(1, instructions.getPlayerInstructions().size());
        assertTrue(instructions.getViewNameToPlayerInstructions().get("AF_A").contains(ins));
        assertEquals(1, instructions.getViewNameToPlayerInstructions().get("AF_A").size());
        exceptionCaught = false;

        // Another add, different view name
        PlayerInstruction ins1 = new PlayerInstructionImpl(Role.CompleteForward, Duty.Support, "CF_SA");
        try {
            instructions.addPlayerInstruction(ins1);
        } catch (PlayerInstructionAlreadyAddedException e) {
            e.printStackTrace();
            fail("Caught PlayerInstructionAlreadyAddedException when not expected: " + e.getMessage());
        }
        assertTrue(instructions.getPlayerInstructions().contains(ins1));
        assertEquals(2, instructions.getPlayerInstructions().size());
        assertTrue(instructions.getViewNameToPlayerInstructions().get("CF_SA").contains(ins1));
        assertEquals(1, instructions.getViewNameToPlayerInstructions().get("CF_SA").size());

        // Another add, this time with the same view name
        PlayerInstruction ins2 = new PlayerInstructionImpl(Role.CompleteForward, Duty.Attack, "CF_SA");
        try {
            instructions.addPlayerInstruction(ins2);
        } catch (PlayerInstructionAlreadyAddedException e) {
            e.printStackTrace();
            fail("Caught PlayerInstructionAlreadyAddedException when not expected: " + e.getMessage());
        }
        assertTrue(instructions.getPlayerInstructions().contains(ins1));
        assertEquals(3, instructions.getPlayerInstructions().size());
        assertTrue(instructions.getViewNameToPlayerInstructions().get("CF_SA").contains(ins1));
        assertTrue(instructions.getViewNameToPlayerInstructions().get("CF_SA").contains(ins2));
        assertEquals(2, instructions.getViewNameToPlayerInstructions().get("CF_SA").size());
    }

}
