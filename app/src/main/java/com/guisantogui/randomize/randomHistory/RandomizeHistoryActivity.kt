package com.guisantogui.randomize.randomHistory

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import com.guisantogui.randomize.R
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.guisantogui.randomize.Base.AbstractTrackedClick
import com.guisantogui.randomize.Base.BaseActivity
import com.guisantogui.randomize.MakingPathActivity
import com.guisantogui.randomize.randomGeneration.RandomizeActivity
import kotlinx.android.synthetic.main.activity_randomize_history.*
import kotlinx.android.synthetic.main.content_randomize_history.*


class RandomizeHistoryActivity : BaseActivity() {


    override fun getActivityName(): String {
        return RandomizeHistoryActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomize_history)

        val action = intent.action
        val uri = intent.data

        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(intent)
                .addOnSuccessListener(this, { pendingDynamicLinkData ->
                                        // Get deep link from result (may be null if no link is found)
                        var deepLink: Uri? = null
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.link

                         //   Log.d("TAG", "pendingDynamicLinkData: "+deepLink)
                        }

                        })

                .addOnFailureListener(this, OnFailureListener
                        { e -> Log.w("TAG", "getDynamicLink:onFailure", e) }
                )

        Log.d("TAG", "EXECUTANDO")

        if(intent.data != null){
            Log.d("TAG", "QUERY "+ uri)

            my_fucking_custom_parameter.text = uri.query
        }
        else {
        //    Log.d("TAG", "NULL URI")
        }


        fab.setOnClickListener(object: AbstractTrackedClick("FAB_HISTO", this, null){
            override fun onClick(v: View) {
                super.onClick(v)

                val intent = Intent(context, MakingPathActivity::class.java)
                startActivity(intent)
            }
        })
    }

}
