package com.guisantogui.randomizer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            randomizeMe()
        }
    }
    
    fun randomizeMe(){
        val a = Random().nextInt(100)
        val b = Random().nextInt(2)

        if(b % 2.0 == 0.0){ //is ordinal
            number.text = "${a}°"
        }
        else { //is cardinal
            number.text = a.toString()
        }
    }
}
