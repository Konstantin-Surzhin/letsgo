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
package igo.web;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author surzhin.konstantin
 */
public class AdminIT {

    private ChromeDriver driver;

    /**
     *
     */
    @Before
    public void setUp() {

        ChromeDriverManager.getInstance().setup();
        //InternetExplorerDriverManager.getInstance().setup(); 
        //OperaDriverManager.getInstance().setup(); 
        driver = new ChromeDriver();
        driver.get("http://localhost:8084/admin");
    }

    /**
     *
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginPage() throws Exception {
        System.out.println("Test Login Page");
        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> {
                    return d.getTitle().contains("Login Page")
                    && d.findElement(By.tagName("H1"))
                    .getText()
                    .contains("Login Page!");
                });
    }

    @Test
    public void testFailLogin() throws Exception {
        System.out.println("Test fail login");

        WebElement username = driver.findElement(By.name("j_username"));
        WebElement passwd = driver.findElement(By.name("j_password"));

        username.clear();
        passwd.clear();

        username.sendKeys("qqq");
        passwd.sendKeys("www");
        passwd.submit();

        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> {
                    return d.getTitle().contains("Login Error")
                    && d.findElement(By.tagName("H2"))
                    .getText()
                    .contains("Invalid user name or password.");
                });
    }
    @Test
    public void testSuccesLogin() throws Exception {
        System.out.println("Test succesed login");

        WebElement username = driver.findElement(By.name("j_username"));
        WebElement passwd = driver.findElement(By.name("j_password"));

        username.clear();
        passwd.clear();

        username.sendKeys("myfear");
        passwd.sendKeys("admin");
        passwd.submit();

        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> {
                    return d.getTitle().contains("Admin Page")
                    && d.findElement(By.tagName("H1"))
                    .getText()
                    .contains("Hello Admin!");
                });
    }
}
