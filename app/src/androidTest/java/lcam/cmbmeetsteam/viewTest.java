package lcam.cmbmeetsteam;

import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.leoncam.cmbmeetsteam.R;
import com.leoncam.cmbmeetsteam.view.MainListView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class viewTest {
    @Rule
    public ActivityTestRule<MainListView> mainListViewTestRule =
            new ActivityTestRule<>(MainListView.class, true, false);

    @Before
    public void setUp() {
        mainListViewTestRule.launchActivity(new Intent());
    }

    @Test
    public void viewTeamMember() {
        // Verify team member is displayed
        onView(withText("Brian Fang")).check(matches(isDisplayed()));
        onView(withText("Android Developer")).check(matches(isDisplayed()));

        // Click an image at position 5
        onView(withId(R.id.rvMembers))
                .perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));

        // Verify team member detailed info is displayed
        onView(withText("Brian Fang")).check(matches(isDisplayed()));
        onView(withText("Android Developer")).check(matches(isDisplayed()));
        onView(withId(R.id.image_avatar_large))
                .check(matches(isDisplayed()));
    }
}
