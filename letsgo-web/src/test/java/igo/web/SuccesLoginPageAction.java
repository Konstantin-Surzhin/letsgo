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

import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author surzhin.konstantin
 */
public class SuccesLoginPageAction extends PageAction implements Consumer<Locale> {

    public SuccesLoginPageAction(WebDriver driver, String port, Map<String, String> messages, String url) {
        super(driver, port, messages, url);
    }

    @Override
    public void accept(Locale locale) {

        driver.get("http://localhost:" + PORT + "/" + url);

        WebElement username = driver.findElement(By.name("j_username"));
        WebElement passwd = driver.findElement(By.name("j_password"));

        username.clear();
        passwd.clear();

        username.sendKeys("myfear");
        passwd.sendKeys("admin");
        passwd.submit();

        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> {
                    return d.getTitle()
                    .equals(MESSAGES.get("title"))
                    && d.findElement(By.tagName("H1"))
                    .getText()
                    .equals(MESSAGES.get("welcome"));
                });
    }
}
