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
package com.mcparland.john.footballmanagerroles.data.roles;

/**
 * A Players Instruction on the field
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
public class PlayerInstructionImpl implements PlayerInstruction {

    /**
     * The Role they play
     */
    private Role role = null;

    /**
     * The Duty they carry out
     */
    private Duty duty = null;

    /**
     * The view name in which the details of this player instruction are stored
     */
    private String viewName = null;

    /**
     * Create a PlayerInstruction
     * 
     * @param role
     *            The role
     * @param duty
     *            The duty
     * @param viewName
     *            The view name
     */
    public PlayerInstructionImpl(Role role, Duty duty, String viewName) {
        this.role = role;
        this.duty = duty;
        this.viewName = viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction#
     * setRole(com.mcparland.john.footballmanagerroles.data.roles.Role)
     */
    @Override
    public void setRole(Role role) {
        this.role = role;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction#
     * getRole()
     */
    @Override
    public Role getRole() {
        return role;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction#
     * setDuty(com.mcparland.john.footballmanagerroles.data.roles.Duty)
     */
    @Override
    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction#
     * getDuty()
     */
    @Override
    public Duty getDuty() {
        return duty;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(PlayerInstruction o) {
        int diff = role.compareTo(o.getRole());
        if (0 != diff) {
            return diff;
        } else {
            diff = duty.compareTo(o.getDuty());
            if (0 != diff) {
                return diff;
            } else {
                return viewName.compareTo(o.getViewName());
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o instanceof PlayerInstruction) {
            return 0 == compareTo((PlayerInstruction) o);
        } else {
            throw new IllegalArgumentException("Object is not of PlayerInstruction type " + o.getClass());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return role.hashCode() ^ duty.hashCode() ^ viewName.hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction#
     * setViewName(java.lang.String)
     */
    @Override
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.roles.PlayerInstruction#
     * getViewName()
     */
    @Override
    public String getViewName() {
        return viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return role.getName() + " (" + duty.toString() + ")";
    }
}
