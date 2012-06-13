/**
 * 
 */
package tests.com.mcparland.john.footballmanagerroles.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcparland.john.footballmanagerroles.input.CmdLineInput;

/**
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml", "classpath:/tests/com/mcparland/john/footballmanagerroles/config/test_datasource.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class CmdLineInputTest {

    /**
     * The CmdLineInput
     */
    private CmdLineInput input = null;

    /**
     * Get the input object being tested
     * 
     * @return The input object being tested
     */
    public CmdLineInput getInput() {
        return input;
    }

    /**
     * Set the input object being tested
     * 
     * @param input
     *            The input object being tested
     */
    @Autowired
    public void setCmdLineInput(CmdLineInput input) {
        this.input = input;
    }

    /**
     * Test method for
     * {@link com.mcparland.john.footballmanagerroles.input.CmdLineInput#setInputFromUser(java.lang.String[])}
     * .
     */
    @Test
    public void testSetInputFromUser() {
        // Not enough args
        String[] args = new String[0];
        assertFalse(input.setInputFromUser(args));

        // File
        args = new String[1];
        args[0] = "testFiles/5. Daniel Majstorovic.rtf";
        assertTrue(input.setInputFromUser(args));

        // Invalid file
        args[0] = "testFiles/I_am_a_made_up_file_" + System.currentTimeMillis();
        assertFalse(input.setInputFromUser(args));
    }

}
