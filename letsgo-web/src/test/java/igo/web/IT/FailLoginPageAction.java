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

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import java.util.Locale;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author surzhin.konstantin
 */
class FailLoginPageAction {

    static {
        // ChromeDriverManager.getInstance().setup(Architecture.x32, "2.21");
        InternetExplorerDriverManager.getInstance().setup();
        //  OperaDriverManager.getInstance().setup();
    }
    private final String url;
    private final WebDriver driver;
    private final String PORT;
    private final Map<String, String> MESSAGES;

    FailLoginPageAction(WebDriver driver, String port, Map<String, String> messages, String url) {
        if (url != null) {
            this.url = url;
        } else {
            this.url = "";
        }
        this.driver = driver;
        this.PORT = port;
        this.MESSAGES = messages;
    }


    void accept(Locale l) {
        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> {
                    return d.getTitle().contains("Login Error")
                    && d.findElement(By.tagName("H2"))
                    .getText()
                    .contains("Invalid user name or password.");
                });
    }

}
