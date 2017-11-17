package com.guisantogui.randomize.randomGeneration

import io.realm.RealmObject

open class RandomNumber(var number: Int) : RealmObject() {

    constructor(): this(-1){}
}