package com.example.android.phonenumberspinner;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class SpinnerSelectionTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void iterateSpinnerItems() {
        String[] spinnerLabels = activityTestRule.getActivity()
                .getResources().getStringArray(R.array.labels_array);
        for (String spinnerLabel : spinnerLabels) {
            onView(withId(R.id.label_spinner)).perform(click());
            onData(is(spinnerLabel)).perform(click());
            onView(withId(R.id.button_main)).perform(click());
            onView(withId(R.id.text_phonelabel)).check(ViewAssertions.matches(
                    withText(containsString(spinnerLabel))));
        }
    }
}
