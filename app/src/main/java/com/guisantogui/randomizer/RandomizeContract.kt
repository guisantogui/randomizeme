package com.guisantogui.randomizer


interface RandomizeViewContract : BaseView<RandomizePresenterContract> {

    fun showNumber(textToShow: String)

}

interface RandomizePresenterContract : BasePresenter{

    fun randomize(): Int

    fun isOrdinal(): Boolean

    fun generate()

    fun generateOrdinalFor(number: Int): String

}