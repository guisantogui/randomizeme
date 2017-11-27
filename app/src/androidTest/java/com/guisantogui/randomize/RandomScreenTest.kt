package com.guisantogui.randomize

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import com.guisantogui.randomize.randomGeneration.RandomizeActivity
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class RandomScreenTest {

    @get:Rule
    var mRandomize: ActivityTestRule<RandomizeActivity>
                            = ActivityTestRule(RandomizeActivity::class.java)

    @Test
    fun clickGenerateRandom() {

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.number)).check(matches(isDisplayed()))

    }
}
