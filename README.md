IMAD ASSIGNMENT 2 REPORT:

ST10447252(Angel Khumalo)

**_Table of content:_**

**Page 2-4**

_Purpose_

_Design considerations._

**Page 5 – 11**

_GitHub Link_

_GitHub Actions_

_YouTube Link_

_Code_

**Page 12-13**

_Reference list_

**_1.Purpose_**

The purpose of this application is for education and entertainment it teaches the user the importance of responsibility and taking care of a pet this makes use of friendly attributes that teaches the user how to care for people and animals.

**_2\. Design Considerations_**

The name of the application is “ANITA MAX WYNN”, your virtual pet.

When you first open the application, you are greeted with this display this is the first page of the application, the name of the app the picture of the pet the user will interact with as well as the button that will take them to the second page.

This is the second page of the application where the user gets to interact with their pet.

These are the displays, the first one is of the cat eating, the second one is of the cat bathing and the third one is of the cat playing.

These are the buttons, that the user will click for specific actions, these buttons will do as follows:

Feed Button: when the user clicks this button it will display the cat eating as well as increase the hunger level at 100, a progress bar changes colour to indicate max medium and minimum.

Bath Button: when a user clicks this button it will display the cat bathing as well as increase the clean level at 100.

Play Button: when the user clicks this button it will display the cat playing as well as increase the happiness level at 100.

This is the status of the cat’s hunger, cleanliness, and happiness, when a user takes care of the cat the progress bar will go up to 100 percent, when the user is not taking care of the cat it will gradually descend to 0 percent and corresponds with the colour in simple terms dark is bad and light is good.

**_General design_**

Yes, the application is user friendly for children of all ages, it is very intuitive and bright it uses bright colours robust texts and a very creative display.

**_Intuitive design_**

The design is very easy to follow with clear buttons and functionality the user is prompted correctly, and the game is very friendly with outline on how the game works and how the user interacts with the pet.

**_Content prioritisation_**

All elements of the application are dependent on user action, the application displays all structural attributes correctly for the user to read and utilise clearly.

All the apps interface and user experience are clear for the user to use.

**_Legible Text Content_**

The text has bold colour, making use of creative colour scheme and text appearance for size and clarity for the user to read and understand.

**_Make Interface Elements Clearly Visible_**

The User can view the elements, they are visible and clear for the user to see and use, the text view uses bold font and a readable text.

**_Hand Position Controls_**

The buttons are easy to reach and have clear text, the buttons also have icons that match with the text to give the user a clear example of what the button is intended for.

**_Images_**

The images I chose are user friendly. Because the app is for children the images better suite the applications design as well as user experience, children won’t get confused with the app as it is user friendly with the use of primary colours as well as intuitive shapes users can use the app with no worry and/or confusion.

**_GitHub Link_**

<https://github.com/ST10447252/FluffyPetAnita.git>

**_Github Actions_**

**_YouTube link:_**

<https://youtu.be/Gfw5W8Dbsx0?si=hb02GKGmqbmu5IJP>

**_CODE:_**

The code below is for each page functionality with comments as well as in text references the code has clear text on what specific functionality and utilization is used.

**Activity_Welcome_Page**

_package_ com.st10458042.fluffypetanita  
<br/>_import_ android.animation.Animator  
_import_ android.animation.AnimatorListenerAdapter  
_import_ android.animation.AnimatorSet  
_import_ android.animation.ObjectAnimator  
_import_ android.annotation.SuppressLint  
_import_ android.content.Intent  
_import_ android.os.Bundle  
_import_ android.view.animation.LinearInterpolator  
_import_ android.widget.ImageButton  
_import_ androidx.activity.enableEdgeToEdge  
_import_ androidx.appcompat.app.AppCompatActivity  
_import_ androidx.core.view.ViewCompat  
_import_ androidx.core.view.WindowInsetsCompat  
_import_ pl.droidsonroids.gif.GifImageView  
<br/>_class_ MainActivity : AppCompatActivity() {  
_private lateinit var_ gifImageView: GifImageView  
@SuppressLint("MissingInflatedId")  
_override fun_ onCreate(savedInstanceState: Bundle?) {  
_super_.onCreate(savedInstanceState)  
_enableEdgeToEdge_()  
setContentView(R.layout._activity_welcome_page_)  
ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id._main_)) **{** v, insets **\->  
**_val_ systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())  
v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)  
insets  
**}  
<br/><br/><br/>**_//A Declaration of the button that will be used to move to the next page  
//Android Developers. (n.d.). Button. Retrieved from <https://developer.android.com/develop/ui/views/components/button>  
val_ enter_button = findViewById&lt;ImageButton&gt;(R.id._EnterButton_)  
enter_button.setOnClickListener **{  
**_val_ intent = Intent(_this_, Page_2_Interaction_with_anita::_class_._java_) _//Intent to move to the next page  
_startActivity(intent)  
**}  
**_//Theres an Animation used, and executed using a loop of the animation.  
//Android Developers. (n.d.). Animations overview. Retrieved from <https://developer.android.com/develop/ui/views/animations/overview>  
_gifImageView = findViewById(R.id._gif_rocket_)  
startSlideAnimation()  
}  
_//After the Animation has been set, a private function is created to ensure the animation plays  
<br/>private fun_ startSlideAnimation() {  
_val_ screenWidth = _resources_._displayMetrics_.widthPixels  
_val_ animatorSet = AnimatorSet()._apply_ **{  
**playSequentially(  
ObjectAnimator.ofFloat(gifImageView, "translationX", -screenWidth.toFloat(), 720f),  
ObjectAnimator.ofFloat(gifImageView, "translationX", -screenWidth.toFloat(), 720f)  
)  
_duration_ \= 4000 _// Animation duration in milliseconds = 4seconds  
interpolator_ \= LinearInterpolator() _//A linear adapter is set which belongs to the android widget  
_addListener(_object_ : AnimatorListenerAdapter(){  
_override fun_ onAnimationEnd(animation: Animator) {  
_super_.onAnimationEnd(animation)  
animation.start()  
}  
})  
<br/>**}**_//This enables the background animation to being  
_animatorSet.start()  
<br/><br/>_//Reference List  
<br/>//Android Developers. (n.d.). Animations overview. Retrieved from <https://developer.android.com/develop/ui/views/animations/overview>  
_}  
}

**Page_2_interaction_with_anita**

_package_ com.st10458042.fluffypetanita  
<br/>_import_ android.animation.Animator  
_import_ android.animation.AnimatorListenerAdapter  
_import_ android.animation.AnimatorSet  
_import_ android.animation.ObjectAnimator  
_import_ android.annotation.SuppressLint  
_import_ android.content.Intent  
_import_ android.os.Bundle  
_import_ android.view.animation.LinearInterpolator  
_import_ android.widget.ImageButton  
_import_ android.widget.ImageView  
_import_ android.widget.ProgressBar  
_import_ androidx.activity.enableEdgeToEdge  
_import_ androidx.appcompat.app.AppCompatActivity  
_import_ androidx.core.view.ViewCompat  
_import_ androidx.core.view.WindowInsetsCompat  
_import_ kotlinx.coroutines.CoroutineScope  
_import_ kotlinx.coroutines.Dispatchers  
_import_ kotlinx.coroutines.Job  
_import_ kotlinx.coroutines.delay  
_import_ kotlinx.coroutines.isActive  
_import_ kotlinx.coroutines.launch  
_import_ pl.droidsonroids.gif.GifImageButton  
_import_ pl.droidsonroids.gif.GifImageView  
<br/>_class_ Page_2_Interaction_with_anita : AppCompatActivity() {  
_//Private Declarations  
//Gif Image view were manually installed using droids on roids  
private lateinit var_ gifImageView: GifImageView  
<br/>_private lateinit var_ hungerprogressBar: ProgressBar _//android studio progress bar is declared  
private var_ hungerLevel = 100f _//this is 100%  
private val_ HungerDecreaseRate = 5f _//this will deplete in increments of 5  
//The same process is done for the rest  
private lateinit var_ cleanprogressBar: ProgressBar  
_private var_ cleanLevel = 100f  
_private val_ CleanDecreaseRate = 5f  
_//<https://developer.android.com/kotlin/coroutines>  
<br/>private lateinit var_ happyProgressBar: ProgressBar  
_private var_ happyLevel = 100f  
_private val_ HappyDecreaseRate = 5f  
<br/><br/>@SuppressLint("MissingInflatedId")  
_override fun_ onCreate(savedInstanceState: Bundle?) {  
_super_.onCreate(savedInstanceState)  
_enableEdgeToEdge_()  
setContentView(R.layout._activity_page2_interaction_with_anita_)  
ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id._main_)) **{** v, insets **\->  
**_val_ systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())  
v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)  
insets  
**}  
**_//the back button is used in case a users device does not have a back button  
val_ back_button = findViewById&lt;ImageButton&gt;(R.id._Back_Button_)  
back_button.setOnClickListener **{  
**_val_ intent = Intent(_this_, MainActivity::_class_._java_)  
startActivity(intent)  
**}  
**_//Animation  
_gifImageView = findViewById(R.id._gif_rocket_)  
startSlideAnimation()  
_//Declarations for the buttons used  
val_ feed_button = findViewById&lt;ImageButton&gt;(R.id._feed_button_)  
_val_ bath_button = findViewById&lt;ImageButton&gt;(R.id._bath_button_)  
_val_ play_button = findViewById&lt;ImageButton&gt;(R.id._play_button_)  
_val_ sleep_button = findViewById&lt;GifImageButton&gt;(R.id._sleep_button_)  
<br/>_//Declarations used for th Image Views  
//Android Developers. (n.d.). ImageView. Retrieved from <https://developer.android.com/reference/android/widget/ImageView>  
<br/>val_ pet_action_image = findViewById&lt;ImageView&gt;(R.id._pet_action_view_)  
_val_ gif_action_image = findViewById&lt;ImageView&gt;(R.id._gif_pet_views_)  
_val_ action_text = findViewById&lt;ImageView&gt;(R.id._action_text_)  
<br/>_//The progress bar is declared and the progress is set to the level that is matched  
//<https://developer.android.com/kotlin/coroutines>  
_hungerprogressBar = findViewById(R.id._hunger_progress_)  
hungerprogressBar._progress_ \= hungerLevel.toInt()  
_val_ hungerCoroutine = launchHungerCoroutine() _//This launches a coroutine that will update the progress bar every second  
<br/>_cleanprogressBar = findViewById(R.id._clean_progress_)  
cleanprogressBar._progress_ \= cleanLevel.toInt()  
_val_ cleanCoroutine = launchcleanCoroutine()  
<br/>happyProgressBar = findViewById(R.id._happy_progress_)  
happyProgressBar._progress_ \= happyLevel.toInt()  
_val_ happyCoroutine = launchhappyCoroutine()  
<br/>_//Functions for the sleep button  
_sleep_button.setOnClickListener **{** _//when this button is clicked it triggers the sleeping function of the pet and its sleeping elements  
_pet_action_image.setImageResource(R.drawable._anita_sleeping_)  
gif_action_image.setImageResource(R.drawable._anitagif_sleeping_)  
action_text.setImageResource(R.drawable._sleeping_text_)  
**}  
<br/>**_//Functions for the feed button  
//Android Developers. (n.d.). Button. Retrieved from <https://developer.android.com/develop/ui/views/components/button>  
_feed_button.setOnClickListener **{** _//when this button is clicked it triggers the eating function of the pet and its eating elements  
_pet_action_image.setImageResource(R.drawable._anita_eating_)  
gif_action_image.setImageResource(R.drawable._hamburger_)  
action_text.setImageResource(R.drawable._eating_text_)  
hungerLevel = 100f _// Reset hunger level to full  
_hungerprogressBar._progress_ \= hungerLevel.toInt()  
updateHungerProgressBarColor(hungerLevel)  
**}  
**_//Functions for the bath button  
//Android Developers. (n.d.). Button. Retrieved from <https://developer.android.com/develop/ui/views/components/button>  
_bath_button.setOnClickListener **{** _//When this button is clicked it triggers the bathing function of the pet and its bathing elements  
_pet_action_image.setImageResource(R.drawable._anita_bathing_)  
gif_action_image.setImageResource(R.drawable._water_)  
action_text.setImageResource(R.drawable._bathing_text_)  
cleanLevel = 100f  
cleanprogressBar._progress_ \= cleanLevel.toInt()  
updateCleanProgressBarColor(cleanLevel)  
<br/>**}  
**_//Functions for the play button  
//Android Developers. (n.d.). Button. Retrieved from <https://developer.android.com/develop/ui/views/components/button>  
_play_button.setOnClickListener **{**_//When this button is clicked it triggers the playing function of the pet and its playing elements  
_pet_action_image.setImageResource(R.drawable._anita_playing_)  
gif_action_image.setImageResource(R.drawable._anitagif_laughing_)  
action_text.setImageResource(R.drawable._playing_text_)  
happyLevel = 100f  
happyProgressBar._progress_ \= happyLevel.toInt()  
updateHappyProgressBarColor(happyLevel)  
**}  
**}  
_//These are the private functions created for the progress bars, each progress bar has its corresponding  
//button and that button controls the color scheme as well as the progress bar percentage  
private fun_ startSlideAnimation() { _//this private function is used to start the animation of the rocket  
val_ screenWidth = _resources_._displayMetrics_.widthPixels  
_val_ animatorSet = AnimatorSet()._apply_ **{  
**playSequentially(  
ObjectAnimator.ofFloat(gifImageView, "translationX", -screenWidth.toFloat(), 720f),  
ObjectAnimator.ofFloat(gifImageView, "translationX", -screenWidth.toFloat(), 720f)  
)  
_duration_ \= 4000 _//this is the duration of the animation  
interpolator_ \= LinearInterpolator()  
addListener(_object_ : AnimatorListenerAdapter(){  
_override fun_ onAnimationEnd(animation: Animator) {  
_super_.onAnimationEnd(animation)  
animation.start() _//this triggers the animation to start again  
_}  
})  
<br/>**}**_//This enables the background animation  
_animatorSet.start()  
}  
<br/>_private fun_ launchhappyCoroutine(): _Job_ { _//this private function is used to launch the coroutine that will update the progress bar every second  
return CoroutineScope_(Dispatchers.Main)._launch_ **{  
**_while_ (_isActive_){  
_if_ (happyLevel > 0f){  
happyLevel -= HappyDecreaseRate  
happyProgressBar._progress_ \= happyLevel.toInt()  
updateHappyProgressBarColor(happyLevel)  
}  
delay(1000)  
}  
<br/>**}  
<br/>**}  
<br/>_private fun_ updateHappyProgressBarColor(happyLevel: Float) { _//this private function is used to update the color of the progress bar based on the happy level  
val_ color = _when_ {  
happyLevel &lt;= 25f -&gt; "#031111"_// Sapphire Gray  
_happyLevel &lt;= 50f -&gt; "#093533"_// HEX CODE for minx green  
_happyLevel &lt;= 75f -&gt; "#136a66" _// HEX CODE for dark umber  
else_ \-> _if_ (happyLevel <= 100f) "#20b2aa" _else_ "#20b2aa" _//HEX CODE for Green  
<br/>_}  
_//<https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color>  
_happyProgressBar._progressDrawable_.setColorFilter(  
android.graphics.Color.parseColor(color),  
android.graphics.PorterDuff.Mode._SRC_IN  
_)  
<br/>}  
<br/>_private fun_ launchcleanCoroutine(): _Job_ { _//this private function is used to launch the coroutine that will update the progress bar every second  
return CoroutineScope_(Dispatchers.Main)._launch_ **{  
**_while_ (_isActive_){  
_if_ (cleanLevel > 0f){  
cleanLevel -= CleanDecreaseRate  
cleanprogressBar._progress_ \= cleanLevel.toInt()  
updateCleanProgressBarColor(cleanLevel)  
}  
delay(1000)  
}  
<br/>**}  
**}  
<br/>_private fun_ updateCleanProgressBarColor(cleanLevel: Float) {  
_val_ color = _when_ {  
cleanLevel &lt;= 25f -&gt; "#061c17" _//HEX CODE for eves grey  
_cleanLevel &lt;= 50f -&gt; "#0c382e" _//HEX CODE for gradient bloom  
_cleanLevel &lt;= 75f -&gt; "#10463a" _//HEX CODE for deep purple  
else_ \-> _if_ (cleanLevel <= 100f) "#9954ed" _else_ "#9954ed" _//HEX CODE for Purple  
_}  
_//<https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color>  
_cleanprogressBar._progressDrawable_.setColorFilter(  
android.graphics.Color.parseColor(color),  
android.graphics.PorterDuff.Mode._SRC_IN  
_)  
}  
<br/>_private fun_ launchHungerCoroutine(): _Job_ {  
_return CoroutineScope_(Dispatchers.Main)._launch_ **{  
**_while_ (_isActive_) {  
_if_ (hungerLevel > 0f) {  
hungerLevel -= HungerDecreaseRate  
hungerprogressBar._progress_ \= hungerLevel.toInt()  
updateHungerProgressBarColor(hungerLevel)  
}  
delay(1000)_// Update hunger level every second  
_}  
**}  
**}  
<br/>_private fun_ updateHungerProgressBarColor(hungerLevel: Float) {  
_val_ color = _when_ {  
hungerLevel &lt;= 25f -&gt; "#33041d"_//HEX CODE for Dark Purple  
_hungerLevel &lt;= 50f -&gt; "#7f0a49"_//hEX CODE for Purple  
_hungerLevel &lt;= 75f -&gt; "#b20e66" _//HEX CODE for Pink  
else_ \-> _if_ (hungerLevel <= 100f) "#e39699" _else_ "#e39699"_//HEX CODE for Light Lilac  
_}  
_//<https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color>  
_hungerprogressBar._progressDrawable_.setColorFilter(  
android.graphics.Color.parseColor(color),  
android.graphics.PorterDuff.Mode._SRC_IN  
_)  
_//This is created as a use of warning to the user when the hunger level is 0  
if_ ((hungerLevel == 0f)) {  
_val_ intent = Intent(_this_@Page_2_Interaction_with_anita, Page_3_Funeral::_class_._java_)  
startActivity(intent)  
}  
<br/><br/><br/>_//Reference list  
<br/>// Kotlin. (2022, October 18). Coroutines. Retrieved from <https://kotlinlang.org/docs/coroutines-overview.html#how-to-start>  
//ProgressBar. (2024, April 11). Retrieved from <https://developer.android.com/reference/android/widget/ProgressBar>  
//Android Developers. (n.d.). Color. Retrieved from <https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color>  
//Android Developers. (n.d.). Color. Retrieved from <https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color>  
//Android Developers. (n.d.). UI. Retrieved from <https://developer.android.com/develop/ui>  
//android-gif-drawable. (n.d.). Gradle (Android Studio). Retrieved from <https://github.com/koral--/android-gif-drawable>  
<br/><br/>_}  
<br/>}

**Page_3_Funeral**

_package_ com.st10458042.fluffypetanita  
<br/>_import_ android.annotation.SuppressLint  
_import_ android.content.Intent  
_import_ android.os.Bundle  
_import_ android.widget.ImageButton  
_import_ androidx.activity.enableEdgeToEdge  
_import_ androidx.appcompat.app.AppCompatActivity  
_import_ androidx.core.view.ViewCompat  
_import_ androidx.core.view.WindowInsetsCompat  
<br/>_class_ Page_3_Funeral : AppCompatActivity() {  
@SuppressLint("MissingInflatedId")  
_override fun_ onCreate(savedInstanceState: Bundle?) {  
_super_.onCreate(savedInstanceState)  
_enableEdgeToEdge_()  
setContentView(R.layout._activity_page3_funeral_)  
ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id._main_)) **{** v, insets **\->  
**_val_ systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())  
v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)  
insets  
**}  
**_//Android Developers. (n.d.). Button. Retrieved from <https://developer.android.com/develop/ui/views/components/button>  
val_ back_button = findViewById&lt;ImageButton&gt;(R.id._cat_back_button_)  
back_button.setOnClickListener **{  
**_val_ intent = Intent(_this_, MainActivity::_class_._java_)  
startActivity(intent)  
**}  
**}  
}

**_Reference list_**

1. Figma (2024). Copyright © 2024 Adobe. All rights reserved. Application used for designing fluffypetanita.
2. Adobe. (2022). Illustrator. Copyright © 2022 Adobe. All rights reserved. Application used for drawing pet.
3. Android Developers. (n.d.). ProgressBar. Retrieved from <https://developer.android.com/reference/android/widget/ProgressBar>
4. Android Developers. (n.d.). Coroutines. Retrieved from <https://developer.android.com/kotlin/coroutines>
5. Android Developers. (n.d.). Use coroutines for main safety. Retrieved from <https://developer.android.com/kotlin/coroutines#use-coroutines-for-main-safety>
6. Android Developers. (n.d.). Animations overview. Retrieved from <https://developer.android.com/develop/ui/views/animations/overview>
7. Android Developers. (n.d.). Transitions between activities. Retrieved from <https://developer.android.com/develop/ui/views/animations/transitions/start-activity>
8. Android Developers. (n.d.). Gradle API. Retrieved from <https://developer.android.com/reference/tools/gradle-api>
9. Android Developers. (n.d.). AnimatedImageDrawable. Retrieved from <https://developer.android.com/reference/android/graphics/drawable/AnimatedImageDrawable>
10. Android Developers. (n.d.). Color. Retrieved from <https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color>
11. Android Developers. (n.d.). Color. Retrieved from <https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color>
12. Android Developers. (n.d.). UI. Retrieved from <https://developer.android.com/develop/ui>
13. Android Developers. (2024, April 4). Timer. Retrieved from <https://developer.android.com/reference/androidx/appsearch/builtintypes/Timer>
