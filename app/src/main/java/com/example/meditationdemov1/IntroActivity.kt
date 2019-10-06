package com.example.meditationdemov1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meditationdemov1.helper.PrefManager
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE


class IntroActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // check for the first time launch before setContentView()
        prefManager = PrefManager(this)
        if (!prefManager.isFirstTimeLaunch){
            launchHomeScreen()
            finish()
        }

        // setting notification bar transparent
        if (Build.VERSION.SDK_INT >= 21){
            window.decorView.systemUiVisibility =
                SYSTEM_UI_FLAG_LAYOUT_STABLE or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        setContentView(R.layout.activity_intro)

    }

    // function to launch the main activity
    private fun launchHomeScreen(){
        prefManager.isFirstTimeLaunch = false
        startActivity(Intent(this, MainActivity::class.java))
    }

}
