package com.android.asif.llc.kotlin.trendymovies.android.adapter.trailer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.asif.llc.kotlin.trendymovies.android.model.tv.TvTrailer
import com.android.asif.llc.kotlin.trendymovies.databinding.SeriesTrailersItemBinding

class SeriesTrailerViewHolder(private val binding: SeriesTrailersItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TvTrailer?, clickListener: TrailerClickListener) {
        binding.trailer = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): SeriesTrailerViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = SeriesTrailersItemBinding.inflate(inflater, parent, false)

            return SeriesTrailerViewHolder(binding)
        }
    }

}