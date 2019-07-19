package com.example.sierraobryan.myapplication

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.ComponentNameMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.sierraobryan.myapplication.ui.activity.CommentsActivity
import com.example.sierraobryan.myapplication.ui.activity.MainActivity
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.fragment_comment_list.view.*
import org.hamcrest.Matcher
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CommentsListActivityTest {

    @get: Rule
    var activityRule: ActivityTestRule<CommentsActivity> = ActivityTestRule(CommentsActivity::class.java)

    @Test
    fun onShowAddCommentFragment() {
        Intents.init()
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.nameEditText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Intents.release()
    }

    @Test
    fun onAddCommentSaveClick() {
        Intents.init()
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.nameEditText)).perform(typeText("Name"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.dateEditText)).perform(typeText("Date"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.reviewEditText)).perform(typeText("Review"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.heart3)).perform(click())
        onView(withId(R.id.saveButton)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Intents.release()
    }

    @Test
    fun onScrollToBottom() {
        Intents.init()
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        val recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.rvComments)
        val itemCountStart = recyclerView.adapter!!.itemCount
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.nameEditText)).perform(typeText("Name"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.dateEditText)).perform(typeText("Date"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.reviewEditText)).perform(typeText("Review"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.heart3)).perform(click())
        onView(withId(R.id.saveButton)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.action_a)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rvComments))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(recyclerView.adapter!!.itemCount));
        assertEquals(itemCountStart + 1, recyclerView.adapter!!.itemCount)
        Intents.release()
    }
}