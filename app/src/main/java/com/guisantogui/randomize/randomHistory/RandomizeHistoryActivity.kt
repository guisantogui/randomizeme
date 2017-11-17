package com.guisantogui.randomize.randomHistory

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.guisantogui.randomize.R
import kotlinx.android.synthetic.main.activity_randomize_history.*

class RandomizeHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomize_history)

        val action = intent.action
        val uri = intent.data

        if(intent.data != null){
            Log.d("TAG", uri.toString())
        }
        else {
            Log.d("TAG", "NULL URI")
        }

        Log.d("TAG", action)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
