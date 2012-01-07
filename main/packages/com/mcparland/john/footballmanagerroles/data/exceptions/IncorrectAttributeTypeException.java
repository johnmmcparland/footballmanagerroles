/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.exceptions;

/**
 * Indicates an attribute is of the wrong type
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
public class IncorrectAttributeTypeException extends RuntimeException {

    /**
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = 4175816867570783897L;

    /**
     * Create an exception indicating an attribute is of the wrong type
     */
    public IncorrectAttributeTypeException() {
        super();
    }

    /**
     * Create an exception indicating an attribute is of the wrong type
     * 
     * @param message
     *            A message describing the exception
     */
    public IncorrectAttributeTypeException(String message) {
        super(message);
    }

    /**
     * Create an exception indicating an attribute is of the wrong type
     * 
     * @param cause
     *            The underlying cause of the exception
     */
    public IncorrectAttributeTypeException(Throwable cause) {
        super(cause);
    }

    /**
     * Create an exception indicating an attribute is of the wrong type
     * 
     * @param message
     *            A message describing the exception
     * @param cause
     *            The underlying cause of the exception
     */
    public IncorrectAttributeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

}
