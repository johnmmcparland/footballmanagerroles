/**
 * 
 */
package com.mcparland.john.footballmanagerroles.support;

/**
 * An interface specifying how errors may be fed back to the end user
 * 
 * @author John
 * 
 */
public interface ErrorReporter {

    /**
     * Report an error
     * 
     * @param message
     *            A message describing the error
     */
    public void report(String message);

    /**
     * Report and error
     * 
     * @param message
     *            A message describing the error
     * @param throwable
     *            A Throwable which is the root cause of the error
     */
    public void report(String message, Throwable throwable);

}
