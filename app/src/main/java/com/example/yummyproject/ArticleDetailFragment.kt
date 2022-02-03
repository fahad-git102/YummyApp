package com.example.yummyproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.yummyproject.databinding.FragmentArticleDetailBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class ArticleDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var article : Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentArticleDetailBinding.inflate(inflater, container, false)
        val arguments: ArticleDetailFragmentArgs by navArgs()
        val articleId = arguments.articleId
        for (item in ArticlesListFragment.articlesList){
            if (item.id == articleId){
                article = item
            }
        }
        var keywords = article?.adxKeywords?.replace(";", ", ");
        binding.article = article
        binding.media = article?.media!![0]
        binding.keywords = keywords
        binding.section = "Section:   "+article?.subsection + ", " +  article?.section
        binding.imageUrl = article?.media?.get(0)?.mediaMetadata?.get(article?.media?.get(0)?.mediaMetadata!!.size-1)?.url
        binding.executePendingBindings()
        return binding.root
    }

    companion object {

        @JvmStatic
        @BindingAdapter("loadThisImage")
        fun loadThisImage(imageView: ImageView, imageUrl: String){
            Glide.with(imageView)
                .load(imageUrl).placeholder(R.drawable.default_image).fitCenter().into(imageView)
        }

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArticleDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}