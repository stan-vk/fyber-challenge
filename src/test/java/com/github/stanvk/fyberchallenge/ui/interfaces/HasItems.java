package com.github.stanvk.fyberchallenge.ui.interfaces;

import com.github.stanvk.fyberchallenge.ui.common.AbstractElement;

import java.util.List;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
public interface HasItems<T extends AbstractElement> {
    List<T> getItems();

    T getItemByText(String text);
}
