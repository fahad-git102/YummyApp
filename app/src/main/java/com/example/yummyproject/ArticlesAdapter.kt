package com.example.yummyproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yummyproject.databinding.ArticlesListItemBinding

class ArticlesAdapter(var context: Context, var list: List<Result>) : RecyclerView.Adapter<ArticlesAdapter.MyHolder>() {

    class MyHolder(val binding: ArticlesListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : Result){
            binding.setVariable(BR.article, data)
            binding.imageUrl = data.media?.get(0)?.mediaMetadata?.get(data.media?.get(0)?.mediaMetadata!!.size-1)?.url
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding: ArticlesListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.articles_list_item, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView)
                .load(url).placeholder(R.drawable.default_image).fitCenter().into(imageView)
        }
    }

}