package com.github.stanvk.fyberchallenge.services.context;

import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesPage;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
class TopRatedMoviesPageContext extends AbstractPageContext<TopRatedMoviesPage> {
    TopRatedMoviesPageContext(TopRatedMoviesPage page) {
        super(page);
    }

    @Override
    void confugure() {
        add("Top Rated Movies", TopRatedMoviesPage::getTop250MovieTable);
        add("Top Rated Movies sorting control", TopRatedMoviesPage::getMovieTableSortingControl);
        add("Top Rated Movies sorting dropdown", p -> p.getMovieTableSortingControl().getDropDown());
        add("Top Rated Movies sorting order button", p -> p.getMovieTableSortingControl().getSortingOrderButton());
        add("Top Rated Movies by Genre list", TopRatedMoviesPage::getMoviesByGenreList);
    }
}
