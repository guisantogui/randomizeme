package com.guisantogui.randomize

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.guisantogui.randomize.Base.AbstractTrackedClick
import com.guisantogui.randomize.Base.BaseActivity
import com.guisantogui.randomize.randomGeneration.RandomizeActivity

import kotlinx.android.synthetic.main.activity_making_path.*

class MakingPathActivity : BaseActivity() {

    override fun getActivityName(): String {
        return MakingPathActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_making_path)
        setSupportActionBar(toolbar)

        fab.setOnClickListener(object: AbstractTrackedClick("FAB_PATH", this, null){
            override fun onClick(v: View) {
                super.onClick(v)

                val intent = Intent(context, RandomizeActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
