package com.android.asif.llc.kotlin.trendymovies.android.adapter.cast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.asif.llc.kotlin.trendymovies.android.model.tv.TvCast
import com.android.asif.llc.kotlin.trendymovies.databinding.SeriesCastItemBinding

class SeriesCastViewHolder(private val binding: SeriesCastItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: TvCast,
        clickListener: CastClickListener
    ) {
        binding.cast = item
        binding.clicklistener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): SeriesCastViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = SeriesCastItemBinding.inflate(inflater, parent, false)
            return SeriesCastViewHolder(binding)
        }
    }

}