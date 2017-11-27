package com.guisantogui.randomize.Base

import android.content.Context
import android.os.Bundle
import android.view.View
import com.google.firebase.analytics.FirebaseAnalytics


abstract class AbstractTrackedClick(val buttonName: String,
                                    val context: Context,
                                    val bundle: Bundle?)
                        : View.OnClickListener {

    override fun onClick(v: View) {
        val firebase = FirebaseAnalytics.getInstance(context)
        firebase.logEvent("Click_on_$buttonName", bundle)
    }
}
