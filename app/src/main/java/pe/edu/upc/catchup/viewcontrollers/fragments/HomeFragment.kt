package pe.edu.upc.catchup.viewcontrollers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.fragment_home.view.*
import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Article
import pe.edu.upc.catchup.network.ArticlesResponse
import pe.edu.upc.catchup.network.NewsApi
import pe.edu.upc.catchup.viewcontrollers.adapters.ArticlesAdapter


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    var articles = ArrayList<Article>()
    lateinit var articlesRecyclerView: RecyclerView
    lateinit var articlesAdapter: ArticlesAdapter
    lateinit var articlesLayoutManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        articlesRecyclerView = view.articlesRecyclerView
        articlesAdapter = ArticlesAdapter(articles, view.context)
        articlesLayoutManager = GridLayoutManager(view.context, 2) as RecyclerView.LayoutManager
        articlesRecyclerView.adapter = articlesAdapter
        articlesRecyclerView.layoutManager = articlesLayoutManager

        NewsApi.requestHeadlines(getString(R.string.news_api_key),
                { response -> handleResponse(response)},
                { error -> handleError(error)})

        return view
    }

    private fun handleResponse(response: ArticlesResponse?) {
        val status = response!!.status
        if (status.equals("error", true)) {
            Log.d("CatchUp", response.message)
            return
        }

        articles = response.articles!!
        Log.d("CatchUp", "Found ${articles.size} articles")
        articlesAdapter.articles = articles
        articlesAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?) {
        Log.d("CatchUp", anError!!.message)
    }
}
