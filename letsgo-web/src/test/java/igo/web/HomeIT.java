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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author surzhin.konstantin
 */
public class HomeIT {

    private ChromeDriver driver;
   // WebDriver driver;

    /**
     *
     */
    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "D:\\distr\\selenium\\chromedriver.exe");
        ChromeDriverManager.getInstance().setup();
        //InternetExplorerDriverManager.getInstance().setup(); 
        //OperaDriverManager.getInstance().setup(); 
        driver = new ChromeDriver();
        driver.get("http://localhost:8084/");
    }

    /**
     *
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testTitle() throws Exception {
        System.out.println("Test title");
        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> d.getTitle().contains("IGO Server"));
    }

    @Test
    public void testH1() throws Exception {
        System.out.println("Test content");
        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> d.findElement(By.tagName("H1")).getText().contains("Let's go play go!"));
    }
}
