package com.github.stanvk.fyberchallenge.ui.imdb;

import com.github.stanvk.fyberchallenge.ui.common.AbstractElement;
import com.github.stanvk.fyberchallenge.ui.common.DropDownSelect;
import com.github.stanvk.fyberchallenge.ui.common.UiException;
import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Optional;

/**
 * Created by Stanislav Kostsov on 06.11.2016.
 */
public class TopRatesMoviesSortingControl extends AbstractElement implements Visible {
    private static final String SELECT_XPATH = ".//select[@class='lister-sort-by']";
    private static final String SORTING_ORDER_ELEMENT_CLASS = "lister-sort-reverse";

    @FindBy(xpath = SELECT_XPATH)
    private WebElement selectElement;

    @FindBy(className = SORTING_ORDER_ELEMENT_CLASS)
    private WebElement sortingOrderElement;

    TopRatesMoviesSortingControl(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
        PageFactory.initElements(webDriver, this);
    }

    public DropDownSelect getDropDown() {
        return Optional.ofNullable(selectElement)
                .map(e -> new DropDownSelect(webDriver, e))
                .orElseThrow(() -> new UiException("Root element was not found by selector: " + SELECT_XPATH));
    }

    public TopRatesMoviesSortingOrderButton getSortingOrderButton() {
        return Optional.ofNullable(sortingOrderElement)
                .map(e -> new TopRatesMoviesSortingOrderButton(webDriver, e))
                .orElseThrow(() -> new UiException("Root element was not found by selector: " + SORTING_ORDER_ELEMENT_CLASS));
    }
}
