package pe.edu.upc.catchup.network

import pe.edu.upc.catchup.models.Source

class SourcesResponse {
    var status: String = ""
    var code: String? = null
    var message: String? = null
    var sources: ArrayList<Source>? = null
}