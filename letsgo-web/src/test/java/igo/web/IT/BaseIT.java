/*
 * Copyright (C) 2016 surzhin.konstantin
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
package igo.web.IT;

import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author surzhin.konstantin
 */
class BaseIT {

    final String PORT = "8080";
    private static final Architecture ARCH = Architecture.x32;
    private static final String CHROME_VERSION = "2.21";

    public BaseIT() {
        ChromeDriverManager.getInstance().setup(ARCH, CHROME_VERSION);
        InternetExplorerDriverManager.getInstance().setup(ARCH);
       // OperaDriverManager.getInstance().setup(ARCH);
    }
}
