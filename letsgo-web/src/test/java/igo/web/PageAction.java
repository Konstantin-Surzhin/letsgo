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
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author surzhin.konstantin
 */
public class PageAction implements Consumer<Locale> {

    protected final String url;
    protected final WebDriver driver;
    protected final String PORT;
    protected final Map<String, String> MESSAGES;

    public PageAction(WebDriver driver, String port, Map<String, String> messages, String url) {
        if (url != null) {
            this.url = url;
        } else {
            this.url = "";
        }
        this.driver = driver;
        this.PORT = port;
        this.MESSAGES = messages;
    }

    @Override
    public void accept(Locale locale) {

        driver.get("http://localhost:" + PORT + "/" + url);

        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> {
                    return d.getTitle()
                    .contains(MESSAGES.get("title"))
                    && d.findElement(By.tagName("H1"))
                    .getText()
                    .contains(MESSAGES.get("welcome"));
                });
    }
}
