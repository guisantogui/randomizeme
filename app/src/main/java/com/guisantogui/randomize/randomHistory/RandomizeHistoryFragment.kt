package com.guisantogui.randomize.randomHistory


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.guisantogui.randomize.R


/**
 * A simple [Fragment] subclass.
 */
class RandomizeHistoryFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_randomize_history, container, false)
    }

}// Required empty public constructor
