package com.nakva.mvp.Login;

import android.support.test.rule.ActivityTestRule;

import com.nakva.mvp.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Juancho on 28/01/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class LoginActivityTest {


    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Test
    public void shouldShowErrorEmailEmpty() throws Exception {


        onView(withId(R.id.btn_login)).perform(click());
        onView(withText(R.string.error_empty_email))
                .check(matches(
                        allOf(withText(R.string.error_empty_email)
                                , isDisplayed())));

    }

    @Test
    public void shouldShowErrorEmailInvalid() throws Exception {

        onView(withId(R.id.input_email)).perform(typeText("asdf"));

        onView(withId(R.id.btn_login)).perform(click());
        onView(withText(R.string.email_invalido))
                .check(matches(
                        allOf(withText(R.string.email_invalido)
                                , isDisplayed())));

    }

    @Test
    public void shouldShowErrorPasswordInvalid() throws Exception {

        onView(withId(R.id.input_email)).perform(typeText("asdsad@asd.com"));
        onView(withId(R.id.input_password)).perform(typeText(""));

        onView(withId(R.id.btn_login)).perform(click());
        onView(withText(R.string.error_password_empty))
                .check(matches(
                        allOf(withText(R.string.error_password_empty)
                                , isDisplayed())));

    }

    @Test
    public void shouldShowErrorInternalServer() throws Exception {

        onView(withId(R.id.input_email)).perform(typeText("asdsad@asd.com"));
        onView(withId(R.id.input_password)).perform(typeText("internal"));

        onView(withId(R.id.btn_login)).perform(click());
        onView(withText(R.string.internal_error))
                .check(matches(
                        allOf(withText(R.string.internal_error)
                                , isDisplayed())));

    }
}
