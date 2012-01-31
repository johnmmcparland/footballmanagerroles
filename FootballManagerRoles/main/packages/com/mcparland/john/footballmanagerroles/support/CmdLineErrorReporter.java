/**
 * 
 */
package com.mcparland.john.footballmanagerroles.support;

/**
 * Command line error reporter
 * 
 * @author John
 * 
 */
public class CmdLineErrorReporter implements ErrorReporter {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.support.ErrorReporter#report(
     * java.lang.String)
     */
    @Override
    public void report(String message) {
	System.err.println(message);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.mcparland.john.footballmanagerroles.support.ErrorReporter#report(
     * java.lang.String, java.lang.Throwable)
     */
    @Override
    public void report(String message, Throwable throwable) {
	System.err.println(message);
	throwable.printStackTrace();
    }

}
