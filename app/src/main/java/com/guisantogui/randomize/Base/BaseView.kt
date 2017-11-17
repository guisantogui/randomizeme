package com.guisantogui.randomize.Base

interface BaseView<in T> {

    fun setPresenter(presenter: T)
}