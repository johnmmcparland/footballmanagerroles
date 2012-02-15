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

import com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionService;
import com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionServiceImpl;
import com.mcparland.john.footballmanagerroles.data.exceptions.PlayerInstructionAlreadyAddedException;
import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PitchArea;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructions;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerPosition;
import com.mcparland.john.footballmanagerroles.data.roles.Position;
import com.mcparland.john.footballmanagerroles.data.roles.Role;
import com.mcparland.john.footballmanagerroles.data.roles.Side;

/**
 * Test class for
 * {@link com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionsServiceImpl}
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
public class PlayerInstructionServiceTest {

    /**
     * The PlayerInstructionsService under test
     */
    private PlayerInstructionServiceImpl playerInstructionService = null;

    /**
     * Set the PlayerInstructionService to test
     * 
     * @param playerInstructionService
     *            The service to test
     */
    @Autowired
    public void setPlayerInstructionService(PlayerInstructionService playerInstructionService) {
        if (playerInstructionService instanceof PlayerInstructionServiceImpl) {
            this.playerInstructionService = (PlayerInstructionServiceImpl) playerInstructionService;
        } else {
            throw new IllegalArgumentException(
                    "Wrong kind of PlayerInstructionService to test.  Expected a PlayerInstructionServiceImpl but got a "
                            + playerInstructionService.getClass());
        }
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.data.access.PlayerInstructionServiceImpl#determinePossiblePlayerInstructions(java.util.Collection)}
     * .
     */
    @Test
    public void testDeterminePossiblePlayerInstructions() {
        Collection<Position> positions = new ArrayList<Position>();
        PlayerInstructions instructions = null;

        try {

            // Case 1: One position only [Striker, Centre]
            Position pos = new PlayerPosition(PitchArea.Striker, Side.Centre);
            positions.add(pos);
            instructions = playerInstructionService.determinePossiblePlayerInstructions(positions);
            assertEquals(11, instructions.getPlayerInstructions().size());
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.AdvancedForward, Duty.Attack, "AF_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CompleteForward, Duty.Attack, "CF_SA")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CompleteForward, Duty.Support, "CF_SA")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DeepLyingForward, Duty.Attack, "DLF_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DeepLyingForward, Duty.Support, "DLF_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DefensiveForward, Duty.Support, "DF_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DefensiveForward, Duty.Attack, "DF_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.Poacher, Duty.Attack, "P_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.TargetMan, Duty.Attack, "TM_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.TargetMan, Duty.Support, "TM_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.Trequartista, Duty.Attack, "T_A")));
            
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("AF_A").size());
            assertTrue(instructions.getViewNameToPlayerInstructions().get("AF_A").contains( new PlayerInstructionImpl(Role.AdvancedForward, Duty.Attack, "AF_A")));
            assertEquals(2,instructions.getViewNameToPlayerInstructions().get("CF_SA").size());
            assertTrue(instructions.getViewNameToPlayerInstructions().get("CF_SA").contains( new PlayerInstructionImpl(Role.CompleteForward, Duty.Attack, "CF_SA")));
            assertTrue(instructions.getViewNameToPlayerInstructions().get("CF_SA").contains( new PlayerInstructionImpl(Role.CompleteForward, Duty.Support, "CF_SA")));
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("DLF_A").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("DLF_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("DF_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("DF_A").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("P_A").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("TM_A").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("TM_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("T_A").size());
            
            // Case 2: Two positions on the same line [Defender right and centre]
            positions.clear();
            pos = new PlayerPosition(PitchArea.Defender, Side.Centre);
            positions.add(pos);
            pos = new PlayerPosition(PitchArea.Defender, Side.Left);
            positions.add(pos);
            instructions = playerInstructionService.determinePossiblePlayerInstructions(positions);
            assertEquals(17, instructions.getPlayerInstructions().size());
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.BallPlayingDefender, Duty.Cover, "BPD_C")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.BallPlayingDefender, Duty.Defend, "BPD_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.BallPlayingDefender, Duty.Stopper, "BPD_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CentralDefender, Duty.Cover, "CD_C")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CentralDefender, Duty.Defend, "CD_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CentralDefender, Duty.Stopper, "CD_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.LimitedDefender, Duty.Cover, "LD_C")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.LimitedDefender, Duty.Defend, "LD_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.LimitedDefender, Duty.Stopper, "LD_S")));
            
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Attack, "FB_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Automatic, "FB_SAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Defend, "FB_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.FullBack, Duty.Support, "FB_SAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Attack, "WB_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Automatic, "WB_SAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Defend, "WB_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WingBack, Duty.Support, "WB_SAu")));
            
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("BPD_C").size());
            assertTrue(instructions.getViewNameToPlayerInstructions().get("BPD_C").contains(new PlayerInstructionImpl(Role.BallPlayingDefender, Duty.Cover, "BPD_C")));
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("BPD_D").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("BPD_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("CD_C").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("CD_D").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("CD_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("LD_C").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("LD_D").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("LD_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("FB_A").size());
            assertEquals(2,instructions.getViewNameToPlayerInstructions().get("FB_SAu").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("FB_D").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("WB_A").size());
            assertEquals(2,instructions.getViewNameToPlayerInstructions().get("WB_SAu").size());
            assertTrue(instructions.getViewNameToPlayerInstructions().get("WB_SAu").contains(new PlayerInstructionImpl(Role.WingBack, Duty.Automatic, "WB_SAu")));
            assertTrue(instructions.getViewNameToPlayerInstructions().get("WB_SAu").contains(new PlayerInstructionImpl(Role.WingBack, Duty.Support, "WB_SAu")));
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("WB_D").size());
            
            // Case 3: Positions on different lines, including some with the same view name twice [Midfielder, Attacking Midfielder, Right, Centre]
            positions.clear();
            pos = new PlayerPosition(PitchArea.Midfielder, Side.Centre);
            positions.add(pos);
            pos = new PlayerPosition(PitchArea.Midfielder, Side.Right);
            positions.add(pos);
            pos = new PlayerPosition(PitchArea.AttackingMidfielder, Side.Centre);
            positions.add(pos);
            pos = new PlayerPosition(PitchArea.AttackingMidfielder, Side.Right);
            positions.add(pos);
            
            instructions = playerInstructionService.determinePossiblePlayerInstructions(positions);
            
            assertEquals(24, instructions.getPlayerInstructions().size());
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Attack, "AP_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Support, "AP_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Attack, "AM_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.AttackingMidfielder, Duty.Support, "AM_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.BallWinningMidfielder, Duty.Defend, "BWM_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.BallWinningMidfielder, Duty.Support, "BWM_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.BoxToBoxMidfielder, Duty.Support, "B2BM_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Attack, "CM_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Automatic, "CM_SAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Defend, "CM_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Support, "CM_SAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DeepLyingPlaymaker, Duty.Defend, "DLP_D")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DeepLyingPlaymaker, Duty.Support, "DLP_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Attack, "DW_SA")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.DefensiveWinger, Duty.Support, "DW_SA")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.InsideForward, Duty.Attack, "IF_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.InsideForward, Duty.Support, "IF_S")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.Trequartista, Duty.Attack, "T_A")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Attack, "WM_DSAAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Automatic, "WM_DSAAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Defend, "WM_DSAAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.WideMidfielder, Duty.Support, "WM_DSAAu")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.Winger, Duty.Attack, "W_SA")));
            assertTrue(instructions.getPlayerInstructions().contains(
                    new PlayerInstructionImpl(Role.Winger, Duty.Support, "W_SA")));
            
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("AP_A").size());
            assertTrue(instructions.getViewNameToPlayerInstructions().get("AP_A").contains(new PlayerInstructionImpl(Role.AdvancedPlaymaker, Duty.Attack, "AP_A")));
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("AP_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("AM_A").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("AM_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("BWM_D").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("BWM_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("B2BM_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("CM_A").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("CM_D").size());
            assertEquals(2,instructions.getViewNameToPlayerInstructions().get("CM_SAu").size());
            assertTrue(instructions.getViewNameToPlayerInstructions().get("CM_SAu").contains(new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Automatic, "CM_SAu")));
            assertTrue(instructions.getViewNameToPlayerInstructions().get("CM_SAu").contains(new PlayerInstructionImpl(Role.CentralMidfielder, Duty.Support, "CM_SAu")));
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("DLP_D").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("DLP_S").size());
            assertEquals(2,instructions.getViewNameToPlayerInstructions().get("DW_SA").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("IF_S").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("IF_A").size());
            assertEquals(1,instructions.getViewNameToPlayerInstructions().get("T_A").size());
            assertEquals(4,instructions.getViewNameToPlayerInstructions().get("WM_DSAAu").size());
            assertTrue(instructions.getViewNameToPlayerInstructions().get("WM_DSAAu").contains(new PlayerInstructionImpl(Role.WideMidfielder, Duty.Defend, "WM_DSAAu")));
            assertTrue(instructions.getViewNameToPlayerInstructions().get("WM_DSAAu").contains(new PlayerInstructionImpl(Role.WideMidfielder, Duty.Support, "WM_DSAAu")));
            assertTrue(instructions.getViewNameToPlayerInstructions().get("WM_DSAAu").contains(new PlayerInstructionImpl(Role.WideMidfielder, Duty.Attack, "WM_DSAAu")));
            assertTrue(instructions.getViewNameToPlayerInstructions().get("WM_DSAAu").contains(new PlayerInstructionImpl(Role.WideMidfielder, Duty.Automatic, "WM_DSAAu")));
            assertEquals(2,instructions.getViewNameToPlayerInstructions().get("W_SA").size());
            
        } catch (PlayerInstructionAlreadyAddedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
