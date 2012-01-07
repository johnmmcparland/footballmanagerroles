/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.exceptions;

/**
 * Exception indicating that an attribute has already been added to some
 * collection
 * <p>
 * (c) John McParland
 * </p>
 * <p>
 * You may enhance this code and re-submit to the depot. But you may not sell it
 * or use it for profit!
 * </p>
 * 
 * @author John McParland (john.mcparland@gmail.com)
 * 
 */
public class AttributeAlreadyAddedException extends RuntimeException {

    /**
     * @see {@link java.io.Serializable}
     */
    private static final long serialVersionUID = -9181676564642825878L;

    /**
     * Create an exception to indicate an attribute was already added
     */
    public AttributeAlreadyAddedException() {
        super();
    }

    /**
     * Create an exception to indicate an attribute was already added
     * 
     * @param message
     *            A message describing the exception
     */
    public AttributeAlreadyAddedException(String message) {
        super(message);
    }

    /**
     * Create an exception to indicate an attribute was already added
     * 
     * @param cause
     *            The underlying cause of the exception
     */
    public AttributeAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    /**
     * Create an exception to indicate an attribute was already added
     * 
     * @param message
     *            A message describing the exception
     * @param cause
     *            The underlying cause of the exception
     */
    public AttributeAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

}
