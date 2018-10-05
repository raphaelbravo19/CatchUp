package pe.edu.upc.catchup.network

import pe.edu.upc.catchup.models.Article

class ArticlesResponse {
    var status: String = ""
    var code: String? = null
    var message: String? = null
    var totalResults: Int? = null
    var articles: ArrayList<Article>? = null
}
