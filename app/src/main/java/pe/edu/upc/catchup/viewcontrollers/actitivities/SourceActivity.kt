package pe.edu.upc.catchup.viewcontrollers.actitivities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import pe.edu.upc.catchup.R

import kotlinx.android.synthetic.main.activity_source.*
import kotlinx.android.synthetic.main.content_source.*
import pe.edu.upc.catchup.models.Source

class SourceActivity : AppCompatActivity() {
    var isBookmarked: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = intent ?: return
        val source = Source.from(intent.extras)
        logoImageView.setDefaultImageResId(R.mipmap.ic_launcher)
        logoImageView.setErrorImageResId(R.mipmap.ic_launcher)
        logoImageView.setImageUrl(source.urlToLogo())
        nameTextView.text = source.name
        isBookmarked = source.isBookmarked()
        updateBookmarkImage()

        bookmarkImageButton.setOnClickListener { view ->
            isBookmarked = !isBookmarked
            source.setBookmarked(isBookmarked)
            updateBookmarkImage()
        }
    }

    fun updateBookmarkImage() {
        bookmarkImageButton.setImageResource(
                if (this.isBookmarked) {
                    R.drawable.ic_bookmark_black_24dp
                } else {
                    R.drawable.ic_bookmark_border_black_24dp
                })
    }
}
