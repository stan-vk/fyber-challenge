package com.github.stanvk.fyberchallenge.ui.imdb;

import com.github.stanvk.fyberchallenge.ui.common.ButtonBase;
import com.github.stanvk.fyberchallenge.ui.enums.SortingOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 06.11.2016.
 */
public class TopRatesMoviesSortingOrderButton extends ButtonBase {
    TopRatesMoviesSortingOrderButton(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    public SortingOrder getSortingOrder() {
        String classValue = rootElement.getAttribute("class");
        if (classValue.contains("ascending")) {
            return SortingOrder.ASCENDING;
        }
        if (classValue.contains("descending")) {
            return SortingOrder.DESCENDING;
        }
        return SortingOrder.UNDEFINED;
    }

    public void applySortingOrder(SortingOrder sortingOrder) {
        if (SortingOrder.UNDEFINED.equals(sortingOrder)) {
            throw new IllegalArgumentException("Cannot apply UNDEFINED sorting order");
        }

        if (getSortingOrder().equals(sortingOrder)) {
            return;
        }

        leftMouseClick();
    }
}
