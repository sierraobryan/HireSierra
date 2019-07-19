package com.example.sierraobryan.myapplication

import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.sierraobryan.myapplication.ui.activity.MainActivity
import com.example.sierraobryan.myapplication.ui.activity.ReasonActivity


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.sierraobryan.myapplication", appContext.packageName)
    }

    @get: Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Test
    fun onFabAClick() {
        Intents.init()
        onView(withId(R.id.multiple_actions)).perform(click())
        onView(withId(R.id.action_a)).check(matches(isDisplayed()))
        onView(withId(R.id.action_a)).perform(click())
       // onView(withId(R.id.container)).check(matches(isDisplayed()))
        Intents.release()
    }

    @Test
    fun onFabBClick() {
        Intents.init()
        onView(withId(R.id.multiple_actions)).perform(click())
        onView(withId(R.id.action_b)).check(matches(isDisplayed()))
        onView(withId(R.id.action_b)).perform(click())
        //onView(withId(R.id.container)).check(matches(isDisplayed()))
        Intents.release()
    }
}
