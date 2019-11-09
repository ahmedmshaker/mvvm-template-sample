package com.example.articles.articles.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.articles.R
import com.example.articles.articles.data.models.Article
import kotlinx.android.synthetic.main.article_recycler_item.view.*
import kotlinx.android.synthetic.main.date_row.view.*
import javax.inject.Inject

class ArticlesRecyclerAdapter @Inject constructor() :
    RecyclerView.Adapter<ArticlesRecyclerAdapter.ArticleViewHolder>() {

    private val articles: MutableList<Article> = ArrayList()
    private var function: ((Article) -> Unit)? = null


    fun populateArticles(articlesList: List<Article>) {
        articles.clear()
        articles.addAll(articlesList)
        notifyDataSetChanged()
    }

    fun addClickListener(function: (Article) -> Unit) {
        this.function = function
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArticleViewHolder(
            inflater.inflate(R.layout.article_recycler_item, parent, false)
        )
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) = holder.bind(articles[position])


    inner class ArticleViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(article: Article) {
            with(itemView) {
                tvTitle.text = article.title
                tvCreatedBy.text = article.byline
                tvSource.text = article.source
                tvDate.text = article.published_date
                imgArticle.setImageURI(article.media[0].mediaMetadata[2].url)

                setOnClickListener {
                    function?.let { function ->
                        function(article)
                    }
                }
            }
        }

    }
}