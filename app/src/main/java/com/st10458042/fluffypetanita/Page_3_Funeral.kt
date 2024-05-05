package com.st10458042.fluffypetanita

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_3_Funeral : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page3_funeral)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Android Developers. (n.d.). Button. Retrieved from https://developer.android.com/develop/ui/views/components/button
        val back_button = findViewById<ImageButton>(R.id.cat_back_button)
        back_button.setOnClickListener {
            val intent = Intent(this, Page_2_Interaction_with_anita::class.java)
            startActivity(intent)
        }
    }
}