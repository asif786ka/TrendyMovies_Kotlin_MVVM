package com.android.asif.llc.kotlin.trendymovies.android.adapter.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.asif.llc.kotlin.trendymovies.android.model.movie.MovieReview
import com.android.asif.llc.kotlin.trendymovies.databinding.MovieReviewItemBinding

class MovieReviewViewHolder(private val binding: MovieReviewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: MovieReview?,
        clickListener: ReviewClickListener
    ) {
        binding.review = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MovieReviewViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = MovieReviewItemBinding.inflate(inflater, parent, false)

            return MovieReviewViewHolder(
                binding
            )
        }
    }

}