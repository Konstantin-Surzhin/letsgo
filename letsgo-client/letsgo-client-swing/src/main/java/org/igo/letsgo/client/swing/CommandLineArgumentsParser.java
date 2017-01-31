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

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author surzhin.konstantin
 */
class CommandLineArgumentsParser {

    private static final String ALLOWED_OPTIONS[] = {
        "analyze-commands:",
        "auto",
        "command:",
        "computer-black",
        "computer-both",
        "computer-none",
        "computer-white",
        "config:",
        "gtpfile:",
        "help",
        "komi:",
        "laf:",
        "move:",
        "program:",
        "register",
        "size:",
        "time:",
        "verbose",
        "version"
    };

    private static final Map<String, String> PARAMETERS = new HashMap();

    static boolean isOptionAvailable(final String verifiableOption) {
        return Arrays.stream(ALLOWED_OPTIONS)
                .map(a -> "--" + a)
                .anyMatch(allowedOption -> verifiableOption.contains(allowedOption));
    }

    static boolean isOptionNotAvailable(final String verifiableOption) {
        return Arrays.stream(ALLOWED_OPTIONS)
                .map(a -> "--" + a)
                .noneMatch(allowedOption -> verifiableOption.contains(allowedOption));
    }

    static void parse(String[] args) throws IllegalArgumentException {

        Arrays.stream(args).filter(a -> isOptionNotAvailable(a)).forEach(a -> printErrorToPrintStream(a, System.err));

        Arrays.stream(args).filter(a -> isOptionAvailable(a)).forEach(a -> addArgumentToSetting(a));
    }

    static boolean isThereRequestForHelp(final String[] args) {
        return Arrays.stream(args).anyMatch(a -> a.equalsIgnoreCase("--help"));
    }

    static void printHelpToPrintStream(final PrintStream ps) {
        ps.println("************************************");
        ps.println("* Specification of allowed options *");
        ps.println("************************************");
    }

    private static void printErrorToPrintStream(final String argument, final PrintStream out) {
        out.println(argument + ": is not allowed.");
    }

    private static void addArgumentToSetting(final String a) {
        if (a.contains(":")) {
            final String args[] = a.split(":");
            PARAMETERS.put(args[0], args[1]);
        } else {
            PARAMETERS.put(a, null);
        }
    }

}
