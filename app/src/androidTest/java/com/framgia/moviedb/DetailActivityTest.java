package com.framgia.moviedb;

import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import com.framgia.moviedb.screen.main.MainActivity;
import java.util.concurrent.TimeUnit;
import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by anh on 12/10/2017.
 */

public class DetailActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private static final int ITEM_BELOW_THE_FOLD = 1;
    private static final int TIME_DELAY = 10000;
    private MainActivity mMainActivity;
    private IdlingResource mResource;

    public DetailActivityTest() {
        super(MainActivity.class);
    }

    @Before
    protected void setUp() throws Exception {
        super.setUp();
        mMainActivity = getActivity();
        IdlingPolicies.setMasterPolicyTimeout(TIME_DELAY * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(TIME_DELAY * 2, TimeUnit.MILLISECONDS);
        mResource = new ElapsedTimeIdlingResource(TIME_DELAY);
        IdlingRegistry.getInstance().register(mResource);
        onView(allOf(withId(R.id.recycler_movie), isCompletelyDisplayed())).check(
                matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, click()));
        IdlingRegistry.getInstance().unregister(mResource);
    }

    public void testClickTrailerMovie() {
        IdlingRegistry.getInstance().register(mResource);
        onView(allOf(withId(R.id.frame_youtube), isCompletelyDisplayed())).perform(click());
        IdlingRegistry.getInstance().unregister(mResource);
    }

    public void testClickListGenres() {
        IdlingRegistry.getInstance().register(mResource);
        onView(withId(R.id.recycler_genre)).perform(scrollTo(),
                RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, click()));
        IdlingRegistry.getInstance().unregister(mResource);
    }

    public void testButtonBack() {
        onView(isRoot()).perform(pressBack());
    }
}
