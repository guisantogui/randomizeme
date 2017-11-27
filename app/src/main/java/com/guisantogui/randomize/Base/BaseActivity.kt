package com.guisantogui.randomize.Base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.google.firebase.analytics.FirebaseAnalytics

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getActivityName(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var last = intent?.getStringExtra("LAST_ACTIVITY")
        val current = getActivityName()

        val b = Bundle()
        if (last == null || last.isEmpty()) {
            last = "N/A"
        }

        b.putString("FROM", last)
        b.putString("TO", current)

        val firebase = FirebaseAnalytics.getInstance(this)
        firebase.logEvent("class_transition", b)

    }

    override fun startActivity(intent: Intent) {
        intent.putExtra("LAST_ACTIVITY", getActivityName())
        super.startActivity(intent)
    }
}