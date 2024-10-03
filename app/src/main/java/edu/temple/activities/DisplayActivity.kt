package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

const val RETURN_KEY = "return"
class DisplayActivity : AppCompatActivity() {

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
        //When we receive our results, get the data from the result and set the text size.
        if(it.resultCode == RESULT_OK)
        {
            it.data?.apply {
                lyricsDisplayTextView.textSize = getIntExtra(RETURN_KEY, 0).toFloat()
            }
        }
    }
    // TODO Step 3: Use returned value for lyricsDisplayTextView text size



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener{
            val intent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
            launcher.launch(intent)
        }

    }
}