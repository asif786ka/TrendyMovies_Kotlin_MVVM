package com.android.asif.llc.kotlin.trendymovies.android.adapter.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.asif.llc.kotlin.trendymovies.android.model.movie.Movie
import com.android.asif.llc.kotlin.trendymovies.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Movie?, clickListener: MovieClickListener) {
        binding.movie = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MovieViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = MovieItemBinding.inflate(inflater, parent, false)
            return MovieViewHolder(
                binding
            )
        }
    }

}