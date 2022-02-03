package com.example.yummyproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chootdev.recycleclick.RecycleClick
import com.example.yummyproject.databinding.FragmentArticlesListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ArticlesListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        val binding = FragmentArticlesListBinding.inflate(inflater, container, false)

        getArticles(binding.recyclerArtiles, binding.progressBar)
        return binding.root
    }

    companion object {
        var articlesList = arrayListOf<Result>()
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArticlesListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun getArticles(recyclerView: RecyclerView, progressBar: ProgressBar){
        progressBar.visibility=View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val call = RetrofitApiClient.createRetrofitAPI(resources.getString(R.string.base_url)).
        getArticles("all-sections", "7", resources.getString(R.string.api_key))
        call.enqueue(object : Callback<ResponseArticle> {
            override fun onResponse(call: Call<ResponseArticle>, response: Response<ResponseArticle>) {
                progressBar.visibility=View.GONE
                if (response.code() == 200) {
                    articlesList = response.body()?.results as ArrayList<Result>
                    val adapter = ArticlesAdapter(requireContext(), articlesList)
                    recyclerView.adapter = adapter
                    RecycleClick.addTo(recyclerView).setOnItemClickListener(RecycleClick.OnItemClickListener { recyclerView, i, view ->
                        val action = ArticlesListFragmentDirections.actionArticlesListFragmentToArticleDetailFragment(
                            articlesList[i].id!!)
                        findNavController().navigate(action)
                    })
                }
            }

            override fun onFailure(call: Call<ResponseArticle>, t: Throwable) {
                progressBar.visibility=View.GONE
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}