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

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author surzhin.konstantin
 */
class LetsGoClientSettings {

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

    static void commandLinArgumentParse(String[] args) {
        boolean stopParse = false;
        int n = 0;
        while (n < args.length) {
//            String s = args[n];
//            ++n;
//            if (s.equals("--")) {
//                stopParse = true;
//                continue;
//            }
//            if (isOptionKey(s) && !stopParse) {
//                String spec = getSpec(s.substring(1));
//                if (needsValue(spec)) {
//                    if (n >= args.length) {
//                        throw new ErrorMessage("Option " + s
//                                + " needs value");
//                    }
//                    String value = args[n];
//                    ++n;
//                    m_map.put(spec, value);
//                } else {
//                    m_map.put(spec, "1");
//                }
//
//            } else {
//                m_args.add(s);
//            }
//        }
        }
    }

    static boolean isThereRequestForHelp(final String[] args) {
         return Arrays.stream(args).anyMatch(a -> a.equalsIgnoreCase("--help"));
    }

    static void printHelpToSystemOut() {
        System.out.println("************************************");
        System.out.println("* Specification of allowed options *");
        System.out.println("************************************");
    }

}
