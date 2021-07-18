package com.android.asif.llc.kotlin.trendymovies.android.adapter.trailer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.asif.llc.kotlin.trendymovies.android.model.movie.MovieTrailer
import com.android.asif.llc.kotlin.trendymovies.databinding.MovieTrailersItemBinding

class MovieTrailerViewHolder(private val binding: MovieTrailersItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: MovieTrailer?,
        clickListener: TrailerClickListener
    ) {
        binding.trailer = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MovieTrailerViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = MovieTrailersItemBinding.inflate(inflater, parent, false)

            return MovieTrailerViewHolder(
                binding
            )
        }
    }

}