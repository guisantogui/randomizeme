package com.guisantogui.randomize

import com.guisantogui.randomize.randomGeneration.Presenter
import com.guisantogui.randomize.randomGeneration.RandomizeContract
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.lessThan
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
class RandomizePresenterTest {

    @Mock
    lateinit var view: RandomizeContract.View

    lateinit var presenter: RandomizeContract.Presenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(view.isActive()).thenReturn(true)
    }

    @Test
    fun randomizeTest() {
        presenter = Presenter(view)

        assertThat(presenter.randomize().number, `is`(greaterThan(-1)))
        assertThat(presenter.randomize().number, `is`(lessThan(101)))
    }

    @Test
    fun generateOrdinalForIntTest() {
        presenter = Presenter(view)

        assertThat(presenter.generateOrdinalFor(1), `is`("st"))
        assertThat(presenter.generateOrdinalFor(2), `is`("nd"))
        assertThat(presenter.generateOrdinalFor(3), `is`("rd"))
        assertThat(presenter.generateOrdinalFor(4), `is`("th"))
        assertThat(presenter.generateOrdinalFor(11), `is`("th"))
        assertThat(presenter.generateOrdinalFor(12), `is`("th"))
        assertThat(presenter.generateOrdinalFor(13), `is`("th"))
    }


    @Test
    fun isOrdinalTest(){
        presenter = Presenter(view)

        assertThat(presenter.isOrdinal(), `is`(notNullValue()))
    }

}