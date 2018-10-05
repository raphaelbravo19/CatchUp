package pe.edu.upc.catchup.models

import com.orm.SugarRecord

public class Bookmark : SugarRecord() {
    var sourceId: String = ""
    var sourceName: String = ""

    companion object {
        fun sourceIdsAsString(): String {
            val bookmarks = SugarRecord.listAll(Bookmark::class.java)
            return bookmarks.joinToString { bookmark -> bookmark.sourceId }
        }

        fun sourceNamesAsString(): String {
            val bookmarks = SugarRecord.listAll(Bookmark::class.java)
            return bookmarks.joinToString { bookmark -> bookmark.sourceName }
        }
    }
}