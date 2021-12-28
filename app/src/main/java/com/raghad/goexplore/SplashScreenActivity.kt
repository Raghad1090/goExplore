package com.raghad.goexplore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //hide bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            val intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },4000) // 4 seconds

//        val textView: TextView = findViewById(R.id.splashScreenText)
//        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.)
//        textView.startAnimation(sideAnimation)

    }
}