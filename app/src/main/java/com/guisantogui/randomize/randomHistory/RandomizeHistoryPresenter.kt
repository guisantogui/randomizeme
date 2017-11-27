package com.guisantogui.randomize.randomHistory

import com.guisantogui.randomize.randomGeneration.RandomNumber

class RandomizeHistoryPresenter : RandomizeHistoryContract.Presenter {


    override fun loadData(): List<RandomNumber> {
        return ArrayList<RandomNumber>()
    }

}