package com.github.stanvk.fyberchallenge.services.context;

import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesPage;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public class TopRatedMoviesPageContext extends AbstractPageContext<TopRatedMoviesPage> {
    TopRatedMoviesPageContext(TopRatedMoviesPage page) {
        super(page);
    }

    @Override
    void confugure() {
        add("Top Rated Movies table", TopRatedMoviesPage::getTop250MovieTable);
    }
}
