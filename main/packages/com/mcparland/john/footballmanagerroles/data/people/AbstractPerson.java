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
        attributes.remove(name);
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
