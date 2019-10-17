package com.example.meditationdemov1.helper

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.Window
import android.view.WindowManager
import com.github.paolorotolo.appintro.model.SliderPage
import com.github.paolorotolo.appintro.model.SliderPagerBuilder


// function to change the colour of status bar transparent
fun changeStatusBarColour(window: Window){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }
}

// function to setup the slide
fun setupSlide(title: String, description: String, drawable: Int, backgroundColour: Int): SliderPage? {
    return SliderPagerBuilder()
        .title(title)
        .description(description)
        .imageDrawable(drawable)
        .bgColor(backgroundColour)
        .build()
}

// wrapper function for colour
fun getColorWrapper(context: Context, id: Int): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getColor(id)
    } else {

        context.resources.getColor(id)
    }
}