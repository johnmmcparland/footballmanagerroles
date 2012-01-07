/**
 * Person.java
 * John McParland
 * Created: 10 May 2011
 */
package com.mcparland.john.footballmanagerroles.data.people;

import java.util.Map;

import com.mcparland.john.footballmanagerroles.data.attributes.Attribute;
import com.mcparland.john.footballmanagerroles.data.exceptions.AttributeAlreadySetException;
import com.mcparland.john.footballmanagerroles.data.exceptions.NoSuchAttributeException;

/**
 * A person in Football Manager
 * 
 * @author John McPaland
 * 
 */
public interface Person {

    /**
     * @return Their name
     */
    public String getName();

    /**
     * @param name
     *            Their name
     */
    public void setName(String name);

    /**
     * @return Their club
     */
    public String getClub();

    /**
     * @param club
     *            Their club
     */
    public void setClub(String club);

    /**
     * @return Their nationality
     */
    public String getNationality();

    /**
     * @param nation
     *            Their nationality
     */
    public void setNationality(String nation);

    /**
     * @return Their age
     */
    public String getAge();

    /**
     * @param age
     *            Their age
     */
    public void setAge(String age);

    /**
     * @return Their international status
     */
    public String getInternationalStatus();

    /**
     * @param internationalStatus
     *            Their international status
     */
    public void setInternationalStatus(String internationalStatus);

    /**
     * @return Their date of birth
     */
    public String getDob();

    /**
     * @param dob
     *            Their date of birth
     */
    public void setDob(String dob);

    /**
     * @return The date this persons contract expires
     */
    public String getContractExpiry();

    /**
     * @param contractExpiry
     *            The date this persons contract expires
     */
    public void setContractExpiry(String contractExpiry);

    /**
     * @return Their attributes
     */
    public Map<Attribute, Integer> getAttributes();

    /**
     * Adds an attribute. Attributes cannot be over-ridden.
     * 
     * @param attr
     *            The attribute to add. Mustn't be null.
     * @param value
     *            The value of the attribute to add. Mustn't be null.
     * @throws AttributeAlreadySetException
     *             If the attribute is already set.
     * @throws IllegalArgumentException
     *             If either parameter is null.
     */
    public void addAttribute(Attribute attr, int value) throws AttributeAlreadySetException, IllegalArgumentException;

    /**
     * Removes an attribute. Only removes it if it exists.
     * 
     * @param attr
     *            The attribute to remove.
     * @throws NoSuchAttributeException
     *             If the attribute doesn't exist.
     * @throws IllegalArgumentException
     *             If the attribute given is null
     */
    public void removeAttribute(Attribute attr) throws NoSuchAttributeException, IllegalArgumentException;

    /**
     * Clears all attributes
     */
    public void clearAttributes();

}
