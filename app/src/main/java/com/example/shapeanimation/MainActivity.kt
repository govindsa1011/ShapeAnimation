package com.example.shapeanimation

import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        view?.setOnClickListener {
            animation()
            view?.isEnabled = false
        }

        view?.performClick()
    }

    fun animation(){
        Handler().postDelayed(Runnable {
            view?.performClick()
//            animation()
        },1000)
    }
}
