package com.guisantogui.randomize

import com.guisantogui.randomize.randomGeneration.RandomNumber
import com.guisantogui.randomize.randomGeneration.RandomizeContract
import com.guisantogui.randomize.randomGeneration.RandomizePresenter
import com.guisantogui.randomize.randomHistory.RandomizeHistoryContract
import com.guisantogui.randomize.randomHistory.RandomizeHistoryPresenter
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class RandomizeHistoryPresenterTest {

    @Mock
    lateinit var view: RandomizeHistoryContract.View

    lateinit var presenter: RandomizeHistoryContract.Presenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(view.isActive()).thenReturn(true)
    }

    @Test
    fun loadDataTest(){
        presenter = RandomizeHistoryPresenter()
        assertThat(presenter.loadData().size, `is`(greaterThan(0)))
    }
}