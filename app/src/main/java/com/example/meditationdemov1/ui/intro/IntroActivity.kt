package com.example.meditationdemov1.ui.intro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.meditationdemov1.MainActivity
import com.example.meditationdemov1.R
import com.example.meditationdemov1.helper.PrefManager
import com.example.meditationdemov1.helper.getColorWrapper
import com.example.meditationdemov1.helper.setupSlide
import com.github.paolorotolo.appintro.AppIntro2
import com.github.paolorotolo.appintro.AppIntro2Fragment
import com.github.paolorotolo.appintro.AppIntroFragment

class IntroActivity : AppIntro2() {

    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_intro)

        // check for the first time launch before setContentView()
        prefManager = PrefManager(this)
        if (!prefManager.isFirstTimeLaunch) {
            toLoginActivity()
            finish()
        } else {
            // add the slide screen
            setupIntroSlide(this)
        }

    }

    // function to setup the slide screen
    private fun setupIntroSlide(context: Context) {
        val slide1 = setupSlide(
            getString(R.string.slide_1_title),
            getString(R.string.slide_1_desc),
            R.drawable.ic_android_black_24dp,
            getColorWrapper(context, R.color.bg_screen1)
        )
        val slide2 = setupSlide(
            getString(R.string.slide_2_title),
            getString(R.string.slide_2_desc),
            R.drawable.ic_android_black_24dp,
            getColorWrapper(context, R.color.bg_screen2)
        )
        val slide3 = setupSlide(
            getString(R.string.slide_3_title),
            getString(R.string.slide_3_desc),
            R.drawable.ic_android_black_24dp,
            getColorWrapper(context, R.color.bg_screen3)
        )
        val slide4 = setupSlide(
            getString(R.string.slide_4_title),
            getString(R.string.slide_4_desc),
            R.drawable.ic_android_black_24dp,
            getColorWrapper(context, R.color.bg_screen4)
        )
        // added the slides
        addSlide(AppIntroFragment.newInstance(slide1!!))
        addSlide(AppIntroFragment.newInstance(slide2!!))
        addSlide(AppIntroFragment.newInstance(slide3!!))
        addSlide(AppIntroFragment.newInstance(slide4!!))
        // set the first time run
        //prefManager.isFirstTimeLaunch
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        toLoginActivity()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        toLoginActivity()
    }

    override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
        // code here for when the slide is changed
    }

    private fun toLoginActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}
