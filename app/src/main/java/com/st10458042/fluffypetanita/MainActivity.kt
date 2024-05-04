package com.st10458042.fluffypetanita

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {
    private lateinit var gifImageView: GifImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val enter_button = findViewById<ImageButton>(R.id.EnterButton)
        enter_button.setOnClickListener {
            val intent = Intent(this, Page_2_Interaction_with_anita::class.java)
            startActivity(intent)
        }

        gifImageView = findViewById(R.id.gif_rocket)
        startSlideAnimation()
    }

    private fun startSlideAnimation() {
        val screenWidth = resources.displayMetrics.widthPixels
        val animatorSet = AnimatorSet().apply {
            playSequentially(
                ObjectAnimator.ofFloat(gifImageView, "translationX", -screenWidth.toFloat(), 720f),
                ObjectAnimator.ofFloat(gifImageView, "translationX", -screenWidth.toFloat(), 720f)
            )
            duration = 4000
            interpolator = LinearInterpolator()
            addListener(object : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    animation.start()
                }
            })

        }//This enables the background animation
        animatorSet.start()
    }
}