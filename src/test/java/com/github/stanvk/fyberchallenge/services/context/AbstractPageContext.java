package com.github.stanvk.fyberchallenge.services.context;

import com.github.stanvk.fyberchallenge.ui.common.AbstractElement;
import com.github.stanvk.fyberchallenge.ui.common.AbstractPage;
import com.github.stanvk.fyberchallenge.ui.common.UiException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
@SuppressWarnings("unchecked")
abstract class AbstractPageContext<T extends AbstractPage> {
    private T page;

    private Map<String, Function<T, ? extends AbstractElement>> getterMap;

    AbstractPageContext(T page) {
        this.page = page;
        this.getterMap = new HashMap<>();
        confugure();
    }

    <R> R getChild(String childName, Class<R> type) {
        Function<T, ? extends AbstractElement> getter = getterMap.get(childName);
        if (Objects.isNull(getter)) {
            throw new UiException("Unknown child: " + childName);
        }

        AbstractElement element = getter.apply(page);
        if (type.isAssignableFrom(element.getClass())) {
            return (R) element;
        }

        throw new UiException(String.format("Found child '%s' does not implement %s", childName, type.getName()));
    }

    void add(String name, Function<T, ? extends AbstractElement> getter) {
        getterMap.put(name, getter);
    }

    abstract void confugure();
}
