package com.guisantogui.randomizer

interface BaseView<in T> {

    fun setPresenter(presenter: T)
}