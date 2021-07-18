package com.android.asif.llc.kotlin.trendymovies.android.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.asif.llc.kotlin.trendymovies.android.model.tv.TvSeries
import com.android.asif.llc.kotlin.trendymovies.android.network.ApiService
import com.android.asif.llc.kotlin.trendymovies.android.utils.SECRET_KEY
import com.android.asif.llc.kotlin.trendymovies.android.utils.SERIES_LIST_STARTING_PAGE
import retrofit2.HttpException
import java.io.IOException

class TvSeriesQueryPagingSource(
    private val query: String,
    private val service: ApiService
) : PagingSource<Int, TvSeries>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvSeries> {
        val page = params.key ?: SERIES_LIST_STARTING_PAGE
        return try {
            val response = service.querySeries(query, SECRET_KEY, page)

            val series = response.results
            LoadResult.Page(
                data = series,
                prevKey = if (page == SERIES_LIST_STARTING_PAGE) null else page - 1,
                nextKey = if (series.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TvSeries>): Int? {
        return state.anchorPosition
    }

}