package com.example.articles.articles.presentation.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.articles.R
import com.example.articles.articles.data.models.Article
import com.example.articles.articles.presentation.ui.adapters.ArticlesRecyclerAdapter
import com.example.articles.articles.presentation.viewmodel.ArticlesViewModel
import com.example.articles.articles.presentation.viewmodel.ViewModelFactory
import com.example.articles.common.Status
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.articles_details_content.*
import kotlinx.android.synthetic.main.collapsing_toolbar.*
import kotlinx.android.synthetic.main.tool_bar.*
import javax.inject.Inject


class ArticleDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    private lateinit var articlesViewModel: ArticlesViewModel

    private val args: ArticleDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenStarted {

            setupToolbar()
            articlesViewModel =
                ViewModelProviders.of(activity!!, viewModelFactory).get(ArticlesViewModel::class.java)

            articlesViewModel.loadSingleArticle(args.articleId)

            articlesViewModel.singleArticleResult.observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Status.SUCCESS -> setData(it.data)
                    Status.ERROR -> Log.d("error", it.message)
                }
            })

        }

    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

    }

    private fun setData(article: Article?) {
        if (article != null) {
            image.setImageURI(article.media[0].mediaMetadata[4].url)
            title.text = article.title
            createdBy.text = article.byline
            source.text = article.source
        }
    }


}
