package com.github.stanvk.fyberchallenge.services.context;

import com.github.stanvk.fyberchallenge.ui.common.AbstractPage;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesByWesternGenrePage;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
class TopRatedMoviesByWesternGenrePageContext extends AbstractPageContext<TopRatedMoviesByWesternGenrePage> {
    TopRatedMoviesByWesternGenrePageContext(TopRatedMoviesByWesternGenrePage contextPage) {
        super(contextPage);
    }

    @Override
    void confugure() {
        add("Top Rated Movies", TopRatedMoviesByWesternGenrePage::getTopMoviesList);
    }
}
