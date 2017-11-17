package com.guisantogui.randomize.randomHistory

import com.guisantogui.randomize.randomGeneration.RandomNumber

class RandomizeHistoryContract {

    interface View {

        fun clearHistory()

        fun showHistory()
    }


    interface Presenter{

        fun loadData(): List<RandomNumber>
    }
}