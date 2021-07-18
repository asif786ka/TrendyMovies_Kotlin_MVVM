package com.android.asif.llc.kotlin.trendymovies.android.ui.movies

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.asif.llc.kotlin.trendymovies.android.data.Repository
import com.android.asif.llc.kotlin.trendymovies.android.model.movie.Movie
import com.android.asif.llc.kotlin.trendymovies.android.utils.DEFAULT_CATEGORY
import com.android.asif.llc.kotlin.trendymovies.android.utils.DEFAULT_LANGUAGE
import com.android.asif.llc.kotlin.trendymovies.android.utils.LANGUAGE_KEY
import com.android.asif.llc.kotlin.trendymovies.android.utils.MOVIE_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: Repository,
    preference: SharedPreferences
) :
    ViewModel() {

    private val language = preference.getString(LANGUAGE_KEY, DEFAULT_LANGUAGE)!!
    private val category = preference.getString(MOVIE_KEY, DEFAULT_CATEGORY)!!

    // In Memory Caching
    private var currentCategory: String? = null
    private var currentQuery: String? = null
    private var currentSearchresult: Flow<PagingData<Movie>>? = null
    private var currentQueryResult: Flow<PagingData<Movie>>? = null

    fun getMoviesList(): Flow<PagingData<Movie>> {
        val lastResult = currentSearchresult
        if (category == currentCategory &&
            lastResult != null
        ) {
            return lastResult
        }

        currentCategory = category
        val newResult = repository.getMovieResultStream(category, language)
            .cachedIn(viewModelScope)
        currentSearchresult = newResult

        return newResult

    }

    fun queryMovieList(query: String): Flow<PagingData<Movie>> {
        val lastResult = currentQueryResult
        if (query == currentQuery &&
            lastResult != null
        ) {
            return lastResult
        }

        currentQuery = query
        val newResult = repository.getMovieQueryStream(query)
            .cachedIn(viewModelScope)
        currentQueryResult = newResult

        return newResult

    }


}