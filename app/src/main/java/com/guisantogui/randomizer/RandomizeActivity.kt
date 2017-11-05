package com.guisantogui.randomizer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.view.MotionEvent



class RandomizeActivity : AppCompatActivity(), RandomizeViewContract {

    lateinit var mRandomizePresenter : RandomizePresenterContract


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRandomizePresenter = RandomizePresenter(this)
        button.setOnClickListener{
            mRandomizePresenter.generate()
        }
    }

    override fun onResume() {
        super.onResume()
        mRandomizePresenter.start()
    }


    override fun setPresenter(presenter: RandomizePresenterContract) {
        mRandomizePresenter = checkNotNull(presenter)
    }


    override fun showNumber(textToShow: String) {
        number.text = textToShow
    }

}