package pe.edu.upc.catchup.models

import android.os.Bundle

data class Article(
        val source: Source,
        val author: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String) {

    companion object {
        fun from(bundle: Bundle): Article {
            return Article(
                    Source.from(bundle.getBundle("source")!!),
                    bundle.getString("author")!!,
                    bundle.getString("title")!!,
                    bundle.getString("description")!!,
                    bundle.getString("url")!!,
                    bundle.getString("urlToImage")!!,
                    bundle.getString("publishedAt")!!)
        }
    }

    fun toBundle() : Bundle {
        val bundle = Bundle()
        bundle.putBundle("source", source.toBundle())
        bundle.putString("author", author)
        bundle.putString("title", title)
        bundle.putString("description", description)
        bundle.putString("url", url)
        bundle.putString("urlToImage", urlToImage)
        bundle.putString("publishedAt", publishedAt)
        return bundle
    }
}