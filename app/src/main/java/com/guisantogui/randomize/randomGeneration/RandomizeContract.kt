package com.guisantogui.randomize.randomGeneration

import com.guisantogui.randomize.Base.BasePresenter
import com.guisantogui.randomize.Base.BaseView


class RandomizeContract {

    interface View : BaseView<Presenter> {

        fun showNumber(textToShow: String)

        fun isActive(): Boolean

    }

    interface Presenter : BasePresenter {

        fun randomize(): RandomNumber

        fun isOrdinal(): Boolean

        fun printToScreen(text: String)

        fun handleNumberToScreen(isOrdinal: Boolean): String

        fun generateOrdinalFor(number: Int): String

    }

}



