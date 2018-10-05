package pe.edu.upc.catchup.network

import java.net.URL

class LogoApi {
    companion object {
        val baseUrl = "https://logo.clearbit.com/"

        fun urlToLogo(url: String): String {
            val host = URL(url).host
            return "$baseUrl$host"
        }
    }
}