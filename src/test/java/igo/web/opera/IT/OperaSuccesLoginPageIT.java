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
package igo.web.opera.IT;

import static igo.web.IT.BaseInterface.PORT;
import igo.web.IT.SuccesLoginPageAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class OperaSuccesLoginPageIT extends OperaBase {

    /**
     *
     */
    @Parameterized.Parameter(value = 0)
    public Locale locale;

    /**
     *
     */
    @Parameterized.Parameter(value = 1)
    public Map<String, String> messages;

    /**
     *
     */
    @Parameterized.Parameter(value = 2)
    public WebDriver driver;

    /**
     *
     * @return
     */
    @Parameterized.Parameters
    public static Collection localesedParam() {
        Map<String, String> m0 = new HashMap<>();
        m0.put("title", "Admin Page");
        m0.put("welcome", "Hello Admin!");

        Map<String, String> m1 = new HashMap<>();
        m1.put("title", "Уголок администратора.");
        m1.put("welcome", "Привет, админ!");

        Locale locale0 = Locale.ENGLISH;
        Locale locale1 = new Locale("ru");

        Object[][] param = {{locale0, m0, getDiver(locale0)}, {locale1, m1, getDiver(locale1)}};

        return Arrays.asList(param);
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
    public void testChromeSuccesLoginPage() throws Exception {
        System.out.println("Test Chrome succes Login Page: " + locale.getLanguage() + " : " + driver);
        new SuccesLoginPageAction(driver, PORT, messages, "admin").accept(locale);
    }

    /**
     *
     * @param locale
     * @return
     */
    public static WebDriver getDiver(Locale locale) {
        OperaOptions options = new OperaOptions();
        options.addArguments("--lang=" + locale.getLanguage());
        return new OperaDriver(options);
    }
}
