/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.attributes;

/**
 * Attribute types - categories under which attributes are grouped
 * 
 * @author John
 * 
 */
public enum AttributeType {

    /**
     * Goalkeeping attributes - only appear on goalkeepers
     */
    Goalkeeping, 
    
    /**
     *  Technical attributes - only appear on outfield players
     */
    Technical, 
    
    /**
     * Mental attributes 
     */
    Mental, 
    
    /**
     * Physical attributes
     */
    Physical;
}
