/*
 * Copyright (C) 2017 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.letsgo.client.swing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author surzhin.konstantin
 */
public class CommandLineArgumentsParserTest {

    public CommandLineArgumentsParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class CommandLineArgumentsParser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        final String[] args = {"--help","--auto"};
        CommandLineArgumentsParser.parse(args);
        
    }

    /**
     * Test of isThereRequestForHelp method, of class
     * CommandLineArgumentsParser.
     */
    @Test
    public void testIsThereRequestForHelp() {
        System.out.println("isThereRequestForHelp");
        final String[] args = {"--help"};
        final boolean expResult = true;
        final boolean result = CommandLineArgumentsParser.isThereRequestForHelp(args);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotThereRequestForHelp() {
        System.out.println("isThereRequestForHelp");
        final String[] args = {"--auto"};
        final boolean expResult = false;
        final boolean result = CommandLineArgumentsParser.isThereRequestForHelp(args);
        assertEquals(expResult, result);
    }

    /**
     * Test of printHelpToPrintStream method, of class
     * CommandLineArgumentsParser.
     */
    @Test
    public void testPrintHelpToPrintStream() {
        try {
            System.out.println("printHelpToPrintStream");
            final ByteArrayOutputStream os = new ByteArrayOutputStream();
            final PrintStream ps = new PrintStream(os);
            CommandLineArgumentsParser.printHelpToPrintStream(ps);
            final String output = os.toString("UTF8");
            final boolean contains = output.contains("Specification of allowed options");
            assertTrue(contains);

        } catch (UnsupportedEncodingException ex) {
            fail("UnsupportedEncodingException");
            Logger.getLogger(CommandLineArgumentsParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of isOptionAvailable method, of class CommandLineArgumentsParser.
     */
    @Test
    public void testIsOptionAvailable() {
        System.out.println("isOptionAvailable");
        final String verifiableOption = "--computer-both";
        final boolean expResult = true;
        final boolean result = CommandLineArgumentsParser.isOptionAvailable(verifiableOption);
        assertEquals(expResult, result);
    }

    /**
     * Test of isOptionNotAvailable method, of class CommandLineArgumentsParser.
     */
    @Test
    public void testIsOptionNotAvailable() {
        System.out.println("isOptionNotAvailable");
        final String verifiableOption = "--stupid";
        final boolean expResult = true;
        final boolean result = CommandLineArgumentsParser.isOptionNotAvailable(verifiableOption);
        assertEquals(expResult, result);
    }
}
