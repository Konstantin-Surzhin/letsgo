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
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author surzhin.konstantin
 */
public class PageAction implements Consumer<Locale> {

    static {
        ChromeDriverManager.getInstance().setup();
        //InternetExplorerDriverManager.getInstance().setup(); 
        //OperaDriverManager.getInstance().setup(); 
    }
    private final String url;

    PageAction(String url) {
        if (url != null) {
            this.url = url;
        } else {
            this.url = "";
        }
    }

    @Override
    public void accept(Locale t) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + t);
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("http://localhost:8084/" + url);
        Locale.setDefault(t);
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/igo/i18n/"+url+"/Bundle");
        (new WebDriverWait(driver, 10)).until(
                (WebDriver d) -> {
                    return d.getTitle()
                    .contains(bundle.getString("title"))
                    && d.findElement(By.tagName("H1"))
                    .getText()
                    .contains(bundle.getString("welcome"));
                });
        driver.close();
    }
}
