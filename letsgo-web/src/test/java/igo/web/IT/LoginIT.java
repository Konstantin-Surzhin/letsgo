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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author surzhin.konstantin
 */
public class LoginIT extends BaseIT {

    InternetExplorerDriver driver;

    @Before
    public void setUp() {
        driver = new InternetExplorerDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
//    @Test
//    public void testChromeLoginPage() throws Exception {
//        System.out.println("Test Chrome Login Page");
//
//        locales.forEach(l
//                -> {
//            System.out.println("Test Chrome Login Page: " + l);
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--lang=" + l);
//            ChromeDriver driver = new ChromeDriver(options);
//            new PageAction(driver, PORT, "login").accept(l);
//        });
//    }
//    @Test
//    public void testOperaLoginPage() throws Exception {
//        System.out.println("Test Opera Login Page");
//
//        locales.forEach(l
//                -> {
//            System.out.println("Test Opera Login Page: " + l);
//            OperaOptions options = new OperaOptions();
//            options.addArguments("--lang=" + l);
//            OperaDriver driver = new OperaDriver(options);
//            new PageAction(driver, PORT, "login").accept(l);
//        });
//    }

    @Test
    public void testInternetExplorer_ROOT_LocaleLoginPage() throws Exception {
        System.out.println("Test InternetExplorer ROOT locale login Page");
        Locale l = Locale.ROOT;
        Map<String, String> messages = new HashMap<>();
        messages.put("title", "Login Page");
        messages.put("welcome", "Let's login!");

        new PageAction(driver, PORT, messages, "login").accept(l);
    }

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

//    @Test
//    public void testFailLogin() throws Exception {
//        System.out.println("Test fail login");
//
//        WebElement username = driver.findElement(By.name("j_username"));
//        WebElement passwd = driver.findElement(By.name("j_password"));
//
//        username.clear();
//        passwd.clear();
//
//        username.sendKeys("qqq");
//        passwd.sendKeys("www");
//        passwd.submit();
//
//        Locale l = Locale.ROOT;
//        Map<String, String> messages = new HashMap<>();
//        messages.put("title", "Login Error");
//        messages.put("welcome", "Something went wrong!");
//        messages.put("message", "Invalid user name or password.");
//        messages.put("hint", "Please enter a user name or password that is authorized to access this application. Click here to <a href=\"/login\">Try Again</a>");
//
//        new FailLoginPageAction(driver, PORT, messages, "login").accept(l);
//    }
//
//    @Test
//    public void testSuccesLogin() throws Exception {
//        System.out.println("Test succesed login");
//
//        WebElement username = driver.findElement(By.name("j_username"));
//        WebElement passwd = driver.findElement(By.name("j_password"));
//
//        username.clear();
//        passwd.clear();
//
//        username.sendKeys("myfear");
//        passwd.sendKeys("admin");
//        passwd.submit();
//
//        (new WebDriverWait(driver, 10)).until(
//                (WebDriver d) -> {
//                    return d.getTitle().contains("Admin Page")
//                    && d.findElement(By.tagName("H1"))
//                    .getText()
//                    .contains("Hello Admin!");
//                });
//    }
}
