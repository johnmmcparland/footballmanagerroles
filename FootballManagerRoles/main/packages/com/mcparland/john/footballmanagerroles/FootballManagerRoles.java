/**
 * 
 */
package com.mcparland.john.footballmanagerroles;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mcparland.john.footballmanagerroles.data.access.AttributesService;
import com.mcparland.john.footballmanagerroles.data.attributes.Attributes;
import com.mcparland.john.footballmanagerroles.data.exceptions.ParseException;
import com.mcparland.john.footballmanagerroles.data.people.Person;
import com.mcparland.john.footballmanagerroles.input.Input;
import com.mcparland.john.footballmanagerroles.parser.Parser;
import com.mcparland.john.footballmanagerroles.support.ErrorReporter;

/**
 * Main program
 * 
 * @author John
 * 
 */
public class FootballManagerRoles {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(FootballManagerRoles.class);

    /**
     * Main method
     * 
     * @param args
     *            Program arguments
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "com/mcparland/john/footballmanagerroles/config/footballmanagerroles.xml");
        context.registerShutdownHook();

        // Ensure we can report errors
        ErrorReporter errorReporter = (ErrorReporter) context.getBean("errorReporter");

        // Initialize the data objects
        AttributesService attrsService = (AttributesService) context.getBean("attributesService");
        Attributes attributes = attrsService.getAttributes();
        LOGGER.info("Got attributes");
        LOGGER.debug(attributes.toString());

        // Deal with the input
        Input input = (Input) context.getBean("input");
        if (!input.setInputFromUser(args)) {
            errorReporter.report("Could not set the input file - check it exists and is readable");
        } else {
            // Parse
            @SuppressWarnings("unchecked")
            Parser<Person> parser = (Parser<Person>) context.getBean("parser");
            parser.setAttributes(attributes);
            try {
                Person person = parser.parse(input.getInputFile());
                LOGGER.info("Got Person\n" + person.toString());

                // Calculate
                // Calculator calculator = (Calculator)
                // context.getBean("calculator");
                // List<Roles> roles = calculator.calculateRoles(person);

                // Recommend
                // Recommender recommender = (Recommender)
                // context.getBean("recommender");
                // recommender.recommend(roles);

            } catch (ParseException pe) {
                errorReporter.report("Couldn't parse the input file" + input.getInputFile(), pe);
            }
        }
    }
}
