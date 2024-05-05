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
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import pl.droidsonroids.gif.GifImageButton
import pl.droidsonroids.gif.GifImageView

class Page_2_Interaction_with_anita : AppCompatActivity() {
    //Private Declarations
    private lateinit var gifImageView: GifImageView

    private lateinit var hungerprogressBar: ProgressBar //android studio progress bar is declared
    private var hungerLevel = 100f //this is 100%
    private val HungerDecreaseRate = 5f //this will deplete in increments of 5
//The same process is done for the rest
    private  lateinit var cleanprogressBar: ProgressBar
    private var cleanLevel = 100f
    private val CleanDecreaseRate = 5f
    //https://developer.android.com/kotlin/coroutines

    private lateinit var happyProgressBar: ProgressBar
    private var happyLevel = 100f
    private val HappyDecreaseRate = 5f


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2_interaction_with_anita)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //the back button is used in case a users device does not have a back button
        val back_button = findViewById<ImageButton>(R.id.Back_Button)
        back_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //Animation
        gifImageView = findViewById(R.id.gif_rocket)
        startSlideAnimation()
        //Declarations for the buttons used
        val feed_button = findViewById<ImageButton>(R.id.feed_button)
        val bath_button = findViewById<ImageButton>(R.id.bath_button)
        val play_button = findViewById<ImageButton>(R.id.play_button)
        val sleep_button = findViewById<GifImageButton>(R.id.sleep_button)

        //Declarations used for th Image Views
        //Android Developers. (n.d.). ImageView. Retrieved from https://developer.android.com/reference/android/widget/ImageView

        val pet_action_image = findViewById<ImageView>(R.id.pet_action_view)
        val gif_action_image = findViewById<ImageView>(R.id.gif_pet_views)
        val action_text = findViewById<ImageView>(R.id.action_text)

        //The progress bar is declared and the progress is set to the level that is matched
        //https://developer.android.com/kotlin/coroutines
        hungerprogressBar = findViewById(R.id.hunger_progress)
        hungerprogressBar.progress = hungerLevel.toInt()
        val hungerCoroutine = launchHungerCoroutine() //This launches a coroutine that will update the progress bar every second

        cleanprogressBar = findViewById(R.id.clean_progress)
        cleanprogressBar.progress = cleanLevel.toInt()
        val cleanCoroutine = launchcleanCoroutine()

        happyProgressBar = findViewById(R.id.happy_progress)
        happyProgressBar.progress = happyLevel.toInt()
        val happyCoroutine = launchhappyCoroutine()

        //Functions for the sleep button
        sleep_button.setOnClickListener {
            pet_action_image.setImageResource(R.drawable.anita_sleeping)
            gif_action_image.setImageResource(R.drawable.anitagif_sleeping)
            action_text.setImageResource(R.drawable.sleeping_text)
        }

        //Functions for the feed button
        //Android Developers. (n.d.). Button. Retrieved from https://developer.android.com/develop/ui/views/components/button
        feed_button.setOnClickListener {
            pet_action_image.setImageResource(R.drawable.anita_eating)
            gif_action_image.setImageResource(R.drawable.hamburger)
            action_text.setImageResource(R.drawable.eating_text)
            hungerLevel = 100f  // Reset hunger level to full
            hungerprogressBar.progress = hungerLevel.toInt()
            updateHungerProgressBarColor(hungerLevel)
        }
        //Functions for the bath button
        //Android Developers. (n.d.). Button. Retrieved from https://developer.android.com/develop/ui/views/components/button
        bath_button.setOnClickListener {
            pet_action_image.setImageResource(R.drawable.anita_bathing)
            gif_action_image.setImageResource(R.drawable.water)
            action_text.setImageResource(R.drawable.bathing_text)
            cleanLevel = 100f
            cleanprogressBar.progress = cleanLevel.toInt()
            updateCleanProgressBarColor(cleanLevel)

        }
        //Functions for the play button
        //Android Developers. (n.d.). Button. Retrieved from https://developer.android.com/develop/ui/views/components/button
        play_button.setOnClickListener {
            pet_action_image.setImageResource(R.drawable.anita_playing)
            gif_action_image.setImageResource(R.drawable.anitagif_laughing)
            action_text.setImageResource(R.drawable.playing_text)
            happyLevel = 100f
            happyProgressBar.progress = happyLevel.toInt()
            updateHappyProgressBarColor(happyLevel)
        }
    }
    //These are the private functions created for the progress bars, each progress bar has its corresponding
    //button and that button controls the color scheme as well as the progress bar percentage
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

    private fun launchhappyCoroutine(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            while (isActive){
                if (happyLevel > 0f){
                    happyLevel -= HappyDecreaseRate
                    happyProgressBar.progress = happyLevel.toInt()
                    updateHappyProgressBarColor(happyLevel)
                }
                delay(1000)
            }

        }

    }

    private fun updateHappyProgressBarColor(happyLevel: Float) {
        val color = when {
            happyLevel <= 25f -> "#031111"  // Sapphire Gray
            happyLevel <= 50f -> "#093533"  // Pink
            happyLevel <= 75f -> "#136a66"  // Yellow
            else -> if (happyLevel <= 100f) "#20b2aa" else "#20b2aa"

        }
        //https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color
        happyProgressBar.progressDrawable.setColorFilter(
            android.graphics.Color.parseColor(color),
            android.graphics.PorterDuff.Mode.SRC_IN
        )

    }

    private fun launchcleanCoroutine(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            while (isActive){
                if (cleanLevel > 0f){
                    cleanLevel -= CleanDecreaseRate
                    cleanprogressBar.progress = cleanLevel.toInt()
                    updateCleanProgressBarColor(cleanLevel)
                }
                delay(1000)
            }

        }
    }

    private fun updateCleanProgressBarColor(cleanLevel: Float) {
        val color = when {
            cleanLevel <= 25f -> "#061c17"  // Red
            cleanLevel <= 50f -> "#0c382e"  // Pink
            cleanLevel <= 75f -> "#10463a"  // Yellow
            else -> if (cleanLevel <= 100f) "#9954ed" else "#9954ed"  // Light green, Green
        }
        //https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color
        cleanprogressBar.progressDrawable.setColorFilter(
            android.graphics.Color.parseColor(color),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
    }

    private fun launchHungerCoroutine(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                if (hungerLevel > 0f) {
                    hungerLevel -= HungerDecreaseRate
                    hungerprogressBar.progress = hungerLevel.toInt()
                    updateHungerProgressBarColor(hungerLevel)
                }
                delay(1000)  // Update hunger level every second
            }
        }
    }

    private fun updateHungerProgressBarColor(hungerLevel: Float) {
        val color = when {
            hungerLevel <= 25f -> "#33041d"  //HEX CODE for Dark Purple
            hungerLevel <= 50f -> "#7f0a49"  //hEX CODE for Purple
            hungerLevel <= 75f -> "#b20e66"  //HEX CODE for Pink
            else -> if (hungerLevel <= 100f) "#e39699" else "#e39699"  //HEX CODE for Light Lylac
        }
        //https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color
        hungerprogressBar.progressDrawable.setColorFilter(
            android.graphics.Color.parseColor(color),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
        //This is created as a use of warning to the user when the hunger level is 0
        if ((hungerLevel == 0f)) {
            val intent = Intent(this@Page_2_Interaction_with_anita, Page_3_Funeral::class.java)
            startActivity(intent)
            }

    }

}