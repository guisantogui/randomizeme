package com.guisantogui.randomize.randomGeneration

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.analytics.FirebaseAnalytics
import com.guisantogui.randomize.Base.AbstractTrackedClick
import com.guisantogui.randomize.Base.BaseActivity
import com.guisantogui.randomize.R
import com.guisantogui.randomize.randomHistory.RandomizeHistoryActivity
import kotlinx.android.synthetic.main.activity_main.*

class RandomizeActivity : BaseActivity(), RandomizeContract.View {

    override fun getActivityName(): String {
        return RandomizeActivity::class.java.simpleName
    }

    lateinit var mPresenter: RandomizeContract.Presenter
    var active: Boolean = false
    lateinit var mFirebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        mFirebaseAnalytics.setCurrentScreen(this, "Randomize", RandomizeActivity::class.java.simpleName)

        mPresenter = RandomizePresenter(this)
        button.setOnClickListener(object: AbstractTrackedClick("RANDOMIZE", this, null){
            override fun onClick(v: View) {
                super.onClick(v)

                mPresenter.printToScreen(mPresenter.handleNumberToScreen(mPresenter.isOrdinal()))
            }
        })

        button2.setOnClickListener(object: AbstractTrackedClick("SO_VAI", this, null){
            override fun onClick(v: View) {
                super.onClick(v)

                val intent = Intent(context, RandomizeHistoryActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        active = true
        mPresenter.start()
    }

    override fun onPause() {
        super.onPause()
        active = false
    }

    override fun isActive(): Boolean {
        return active
    }

    override fun setPresenter(presenter: RandomizeContract.Presenter) {
        mPresenter = checkNotNull(presenter)
    }

    override fun showNumber(textToShow: String) {
        number.text = textToShow
    }
}