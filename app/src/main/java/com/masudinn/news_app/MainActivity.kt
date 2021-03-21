package com.masudinn.news_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masudinn.news_app.core.Utils.setWhiteStatusBar
import com.masudinn.news_app.features.home.view.HomeActivity

//splash activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        setWhiteStatusBar()
        goToHomePage()
    }

    private fun goToHomePage(){
        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
        finish()
    }
}