package com.github.stanvk.fyberchallenge.services.context;

import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.ui.common.AbstractPage;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesByWesternGenrePage;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesPage;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
@Singleton
public class UiContextService {
    @Inject
    private WebDriverService webDriverService;

    private AbstractPage contextPage;

    private AbstractPageContext<? extends AbstractPage> pageContext;

    public AbstractPage getContextPage() {
        return contextPage;
    }

    public void setContextPage(AbstractPage contextPage) {
        this.contextPage = contextPage;
        if (contextPage instanceof TopRatedMoviesPage) {
            pageContext = new TopRatedMoviesPageContext((TopRatedMoviesPage) contextPage);
        }
        else if (contextPage instanceof TopRatedMoviesByWesternGenrePage) {
            pageContext = new TopRatedMoviesByWesternGenrePageContext((TopRatedMoviesByWesternGenrePage) contextPage);
        }
    }

    public <R> R getChild(String name, Class<R> type) {
        return pageContext.getChild(name, type);
    }
}
