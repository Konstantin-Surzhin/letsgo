package org.igo.letsgo.bdd.thucydides.easyb.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

//@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary")
public class DictionaryPage extends PageObject {

//    @FindBy(name = "search")
//    private WebElementFacade searchTerms;
//
//    @FindBy(name = "go")
//    private WebElementFacade lookupButton;
    public void enter_keywords(String keyword) {
//        searchTerms.type(keyword);
    }

    public void lookup_terms() {
//        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
//        List<WebElement> results = definitionList.findElements(By.tagName("li"));
//        return convert(results, toStrings());
        return null;
    }

    private Converter<WebElement, String> toStrings() {
        return WebElement::getText;
    }
}
