package com.guisantogui.randomizer

import java.util.*

class RandomizePresenter(contract: RandomizeViewContract) : RandomizePresenterContract {

    val mRandomizeView: RandomizeViewContract = contract

    override fun generate(){
        var text: String
        val generated = randomize()
        text = if(isOrdinal()){
                   val ordinal = generateOrdinalFor(generated)

                   "$generated$ordinal"
               }
               else{
                   generated.toString()
               }

        mRandomizeView.showNumber(text)
    }

    override fun start() {
        generate()
    }

    override fun randomize(): Int {
        return Random().nextInt(100)
    }

    override fun isOrdinal(): Boolean {
        return Random().nextInt(2) % 2 == 0
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