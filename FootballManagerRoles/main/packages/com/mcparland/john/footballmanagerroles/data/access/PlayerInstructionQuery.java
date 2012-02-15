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
package com.mcparland.john.footballmanagerroles.data.access;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mcparland.john.footballmanagerroles.data.roles.Duty;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction;
import com.mcparland.john.footballmanagerroles.data.roles.PlayerInstructionImpl;
import com.mcparland.john.footballmanagerroles.data.roles.Role;

/**
 * Obtains a PlayerInstruction
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
public class PlayerInstructionQuery implements RowMapper<PlayerInstruction> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
     * int)
     */
    @Override
    public PlayerInstruction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = null;
        Duty duty = null;
        String viewName = null;

        // Read the role
        String roleString = rs.getString("role");
        try {
            role = Role.valueOf(roleString);
        } catch (Exception ex) {
            throw new SQLException("The role read is not valid " + roleString, ex);
        }

        // Read the duty
        String dutyString = rs.getString("duty");
        try {
            duty = Duty.valueOf(dutyString);
        } catch (Exception ex) {
            throw new SQLException("The duty read is not valid " + dutyString, ex);
        }

        // Read the view name
        viewName = rs.getString("viewname");

        // Create the instruction and return
        return new PlayerInstructionImpl(role, duty, viewName);
    }

}
