package com.example.savedstatechanges

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.view.isVisible

lateinit var changeButton: Button
lateinit var imageDoom: ImageView
lateinit var mainText: TextView
lateinit var ratingBar: RatingBar
lateinit var progressBar: ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeButton = findViewById<Button>(R.id.btnChange)
        imageDoom = findViewById<ImageView>(R.id.imgDoom)
        mainText = findViewById<TextView>(R.id.textMain)
        ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)

        changeButton.setOnClickListener{
            imageDoom.setVisibility(View.VISIBLE)
            mainText.setText(R.string.txtTextChanged)
            ratingBar.setRating(8.0f)
            progressBar.setProgress(100)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("imageVisibility", imageDoom.getVisibility())
        outState.putString("textMain", mainText.text.toString())
        outState.putFloat("ratingBar", ratingBar.getRating())
        outState.putInt("progressBar", progressBar.getProgress())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        imageDoom.setVisibility(savedInstanceState.getInt("imageVisibility"))
        mainText.setText(savedInstanceState.getString("textMain"))
        ratingBar.setRating(savedInstanceState.getFloat("ratingBar"))
        progressBar.setProgress(savedInstanceState.getInt("progressBar"))
    }
}