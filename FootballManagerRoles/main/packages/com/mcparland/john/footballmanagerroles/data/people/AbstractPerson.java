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
/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.people;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.exceptions.AttributeAlreadySetException;
import com.mcparland.john.footballmanagerroles.data.exceptions.NoSuchAttributeException;

/**
 * A Person
 * 
 * @author John
 * 
 */
abstract class AbstractPerson implements Person {

    /**
     * Their name
     */
    protected String name = "";

    /**
     * The club they are contracted to
     */
    protected String club = "";

    /**
     * First nationality
     */
    protected String nationality = "";

    /**
     * Age
     */
    protected String age = "0";

    /**
     * Their international status (caps and goals)
     */
    protected String internationalStatus = "Uncapped";

    /**
     * Their date of birth
     */
    protected String dob = "";

    /**
     * The date this persons contract expires
     */
    protected String contractExpiry = "";

    /**
     * Their attributes (attribute name -> value) We want these sorted
     */
    protected Map<Attribute, Integer> attributes = new TreeMap<Attribute, Integer>();

    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractPerson.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Person#getName()
     */
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#setName(java.lang
     * .String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Person#getClub()
     */
    public String getClub() {
        return club;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#setClub(java.lang
     * .String)
     */
    public void setClub(String club) {
        this.club = club;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Person#getNationality()
     */
    public String getNationality() {
        return nationality;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#setNationality(java
     * .lang.String)
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#getInternationalStatus
     * ()
     */
    public String getInternationalStatus() {
        return internationalStatus;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#setInternationalStatus
     * (java.lang.String)
     */
    public void setInternationalStatus(String internationalStatus) {
        this.internationalStatus = internationalStatus;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Person#getAge()
     */
    public String getAge() {
        return age;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Person#setAge(int)
     */
    public void setAge(String age) {
        this.age = age;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Person#getDob()
     */
    public String getDob() {
        return dob;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#setDob(java.util.
     * Date)
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#getContractExpiry()
     */
    public String getContractExpiry() {
        return contractExpiry;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#setContractExpiry
     * (java.util.Date)
     */
    public void setContractExpiry(String contractExpiry) {
        this.contractExpiry = contractExpiry;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#addAttribute(Attribute
     * , int)
     */
    public void addAttribute(Attribute attr, int value) throws AttributeAlreadySetException, IllegalArgumentException {
        if (null == attr) {
            // Warning because IllegalArgumentException is a RuntimeException
            LOGGER.warning(toString() + " - Given null attribute");
            throw new IllegalArgumentException("The attribute name cannot be null");
        }
        if (attributes.containsKey(attr)) {
            throw new AttributeAlreadySetException(attr, attributes.get(attr), value);
        }
        attributes.put(attr, value);
        LOGGER.finer(toString() + " - Added attribute:" + attr + "," + value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#removeAttribute(Attribute
     */
    public void removeAttribute(Attribute attr) throws NoSuchAttributeException, IllegalArgumentException

    {
        if (null == attr) {
            LOGGER.warning(toString() + ": - The attribute name was null");
            throw new IllegalArgumentException("The attribute name cannot be null");
        }
        if (!attributes.containsKey(attr)) {
            throw new NoSuchAttributeException(attr);
        }
        attributes.remove(attr);
        LOGGER.finer(toString() + " - Removed attribute: " + attr);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.data.Person#clearAttributes()
     */
    public void clearAttributes() {
        attributes.clear();
        LOGGER.fine("Cleared all attributes");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mcparland.john.footballmanagerroles.data.Person#getAttributes()
     */
    public Map<Attribute, Integer> getAttributes() {
        return attributes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = name + " (" + club + ") - " + dob + " (" + age + ")\n" + nationality + " (" + internationalStatus
                + ")\n";
        if (0 < attributes.size()) {
            for (Attribute attr : attributes.keySet()) {
                str += attr.getName() + ": " + attributes.get(attr) + "\n";
            }
        }
        return str;

    }
}
