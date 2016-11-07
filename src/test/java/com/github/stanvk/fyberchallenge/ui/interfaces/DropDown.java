package com.github.stanvk.fyberchallenge.ui.interfaces;

import com.github.stanvk.fyberchallenge.ui.common.Option;

import java.util.List;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
public interface DropDown extends Visible, Clickable, Expandable {
    List<Option> getItems();

    Option getSelectedItem();

    Option getItemByText(String text);

    void selectItemWithKeyboard(String text);
}
