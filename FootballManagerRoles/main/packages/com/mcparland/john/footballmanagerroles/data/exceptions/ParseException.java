/**
 * 
 */
package com.mcparland.john.footballmanagerroles.data.exceptions;

/**
 * A problem parsing an input file
 * 
 * @author John
 * 
 */
public class ParseException extends Exception {

    /**
     * @see {@link java.io.Serializable}
     */
    private static final long serialVersionUID = -6772990715251556883L;

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     */
    public ParseException() {
	super();
    }

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     * 
     * @param message
     *            A message describing the error
     */
    public ParseException(String message) {
	super(message);
    }

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     * 
     * @param cause
     *            The underlying cause of the exception
     */
    public ParseException(Throwable cause) {
	super(cause);
    }

    /**
     * Create an exception indicating that there was a problem parsing an input
     * file
     * 
     * @param message
     *            A message describing the error
     * @param cause
     *            The underlying cause of the exception
     */
    public ParseException(String message, Throwable cause) {
	super(message, cause);
    }

}
