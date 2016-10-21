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
package igo.web.chrome.IT;

import static igo.web.IT.BaseInterface.PORT;
import igo.web.IT.FailLoginPageAction;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class ChromeFailLoginPageIT extends ChromeBase {

    @Parameterized.Parameter(value = 0)
    public Locale locale;

    @Parameterized.Parameter(value = 1)
    public Map<String, String> messages;

    @Parameterized.Parameter(value = 2)
    public WebDriver driver;

    @Parameterized.Parameters
    public static Collection localesedParam() {
        Map<String, String> m0 = new HashMap<>();
        m0.put("title", "Error page");
        m0.put("welcome", "Something went wrong!");
        m0.put("message", "Invalid user name or password.");
        m0.put("hint", "Please enter a user name or password that is authorized to access this application. Click here to Try Again");

        Map<String, String> m1 = new HashMap<>();
        m1.put("title", "Ошибка");
        m1.put("welcome", "Ошибочка вышла :-(");
        m1.put("message", "Неверное имя пользователя или пароль.");
        m1.put("hint", "Пожалуйста, введите имя и пароль пользователя, который имеет право доступа к этой странице. Для того чтобы повторить, щелкай по ссылке: Повторить");

        Locale locale0 = Locale.ENGLISH;
        Locale locale1 = new Locale("ru");

        Object[][] param = {{locale0, m0, getDiver(locale0)}, {locale1, m1, getDiver(locale1)}};

        return Arrays.asList(param);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testChromeFailLoginPage() throws Exception {
        System.out.println("Test Chrome fail Login Page: " + locale.getLanguage() + " : " + driver);
        new FailLoginPageAction(driver, PORT, messages, "admin").accept(locale);
        driver.quit();
    }

    public static WebDriver getDiver(Locale locale) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + locale.getLanguage());
        return new ChromeDriver(options);
    }

}
