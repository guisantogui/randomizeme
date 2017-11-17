package com.guisantogui.randomize.randomGeneration

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.guisantogui.randomize.R
import kotlinx.android.synthetic.main.activity_main.*


class RandomizeActivity : AppCompatActivity(), RandomizeContract.View {

    lateinit var mPresenter: RandomizeContract.Presenter
    var active: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mPresenter = Presenter(this)
        button.setOnClickListener{
            mPresenter.handleNumberToScreen(mPresenter.isOrdinal())
        }
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