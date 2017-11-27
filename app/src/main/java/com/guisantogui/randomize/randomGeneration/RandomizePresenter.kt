package com.guisantogui.randomize.randomGeneration

import java.util.*

class RandomizePresenter(contract: RandomizeContract.View) : RandomizeContract.Presenter {

    val mRandomizeView: RandomizeContract.View = contract

    override fun handleNumberToScreen(isOrdinal: Boolean): String{
        val generated = randomize().number
        return if(isOrdinal){
                   val ordinal = generateOrdinalFor(generated)
                   "$generated$ordinal"
               }
               else {
                   generated.toString()
               }
    }

    override fun printToScreen(text: String){
        mRandomizeView.showNumber(text)
    }

    override fun start() {
        printToScreen(handleNumberToScreen(isOrdinal()))
    }

    override fun randomize(): RandomNumber {
        return RandomNumber(Random().nextInt(100))
    }

    override fun isOrdinal(): Boolean {
        return Random().nextInt(2) == 0
    }

    init {
        mRandomizeView.setPresenter(this)
    }

    override fun generateOrdinalFor(number: Int): String {
        val hundredRemainder = number % 100
        val tenRemainder = number % 10
        if (hundredRemainder - tenRemainder == 10) {
            return "th"
        }

        return when (tenRemainder) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }
}