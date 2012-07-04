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
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.Role;

/**
 * Test case for {@link PlayerInstructionImpl}
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
public class PlayerInstructionImplTest {

    /**
     * Test case for {@link PlayerInstructionImpl#getRole()}
     */
    @Test
    public void testGetRole() {
        PlayerInstruction instruction = new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Support, "AP_S");
        assertEquals(Role.AdvancedPlaymaker, instruction.getRole());
        instruction.setRole(Role.AnchorMan);
        assertEquals(Role.AnchorMan, instruction.getRole());
    }

    /**
     * Test case for {@link PlayerInstructionImpl#getDuty()}
     */
    @Test
    public void testGetDuty() {
        PlayerInstruction instruction = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        assertEquals(Duty.Defend, instruction.getDuty());
        instruction.setDuty(Duty.Cover);
        assertEquals(Duty.Cover, instruction.getDuty());
    }

    /**
     * Test case for {@link PlayerInstructionImpl#getViewName()}
     */
    @Test
    public void testGetViewName() {
        PlayerInstruction instruction = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        assertEquals("CD_D", instruction.getViewName());
        instruction.setViewName("CD_C");
        assertEquals("CD_C", instruction.getViewName());
    }
    
    /**
     * Test case for {@link PlayerInstructionImpl#compareTo(PlayerInstruction)}
     */
    @Test
    public void testCompareTo() {
        // Same role, duty, view name
        PlayerInstruction instruction = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        PlayerInstruction instruction1 = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        assertEquals(0, instruction.compareTo(instruction1));
        assertTrue(instruction.equals(instruction1));
        assertEquals(instruction.hashCode(), instruction1.hashCode());

        // Different role only
        instruction1.setRole(Role.CentralMidfielder);
        assertNotSame(0, instruction.compareTo(instruction1));
        assertFalse(instruction.equals(instruction1));
        assertNotSame(instruction.hashCode(), instruction1.hashCode());

        // Different duty only
        instruction1.setRole(Role.CentralDefender);
        instruction1.setDuty(Duty.Stopper);
        assertNotSame(0, instruction.compareTo(instruction1));
        assertFalse(instruction.equals(instruction1));
        assertNotSame(instruction.hashCode(), instruction1.hashCode());

        // Different view name only
        instruction = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        instruction1 = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_S");
        assertNotSame(0, instruction.compareTo(instruction1));
        assertFalse(instruction.equals(instruction1));
        assertNotSame(instruction.hashCode(), instruction1.hashCode());

        // Different role and duty but same view name
        instruction = new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Attack, "CD_D");
        instruction1 = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        assertNotSame(0, instruction.compareTo(instruction1));
        assertFalse(instruction.equals(instruction1));
        assertNotSame(instruction.hashCode(), instruction1.hashCode());

        // Different role and view name, same duty
        instruction = new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Defend, "AM_D");
        instruction1 = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        assertNotSame(0, instruction.compareTo(instruction1));
        assertFalse(instruction.equals(instruction1));
        assertNotSame(instruction.hashCode(), instruction1.hashCode());

        // Different duty and view name, same role
        instruction = new PlayerInstructionImpl(Role.CentralDefender, Duty.Attack, "AM_D");
        instruction1 = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        assertNotSame(0, instruction.compareTo(instruction1));
        assertFalse(instruction.equals(instruction1));
        assertNotSame(instruction.hashCode(), instruction1.hashCode());

        // All three different
        instruction = new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Attack, "AM_A");
        instruction1 = new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D");
        assertNotSame(0, instruction.compareTo(instruction1));
        assertFalse(instruction.equals(instruction1));
        assertNotSame(instruction.hashCode(), instruction1.hashCode());
    }

}
