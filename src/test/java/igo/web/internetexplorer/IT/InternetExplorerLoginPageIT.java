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
package igo.web.internetexplorer.IT;

import igo.web.IT.PageAction;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author surzhin.konstantin
 */
public class InternetExplorerLoginPageIT extends InternetExplorerBase {

    /**
     *
     */
    public WebDriver driver;

    /**
     *
     */
    @Before
    public void setUp() {
        driver = new InternetExplorerDriver();
    }

    /**
     *
     */
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testInternetExplorer_ROOT_LocaleLoginPage() throws Exception {
        System.out.println("Test InternetExplorer ROOT locale login Page");
        Locale l = Locale.ENGLISH;
        Map<String, String> messages = new HashMap<>();
        messages.put("title", "Login Page");
        messages.put("welcome", "Let's login!");

        new PageAction(driver, PORT, messages, "login").accept(l);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testInternetExplorer_ru_RU_LocaleLoginPage() throws Exception {
        System.out.println("Test InternetExplorer ru_RU locale login Page");
        Locale l = new Locale("ru", "RU");

        Locale.setDefault(l);
        Map<String, String> messages = new HashMap<>();
        messages.put("title", "Страница авторизации");
        messages.put("welcome", "Давай авторизуйся!");

        new PageAction(driver, PORT, messages, "login").accept(l);
    }
}
